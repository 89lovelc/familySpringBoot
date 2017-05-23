package com.hjh.cn.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 89lovelc on 2017/5/22.
 */
public class SceneVo implements Serializable {

    private String sceneId;

    private String sceneName;

    private String userName;

    private List<StepVo> stepList;

    public SceneVo() {
    }

    public SceneVo(String sceneId, String sceneName, String userName) {
        this.sceneId = sceneId;
        this.sceneName = sceneName;
        this.userName = userName;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public List<StepVo> getStepList() {
        return stepList;
    }

    public void setStepList(List<StepVo> stepList) {
        this.stepList = stepList;
    }
}
