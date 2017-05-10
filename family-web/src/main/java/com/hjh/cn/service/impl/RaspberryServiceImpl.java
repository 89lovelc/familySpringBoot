package com.hjh.cn.service.impl;

import com.hjh.cn.dao.EquipmentDao;
import com.hjh.cn.dao.RaspberryDao;
import com.hjh.cn.domain.RaspberryPo;
import com.hjh.cn.service.RaspberryService;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@Service
public class RaspberryServiceImpl implements RaspberryService {

    @Autowired
    private RaspberryDao raspberryDao;

    @Autowired
    private EquipmentDao equipmentDao;

    @Override
    public List<RaspberryPo> getData() {
        List<RaspberryPo> list = raspberryDao.findAll();
        RaspberryPo raspberryPo = null;
        for (int i = 0; i < list.size(); i++) {
            raspberryPo = list.get(i);
            String id = raspberryPo.getRaspberryId();
            int size =  equipmentDao.querySizeByRaspberryId(id);
            raspberryPo.setCount(size);
            //TODO 查看是否连接
            raspberryPo.setIsConnected("是");
        }
        return list;
    }
}
