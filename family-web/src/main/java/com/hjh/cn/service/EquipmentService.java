package com.hjh.cn.service;

import com.hjh.cn.domain.EquipmentPo;
import com.hjh.cn.po.SwitchPo;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/10.
 */
public interface EquipmentService {
    List<EquipmentPo> getDatas();

    List<SwitchPo> getSwitchStatus();

    String switchOperate(SwitchPo switchPo);
}
