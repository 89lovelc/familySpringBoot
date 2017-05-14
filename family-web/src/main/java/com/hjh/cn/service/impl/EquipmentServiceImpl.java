package com.hjh.cn.service.impl;

import com.hjh.cn.dao.EquipmentDao;
import com.hjh.cn.dao.RaspberryDao;
import com.hjh.cn.device.SwitchDeviceService;
import com.hjh.cn.domain.EquipmentPo;
import com.hjh.cn.domain.RaspberryPo;
import com.hjh.cn.po.SwitchPo;
import com.hjh.cn.service.EquipmentService;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 89lovelc on 2017/5/10.
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {


    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private RaspberryDao raspberryDao;

    private SwitchDeviceService switchDeviceService = new SwitchDeviceService();


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
//            boolean status =  switchDeviceService.getStatus(equipmentPo.getEquipmentGpios());
//            switchPos.add(new SwitchPo(equipmentPo.getEquipmentName(),status,equipmentPo.getEquipmentGpios()));
            switchPos.add(new SwitchPo(equipmentPo.getEquipmentName(),true,equipmentPo.getEquipmentGpios()));


        }
        return switchPos;
    }

    @Override
    public boolean switchOperate(SwitchPo switchPo) {
        return switchDeviceService.toggle(switchPo.getGpio());
    }
}
