package com.hjh.cn.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@Entity
@Table(name = "family_raspberry")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class RaspberryPo extends  ParentPo{

    @Id
    @GeneratedValue(generator = "system-uuid")
    private String raspberryId;

    private String raspberryName;

    private String raspberryIp;

    @Transient
    private String isConnected;

    @Transient
    private int count;

    public String getRaspberryId() {
        return raspberryId;
    }

    public void setRaspberryId(String raspberryId) {
        this.raspberryId = raspberryId;
    }

    public String getRaspberryName() {
        return raspberryName;
    }

    public void setRaspberryName(String raspberryName) {
        this.raspberryName = raspberryName;
    }

    public String getRaspberryIp() {
        return raspberryIp;
    }

    public void setRaspberryIp(String raspberryIp) {
        this.raspberryIp = raspberryIp;
    }

    public String getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(String isConnected) {
        this.isConnected = isConnected;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
