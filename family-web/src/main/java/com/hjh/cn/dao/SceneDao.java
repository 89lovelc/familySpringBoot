package com.hjh.cn.dao;

import com.hjh.cn.po.ScenePo;
import com.hjh.cn.po.StepPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/20.
 */
@RepositoryRestResource(path = "scene")
public interface SceneDao extends JpaRepository<ScenePo,String>,JpaSpecificationExecutor<ScenePo>{
    @Query("from ScenePo")
    List<ScenePo> listAll();
}
