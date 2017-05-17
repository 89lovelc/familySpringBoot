package com.hjh.cn.service.impl;

import com.hjh.cn.dao.EquipmentDao;
import com.hjh.cn.dao.RaspberryDao;
import com.hjh.cn.domain.EquipmentPo;
import com.hjh.cn.domain.RaspberryPo;
import com.hjh.cn.po.SwitchPo;
import com.hjh.cn.service.EquipmentService;
import com.hjh.cn.tools.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {


    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private RaspberryDao raspberryDao;



    @Override
    public List<EquipmentPo> getDatas() {
        List<EquipmentPo> list = equipmentDao.findAll();
        EquipmentPo equipmentPo = null;
        for (int i = 0; i < list.size(); i++) {
            equipmentPo =  list.get(i);
            RaspberryPo raspberryPo =  raspberryDao.findOne(equipmentPo.getRaspberryId());
            equipmentPo.setRaspberryPo(raspberryPo);
        }
        return list;
    }

    @Override
    public List<SwitchPo> getSwitchStatus() {
        List<EquipmentPo> list = equipmentDao.findByEquipmentType("开关");
        EquipmentPo equipmentPo = null;
        List<SwitchPo> switchPos = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            equipmentPo = list.get(i);
            //TODO 黄建辉
            //得到主机的ip 进行访问
            RaspberryPo rasp = raspberryDao.findById(equipmentPo.getRaspberryId());
            //进行get 请求 询问id 的状态
            //TODO 黄建辉
            String url = "http://"+rasp.getRaspberryIp()+"/family-sub/switch/status?gpios="+equipmentPo.getEquipmentGpios();
            try {
               String result =  HttpClientUtils.get(url,null,null,null);
               boolean status = result.equals("true") ? true :false;
               switchPos.add(new SwitchPo(equipmentPo.getEquipmentName(),status,equipmentPo.getEquipmentGpios(),rasp.getRaspberryIp()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return switchPos;
    }

    @Override
    public String switchOperate(SwitchPo switchPo) {
        String url = "http://"+switchPo.getRaspberryIp()+"/family-sub/switch/toggle/gpios="+switchPo.getGpio();
        try {
           return HttpClientUtils.get(url,null,null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }
}
