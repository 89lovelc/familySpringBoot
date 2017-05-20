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
@Table(name = "family_step")
@GenericGenerator(name = "system-uuid", strategy = "uuid")
public class StepPo extends ParentPo{

    @Id
    @GeneratedValue(generator = "system-uuid")
    private String id;

    private String stepId;

    private String nextStepId;

    //定义的东西 为  equipmentId|content   使用 | 隔开
    private String contentStep;

    private String stepDefineId;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContentStep() {
        return contentStep;
    }

    public void setContentStep(String contentStep) {
        this.contentStep = contentStep;
    }

    public String getStepDefineId() {
        return stepDefineId;
    }

    public void setStepDefineId(String stepDefineId) {
        this.stepDefineId = stepDefineId;
    }

}
