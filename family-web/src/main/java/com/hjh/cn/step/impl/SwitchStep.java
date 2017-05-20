package com.hjh.cn.step.impl;

import com.hjh.cn.step.Step;
import com.hjh.cn.tools.HttpClientUtils;

/**
 *
 * 处理开关类型的东西
 *
 *  对 contentStep 里面的内容进行处理
 *  Created by 89lovelc on 2017/5/20.
 *  content 只接受
 */
public class SwitchStep extends Step {
    @Override
    public void handle() {
        String content = this.getContent();
        try {
            HttpClientUtils.get("http://"+this.getRaspberryIp()+"/family-sub//switch/"+this.getGpios()+"/"+this.getContent(),null,null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
