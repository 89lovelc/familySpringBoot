package com.hjh.cn.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 89lovelc on 2017/5/16.
 */
@Entity
@Table(name = "family_camera")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class CameraPo extends ParentPo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private String cameraId;

    private String cameraName;

    private String cameraIp;


    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }

    public String getCameraIp() {
        return cameraIp;
    }

    public void setCameraIp(String cameraIp) {
        this.cameraIp = cameraIp;
    }

    public String getCameraName() {
        return cameraName;
    }

    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }
}
