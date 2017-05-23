package com.hjh.cn.domain;

import java.io.Serializable;

/**
 * Created by 89lovelc on 2017/5/11.
 */
public class SwitchVo implements Serializable {

    private String equipmentName;

    private boolean status;

    private String gpio;

    private String raspberryIp;

    public SwitchVo() {
    }

    public SwitchVo(String equipmentName, boolean status, String gpio, String raspberryIp) {
        this.equipmentName = equipmentName;
        this.status = status;
        this.gpio = gpio;
        this.raspberryIp = raspberryIp;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getGpio() {
        return gpio;
    }

    public void setGpio(String gpio) {
        this.gpio = gpio;
    }

    public String getRaspberryIp() {
        return raspberryIp;
    }

    public void setRaspberryIp(String raspberryIp) {
        this.raspberryIp = raspberryIp;
    }
}
