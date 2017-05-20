package com.hjh.cn.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 89lovelc on 2017/5/20.
 */
@Entity
@Table(name = "family_step_define")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class StepDefinePo {


    @Id
    @GeneratedValue(generator = "system-uuid")
    private String stepDefineId;

    private String stepDefineName;

    private String stepDefineClass;

    public String getStepDefineId() {
        return stepDefineId;
    }

    public void setStepDefineId(String stepDefineId) {
        this.stepDefineId = stepDefineId;
    }

    public String getStepDefineName() {
        return stepDefineName;
    }

    public void setStepDefineName(String stepDefineName) {
        this.stepDefineName = stepDefineName;
    }

    public String getStepDefineClass() {
        return stepDefineClass;
    }

    public void setStepDefineClass(String stepDefineClass) {
        this.stepDefineClass = stepDefineClass;
    }
}
