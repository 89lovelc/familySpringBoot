package com.hjh.cn.service.impl;

import com.hjh.cn.dao.EquipmentDao;
import com.hjh.cn.dao.RaspberryDao;
import com.hjh.cn.dao.StepDao;
import com.hjh.cn.dao.StepDefineDao;
import com.hjh.cn.domain.EquipmentPo;
import com.hjh.cn.domain.RaspberryPo;
import com.hjh.cn.domain.StepDefinePo;
import com.hjh.cn.domain.StepPo;
import com.hjh.cn.service.SceneService;
import com.hjh.cn.step.Step;
import com.hjh.cn.step.StepChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 */
@Service
public class SceneServiceImpl implements SceneService{

    @Autowired
    private StepDao stepDao;

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private RaspberryDao raspberryDao;

    @Autowired
    private StepDefineDao stepDefineDao;


   @Override
    public boolean operate(String stepId) {
         //通过id 得到数据
        List<StepPo> list = stepDao.findByStepId(stepId);
        //得到stepPo 进行遍历 进行封装step
        StepPo  stepPo = null;
        StepChain chain = new StepChain();
        for (int i = 0; i < list.size(); i++) {
            stepPo = list.get(i);
            String contentStep = stepPo.getContentStep();
            String []strs = contentStep.split("|");
            //得到equipment  进行查询到设备
            EquipmentPo equipmentPo = equipmentDao.findById(strs[0]);
            //得到主从的树莓派
            RaspberryPo rasp = raspberryDao.findById(equipmentPo.getRaspberryId());
            String stepDefineId = stepPo.getStepDefineId();
            StepDefinePo stepDefinePo  = stepDefineDao.findById(stepDefineId);
            String className = stepDefinePo.getStepDefineClass();

            Class stepClass = null;
            Step step = null;
            try {
                stepClass = Class.forName(className);
                Constructor c = stepClass.getConstructor(String.class,String.class,String.class,String.class,String.class,String.class);
                step = (Step) c.newInstance(stepPo.getId(),stepPo.getStepId(),stepPo.getNextStepId(),rasp.getRaspberryIp(),equipmentPo.getEquipmentGpios(),strs[1]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            chain.addStep(step);
        }
        chain.doChain();
        return true;
    }
}
