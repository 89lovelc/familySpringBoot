package com.hjh.cn.domain;

import java.io.Serializable;

/**
 * Created by 89lovelc on 2017/5/22.
 */
public class StepVo implements Serializable {

    private String equipmentName;

    private String content;

    private String equipmentId;


    public StepVo() {
    }

    public StepVo(String equipmentName, String content, String equipmentId) {
        this.equipmentName = equipmentName;
        this.content = content;
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
}
