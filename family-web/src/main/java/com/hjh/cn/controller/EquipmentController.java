package com.hjh.cn.controller;

import com.hjh.cn.dao.EquipmentDao;
import com.hjh.cn.domain.EquipmentPo;
import com.hjh.cn.po.SwitchPo;
import com.hjh.cn.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/10.
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;


    @RequestMapping(path="getData",method = RequestMethod.GET)
    @ResponseBody
    public List<EquipmentPo> getData(){
        List<EquipmentPo> list = equipmentService.getDatas();
        return list;
    }

    @RequestMapping(path = "swithStatus" ,method = RequestMethod.GET)
    @ResponseBody
    public List<SwitchPo> getSwitchStatus(){
        List<SwitchPo> list = equipmentService.getSwitchStatus();
        return list;
    }


    @RequestMapping(path = "/switch/operate")
    @ResponseBody
    public String switchOperate(SwitchPo switchPo){
         return equipmentService.switchOperate(switchPo);
    }


}
