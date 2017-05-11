package com.hjh.cn.po;

import java.io.Serializable;

/**
 * Created by 89lovelc on 2017/5/11.
 */
public class SwitchPo implements Serializable {

    private String equipmentName;

    private boolean status;

    private String gpio;

    public SwitchPo() {
    }

    public SwitchPo(String equipmentName, boolean status, String gpio) {
        this.equipmentName = equipmentName;
        this.status = status;
        this.gpio = gpio;
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
}
