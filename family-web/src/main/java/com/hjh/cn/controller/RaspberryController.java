package com.hjh.cn.controller;

import com.hjh.cn.domain.RaspberryPo;
import com.hjh.cn.service.RaspberryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@RestController
@RequestMapping("raspberry")
public class RaspberryController {

    @Autowired
    private RaspberryService raspberryService;

    @RequestMapping(path = "getData",method = RequestMethod.GET)
    @ResponseBody
    public List<RaspberryPo>  getData(){
        List<RaspberryPo> list = raspberryService.getData();
        return list;
    }

}
