package com.hjh.cn.service;

import com.hjh.cn.domain.SceneVo;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 89lovelc on 2017/5/20.
 */
public interface SceneService {
     boolean operate(String id);

    @Transactional
    SceneVo saveVo(SceneVo sceneVo, String userId);

    List<SceneVo> listAll();

    @Transactional
    void delete(String sceneId);
}
