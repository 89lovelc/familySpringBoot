package com.hjh.cn.service.impl;

import com.hjh.cn.dao.*;
import com.hjh.cn.domain.StepVo;
import com.hjh.cn.domain.SceneVo;
import com.hjh.cn.po.EquipmentPo;
import com.hjh.cn.po.RaspberryPo;
import com.hjh.cn.po.ScenePo;
import com.hjh.cn.po.StepPo;
import com.hjh.cn.service.SceneService;
import com.hjh.cn.step.Step;
import com.hjh.cn.step.StepChain;
import com.hjh.cn.step.impl.MotorStep;
import com.hjh.cn.step.impl.SwitchStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Autowired
    private SceneDao sceneDao;

    @Autowired
    private UserDao userDao;


   @Override
    public boolean operate(String sceneId) {
         //通过id 得到数据
        List<StepPo> list = stepDao.findBySceneId(sceneId);
        //得到stepPo 进行遍历 进行封装step
        StepPo  stepPo = null;
        StepChain chain = new StepChain();
        for (int i = 0; i < list.size(); i++) {
            stepPo = list.get(i);
            String contentStep = stepPo.getContent();
            String []strs = contentStep.split("\\|");
            //得到equipment  进行查询到设备
            EquipmentPo equipmentPo = equipmentDao.findById(strs[0]);
            //得到主从的树莓派
            RaspberryPo rasp = raspberryDao.findById(equipmentPo.getRaspberryId());

            Step step = null;
            if(equipmentPo.getEquipmentType().equals("开关")){
                step = new SwitchStep(stepPo.getSceneId(),stepPo.getStepId(),stepPo.getNextStepId(),rasp.getRaspberryIp(),equipmentPo.getEquipmentGpios(),strs[1]);
            }else if(equipmentPo.getEquipmentType().equals("步进电机")){
                step = new MotorStep(stepPo.getSceneId(),stepPo.getStepId(),stepPo.getNextStepId(),rasp.getRaspberryIp(),equipmentPo.getEquipmentGpios(),strs[1]);
            }

            //TODO 黄建辉 可以扩展
//            String stepDefineId = stepPo.getStepDefineId();
//            StepDefinePo stepDefinePo  = stepDefineDao.findById(stepDefineId);
//            String className = stepDefinePo.getStepDefineClass();
//
//            Class stepClass = null;
//            Step step = null;
//            try {
//                stepClass = Class.forName(className);
//                Constructor c = stepClass.getConstructor(String.class,String.class,String.class,String.class,String.class,String.class);
//                step = (Step) c.newInstance(stepPo.getSenceId(),stepPo.getStepId(),stepPo.getNextStepId(),rasp.getRaspberryIp(),equipmentPo.getEquipmentGpios(),strs[1]);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
            chain.addStep(step);
        }
        chain.doChain();
        return true;
    }

    @Override
    @Transactional
    public SceneVo saveVo(SceneVo sceneVo, String userId) {
        //进行保存
        ScenePo scenePo = new ScenePo();
        scenePo.setSceneName(sceneVo.getSceneName());
        scenePo.setSceneId(sceneVo.getSceneId());
        scenePo.setUserId(userId);
        String sceneId = sceneVo.getSceneId();
        if(sceneId == null || "".equalsIgnoreCase(sceneId)){
            sceneId = UUID.randomUUID().toString().replace("-","");
            scenePo.setSceneId(sceneId);
            sceneDao.save(scenePo);
        }else{
            sceneDao.save(scenePo);
            stepDao.deleteStepPoBySceneId(sceneVo.getSceneId());
        }

        List<StepVo> list = sceneVo.getStepList();
        StepPo stepPo = null;
        StepVo stepVo = null;
        String nextStepId = null;
        for (int i = 0; i < list.size(); i++) {
            stepVo  = list.get(i);
            if(i == 0){
                if(list.size()== (i +1)){
                    stepPo = new StepPo(sceneId,sceneId,null,stepVo.getEquipmentId()+"|"+stepVo.getContent().trim());
                }else{
                    nextStepId = UUID.randomUUID().toString().replace("-","");
                    stepPo = new StepPo(sceneId,sceneId,nextStepId,stepVo.getEquipmentId()+"|"+stepVo.getContent().trim());
                }
            }else if((i + 1) == list.size()){
                    stepPo = new StepPo(nextStepId,sceneId,null,stepVo.getEquipmentId()+"|"+stepVo.getContent().trim());
            }else{
                nextStepId = UUID.randomUUID().toString().replace("-","");
                stepPo = new StepPo(sceneId,sceneId,nextStepId,stepVo.getEquipmentId());;
            }
            stepDao.save(stepPo);
        }

        return sceneVo;
    }

    @Override
    public List<SceneVo> listAll() {
        List<ScenePo> list = sceneDao.listAll();
        List<SceneVo> sceneVos = new ArrayList<>();
        SceneVo sceneVo = null;
        ScenePo scenePo = null;
        StepPo step= null;
        for (int i = 0; i < list.size(); i++) {
            scenePo = list.get(i);
            String userName = userDao.findUserPoByUserId(scenePo.getUserId()).getUserName();
            sceneVo = new SceneVo(scenePo.getSceneId(),scenePo.getSceneName(),userName);

            List<StepPo> stepPos = stepDao.findBySceneId(scenePo.getSceneId());
            Map<String,StepPo> map = new HashMap<>();
            for (StepPo stepPo : stepPos) {
                map.put(stepPo.getStepId(),stepPo);
            }
            List<StepVo> stepVos = new ArrayList<>();
            step = map.get(scenePo.getSceneId());
            while(step != null){
                String []str =  step.getContent().split("\\|");
                EquipmentPo equipment = equipmentDao.findById(str[0]);
                stepVos.add(new StepVo(equipment.getEquipmentName(),str[1],str[0]));
                step = map.get(step.getNextStepId());
            }
            sceneVo.setStepList(stepVos);
            sceneVos.add(sceneVo);
        }
        return sceneVos;
    }

    /**
     * 通过id 进行删除
     * @param sceneId
     */
    @Override
    @Transactional
    public void delete(String sceneId) {
        sceneDao.delete(sceneId);
        stepDao.deleteStepPoBySceneId(sceneId);
    }


}
