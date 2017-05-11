package com.hjh.cn.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@Entity
@Table(name = "family_equipment")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class EquipmentPo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private String equipmentId;

    private String equipmentName;

    private String equipmentType;

    private String  equipmentGpios;

    private String raspberryId;

    @Transient
    private boolean  status;


    @Transient
    private RaspberryPo raspberryPo;


    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentGpios() {
        return equipmentGpios;
    }

    public void setEquipmentGpios(String equipmentGpios) {
        this.equipmentGpios = equipmentGpios;
    }

    public String getRaspberryId() {
        return raspberryId;
    }

    public void setRaspberryId(String raspberryId) {
        this.raspberryId = raspberryId;
    }

    public RaspberryPo getRaspberryPo() {
        return raspberryPo;
    }

    public void setRaspberryPo(RaspberryPo raspberryPo) {
        this.raspberryPo = raspberryPo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
