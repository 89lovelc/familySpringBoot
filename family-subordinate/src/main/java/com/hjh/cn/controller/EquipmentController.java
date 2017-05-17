package com.hjh.cn.controller;

import com.hjh.cn.device.SwitchDeviceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 89lovelc on 2017/5/16.
 *
 *
 */
@RestController
public class EquipmentController {




    //http://"+rasp.getRaspberryIp()+"/family-sub/switch/status?gpios="+equipmentPo.getEquipmentGpios()
    @RequestMapping("/switch/status")
    @ResponseBody
    public String switchStatus(String gpios){
        SwitchDeviceService switchDeviceService = new SwitchDeviceService();
        boolean status = switchDeviceService.getStatus(gpios);
        return status +"";
    }


}
