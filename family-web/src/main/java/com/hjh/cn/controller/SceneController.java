package com.hjh.cn.controller;

import com.hjh.cn.domain.SceneVo;
import com.hjh.cn.po.UserPo;
import com.hjh.cn.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 89lovelc on 2017/5/20.
 */
@RestController
@RequestMapping("scene")
public class SceneController {


    @Autowired
    private SceneService sceneService;

    /**
     * 进行情景模式的操作
     * @param id
     * @return
     */
    @RequestMapping("/operater/open/{id}")
    @ResponseBody
    public String openOne(@PathVariable String id){
        boolean tj = sceneService.operate(id);
       return "success";
    }


    @PostMapping("/save")
    @ResponseBody
    public SceneVo saveStep(@RequestBody SceneVo sceneVo, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserPo user = (UserPo) session.getAttribute("user");
        SceneVo sceneVo1= sceneService.saveVo(sceneVo,user.getUserId());
        return sceneVo1;
    }

    @GetMapping("/listAll")
    @ResponseBody
    public List<SceneVo> getAll(){
        List<SceneVo> list = sceneService.listAll();
        return list;
    }


    @GetMapping("/delete/{sceneId}")
    @ResponseBody
    public String delete(@PathVariable("sceneId") String sceneId){
        sceneService.delete(sceneId);
        return "success";
    }


}
