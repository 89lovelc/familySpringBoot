package com.hjh.cn.device;

import com.hjh.cn.commom.GpioUtils;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.PinState;

/**
 *  开关处理类
 */
public class SwitchDeviceService {

    /**
     *
     *  true 为打开  false 为关闭
     * @return 得到现在的状态
     */
    public  boolean getStatus(String gpio){
        GpioPinDigitalMultipurpose gpioPinDigitalMultipurpose = GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpio);
        if(gpioPinDigitalMultipurpose.isHigh()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 反向
     * @param gpio
     * @return true为成功  false为失败
     */
     public boolean toggle(String gpio){
         GpioPinDigitalMultipurpose gpioPinDigitalMultipurpose = GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpio);
         PinState old = gpioPinDigitalMultipurpose.getState();
         gpioPinDigitalMultipurpose.toggle();
         if(gpioPinDigitalMultipurpose.getState() != old){
             return true;
         }
         return false;
     }


    /**
     * 打开
     * @param gpio
     */
     public void open(String gpio){
         GpioPinDigitalMultipurpose gpioPinDigitalMultipurpose = GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpio);
         gpioPinDigitalMultipurpose.high();
     }


    /**
     * 关闭
     * @param gpio
     */
     public void close(String gpio){
         GpioPinDigitalMultipurpose gpioPinDigitalMultipurpose = GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpio);
         gpioPinDigitalMultipurpose.low();
     }

}



