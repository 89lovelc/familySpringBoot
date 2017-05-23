package com.hjh.cn.step;

/**
 * Created by 89lovelc on 2017/5/20.
 */
public abstract class Step {

    private String senceId;

    private String stepId;

    private String nextStepId;

    private String raspberryIp;

    private String gpios;

    private String content;

    public Step(){};

    public Step(String senceId, String stepId, String nextStepId, String raspberryIp, String gpios, String content) {
        this.senceId = senceId;
        this.stepId = stepId;
        this.nextStepId = nextStepId;
        this.raspberryIp = raspberryIp;
        this.gpios = gpios;
        this.content = content;
    }


    public String getSenceId() {
        return senceId;
    }

    public void setSenceId(String senceId) {
        this.senceId = senceId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getNextStepId() {
        return nextStepId;
    }

    public void setNextStepId(String nextStepId) {
        this.nextStepId = nextStepId;
    }

    public String getRaspberryIp() {
        return raspberryIp;
    }

    public void setRaspberryIp(String raspberryIp) {
        this.raspberryIp = raspberryIp;
    }

    public String getGpios() {
        return gpios;
    }

    public void setGpios(String gpios) {
        this.gpios = gpios;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract void handle() ;
}
