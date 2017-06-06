package com.hjh.cn.controller;

import com.hjh.cn.commom.GpioUtils;
import com.hjh.cn.device.DHT11Service;
import com.hjh.cn.device.StepperMotorGpioService;
import com.hjh.cn.device.SwitchDeviceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by 89lovelc on 2017/5/16.
 *
 *
 */
@RestController
public class EquipmentController {

    GpioUtils gpioUtils =  GpioUtils.getInstance();

    SwitchDeviceService switchDeviceService = new SwitchDeviceService();
    DHT11Service dht11Service = new DHT11Service();
    StepperMotorGpioService stepperMotorGpioService = new StepperMotorGpioService();

    //http://"+rasp.getRaspberryIp()+"/family-sub/switch/status?gpios="+equipmentPo.getEquipmentGpios()
    @RequestMapping("/switch/status")
    @ResponseBody
    public String switchStatus(String gpios){
        boolean status = switchDeviceService.getStatus(gpios);
        return status +"";
    }

    @RequestMapping("/switch/operate")
    @ResponseBody
    public String toggle(String gpios){
        boolean status = switchDeviceService.toggle(gpios);
        return status +"";
    }


    @RequestMapping("/switch/{gpios}/{status}")
    @ResponseBody
    public String toggle(@PathVariable("gpios") String gpios, @PathVariable("status") String status){
        if("true".equals(status)){
            switchDeviceService.open(gpios);
        }else{
            switchDeviceService.close(gpios);
        }
        return status +"";
    }


    @RequestMapping("/dht/data")
    @ResponseBody
    public Map<String,String> dhtData(String gpio){
        Map<String, String> map = dht11Service.getData(Integer.parseInt(gpio));
        return map;
    }



    @RequestMapping("/motor/operate/{gpios}/{rotate}")
    @ResponseBody
    public String  motorOperate(@PathVariable("gpios") String gpios,@PathVariable("rotate") double rotate){
        System.out.println(gpios);
        System.out.println(rotate);
        stepperMotorGpioService.operate(gpios.split("\\|"),rotate);
        return "success";
    }

}