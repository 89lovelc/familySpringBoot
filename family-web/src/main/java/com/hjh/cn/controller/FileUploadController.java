package com.hjh.cn.controller;

import com.hjh.cn.domain.UserPo;
import com.hjh.cn.service.UserService;
import com.hjh.cn.storage.StorageFileNotFoundException;
import com.hjh.cn.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    @Autowired
    private  StorageService storageService;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("music/list")
    @ResponseBody
    public List<String> listMusicFiles(){
        List<String> musicList = storageService.getMusicList();
        return musicList;
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }


    @PostMapping("/upload/avatar")
    public String handleUserAvatar(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        String fileName = storageService.store(file);
        HttpSession session = request.getSession();
        UserPo user = (UserPo) session.getAttribute("user");
        UserPo u = userService.saveAvatar(fileName,user);
        session.setAttribute("user",u);

        return "redirect:/fmr/person/profile-edit";
    }

    @PostMapping("upload/music")
    public String uploadMusic(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        storageService.storDirect(file);
        return "redirect:/fmr/index";
    }


    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
