package com.hjh.cn.controller;

import com.hjh.cn.MusicFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by 89lovelc on 2017/5/20.
 */
@RestController
public class MusicController {



    @RequestMapping("music/pause")
    @ResponseBody
    public String pause(){
        MusicFactory.pause();
        return "success";
    }

    @RequestMapping("music/resume")
    @ResponseBody
    public String resume(){
        MusicFactory.resume();
        return "success";
    }


    @RequestMapping("music/play")
    @ResponseBody
    public String play(String url){
        try {
            //TODO 黄建辉 硬编码
            String str = "http://localhost:8330/family/files/"+url;
            MusicFactory.load(new URL(str));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        MusicFactory.play();
        return "success";
    }

    @RequestMapping("music/deep")
    @ResponseBody
    public String play(int deep){
        MusicFactory.deep(deep);
        return "success";
    }

}
