package com.hjh.cn.device;

import com.hjh.cn.commom.GpioUtils;
import com.pi4j.component.motor.impl.GpioStepperMotorComponent;
import com.pi4j.io.gpio.*;

/**
 * 步进电机操作
 * Created by 89lovelc on 2017/5/21.
 */
public class StepperMotorGpioService {


    private GpioStepperMotorComponent init(String [] gpios){
        final GpioPinDigitalOutput[] pins = {
                GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpios[0]),
                GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpios[1]),
                GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpios[2]),
                GpioUtils.getInstance().getGpioPinDigitalMultipurpose(gpios[3])
        };
        GpioUtils.controller().setShutdownOptions(true, PinState.LOW, pins);
        GpioStepperMotorComponent motor = new GpioStepperMotorComponent(pins);
        byte[] double_step_sequence = new byte[4];
        double_step_sequence[0] = (byte) 0b0011;
        double_step_sequence[1] = (byte) 0b0110;
        double_step_sequence[2] = (byte) 0b1100;
        double_step_sequence[3] = (byte) 0b1001;
        motor.setStepInterval(20);
        motor.setStepSequence(double_step_sequence);
        motor.setStepsPerRevolution(2048);
        return motor;
    }

    /**
     * 操作
     * @param str
     * @param rotate
     */
    public void operate(String []str ,double rotate){
        GpioStepperMotorComponent motor = init(str);
        System.out.println(motor);
        motor.rotate(rotate);
        motor.stop();
    }

}
