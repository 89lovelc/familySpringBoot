package com.hjh.cn.commom;

import com.pi4j.io.gpio.*;

import java.util.HashMap;

/**
 * Created by 89lovelc on 2017/5/10.
 */
public class GpioUtils {

    private static HashMap<String,GpioPinDigitalMultipurpose> gpioMap = new HashMap<>() ;
    private  static GpioUtils gpioMapper = new GpioUtils();

    private static final GpioPinDigitalMultipurpose GPIO_00;
    private static final GpioPinDigitalMultipurpose GPIO_01;
    private static final GpioPinDigitalMultipurpose GPIO_02;
    private static final GpioPinDigitalMultipurpose GPIO_03;
    private static final GpioPinDigitalMultipurpose GPIO_04;
    private static final GpioPinDigitalMultipurpose GPIO_05;
    private static final GpioPinDigitalMultipurpose GPIO_06;
    private static final GpioPinDigitalMultipurpose GPIO_07;
    private static final GpioPinDigitalMultipurpose GPIO_08;
    private static final GpioPinDigitalMultipurpose GPIO_09;
    private static final GpioPinDigitalMultipurpose GPIO_10;
    private static final GpioPinDigitalMultipurpose GPIO_11;
    private static final GpioPinDigitalMultipurpose GPIO_12;
    private static final GpioPinDigitalMultipurpose GPIO_13;
    private static final GpioPinDigitalMultipurpose GPIO_14;
    private static final GpioPinDigitalMultipurpose GPIO_15;
    private static final GpioPinDigitalMultipurpose GPIO_16;
    private GpioUtils(){}

    private static final GpioController gpio;

    public static GpioController controller(){
        return gpio;
    }

    static {
        gpio = GpioFactory.getInstance();
        gpioMap = new HashMap<>();
        GPIO_00 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_00, "GPIO_00", PinMode.DIGITAL_OUTPUT);
        GPIO_01 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_01, "GPIO_01", PinMode.DIGITAL_OUTPUT);
        GPIO_02 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_02, "GPIO_02", PinMode.DIGITAL_OUTPUT);
        GPIO_03 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_03, "GPIO_03", PinMode.DIGITAL_OUTPUT);
        GPIO_04 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_04, "GPIO_04", PinMode.DIGITAL_OUTPUT);
        GPIO_05 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_05, "GPIO_05", PinMode.DIGITAL_OUTPUT);
        GPIO_06 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_06, "GPIO_06", PinMode.DIGITAL_OUTPUT);
        GPIO_07 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_07, "GPIO_07", PinMode.DIGITAL_OUTPUT);
        GPIO_08 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_08, "GPIO_08", PinMode.DIGITAL_OUTPUT);
        GPIO_09 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_09, "GPIO_09", PinMode.DIGITAL_OUTPUT);
        GPIO_10 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_10, "GPIO_10", PinMode.DIGITAL_OUTPUT);
        GPIO_11 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_11, "GPIO_11", PinMode.DIGITAL_OUTPUT);
        GPIO_12 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_12, "GPIO_12", PinMode.DIGITAL_OUTPUT);
        GPIO_13 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_13, "GPIO_13", PinMode.DIGITAL_OUTPUT);
        GPIO_14 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_14, "GPIO_14", PinMode.DIGITAL_OUTPUT);
        GPIO_15 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_15, "GPIO_15", PinMode.DIGITAL_OUTPUT);
        GPIO_16 = gpio.provisionDigitalMultipurposePin(RaspiPin.GPIO_16, "GPIO_16", PinMode.DIGITAL_OUTPUT);
        gpioMap.put("GPIO_00", GPIO_00);
        gpioMap.put("GPIO_01", GPIO_01);
        gpioMap.put("GPIO_02", GPIO_02);
        gpioMap.put("GPIO_03", GPIO_03);
        gpioMap.put("GPIO_04", GPIO_04);
        gpioMap.put("GPIO_05", GPIO_05);
        gpioMap.put("GPIO_06", GPIO_06);
        gpioMap.put("GPIO_07", GPIO_07);
        gpioMap.put("GPIO_08", GPIO_08);
        gpioMap.put("GPIO_09", GPIO_09);
        gpioMap.put("GPIO_10", GPIO_10);
        gpioMap.put("GPIO_11", GPIO_11);
        gpioMap.put("GPIO_12", GPIO_12);
        gpioMap.put("GPIO_13", GPIO_13);
        gpioMap.put("GPIO_14", GPIO_14);
        gpioMap.put("GPIO_15", GPIO_15);
        gpioMap.put("GPIO_16", GPIO_16);
    }

    public static GpioUtils getInstance(){
        return gpioMapper;
    }



    public GpioPinDigitalMultipurpose getGpioPinDigitalMultipurpose(String gpio){
        return gpioMap.get(gpio);
    }

}
