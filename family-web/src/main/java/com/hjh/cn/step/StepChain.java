package com.hjh.cn.step;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 89lovelc on 2017/5/20.
 */
public class StepChain {

    //<stepId,<Step,nextStepId>>
    private Map<String,Step> map = new HashMap<>();

    private StepChain chain =  new StepChain();

    public StepChain(){}


    public StepChain(Step step){
        this.addStep(step);
    }

    public StepChain addStep(Step step){
        if(step != null){
            map.put(step.getStepId(),step);
        }
        return this;
    }


    public void doChain(){
        Step  step  = null;
        String nextStepId = null;

        //得到第一个链条
        if(map != null && map.size() > 0){
            for (Map.Entry<String,Step> entry : map.entrySet() ){
                 step  = entry.getValue();
                 if(step.getStepId() == step.getId()){
                    break;
                 }
            }
        }
        //持续 处理
        while(step != null){
            step.handle();
            nextStepId = step.getNextStepId();
            step = map.get(nextStepId);
        }
    }

}
