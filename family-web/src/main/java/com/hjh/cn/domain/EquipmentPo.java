package com.hjh.cn.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@Entity
@Table(name = "family_equipment")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class EquipmentPo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private String equipmmentId;

    private String equipmentName;

    private String equipmentType;

    private String  equipmentGpios;

    private String paspberryId;

    public String getEquipmmentId() {
        return equipmmentId;
    }

    public void setEquipmmentId(String equipmmentId) {
        this.equipmmentId = equipmmentId;
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

    public String getPaspberryId() {
        return paspberryId;
    }

    public void setPaspberryId(String paspberryId) {
        this.paspberryId = paspberryId;
    }
}
