package com.hjh.cn.po;

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
public class StepPo extends ParentPo{

    @Id
    private String stepId;


    private String sceneId;


    private String nextStepId;

    //定义的东西 为  equipmentId|content   使用 | 隔开
    private String content;

//    private String stepDefineId;


    public StepPo() {
    }

    public StepPo(String stepId, String sceneId, String nextStepId, String content) {
        this.stepId = stepId;
        this.sceneId = sceneId;
        this.nextStepId = nextStepId;
        this.content = content;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getNextStepId() {
        return nextStepId;
    }

    public void setNextStepId(String nextStepId) {
        this.nextStepId = nextStepId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
