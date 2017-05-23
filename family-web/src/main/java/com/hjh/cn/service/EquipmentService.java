package com.hjh.cn.service;

import com.hjh.cn.po.EquipmentPo;
import com.hjh.cn.domain.SwitchVo;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/10.
 */
public interface EquipmentService {
    List<EquipmentPo> getDatas();

    List<SwitchVo> getSwitchStatus();

    String switchOperate(SwitchVo switchPo);
}
