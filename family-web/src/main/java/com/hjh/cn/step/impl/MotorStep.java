package com.hjh.cn.step.impl;

import com.hjh.cn.step.Step;
import com.hjh.cn.tools.HttpClientUtils;

/**
 * Created by 89lovelc on 2017/5/24.
 */
public class MotorStep extends Step {
    public MotorStep(){}
    public MotorStep(String senceId, String stepId, String nextStepId, String raspberryIp, String gpios, String content) {
        super(senceId, stepId, nextStepId, raspberryIp, gpios, content);
    }

    @Override
    public void handle() {
        String content = this.getContent();
        try {
            HttpClientUtils.get("http://"+this.getRaspberryIp()+"/family-sub/motor/operate"+this.getGpios()+"/"+this.getContent(),null,null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
