package com.hjh.cn.dao;

import com.hjh.cn.po.StepDefinePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by 89lovelc on 2017/5/20.
 */
@RepositoryRestResource(path = "stepDefine")
public interface StepDefineDao extends JpaRepository<StepDefinePo,String>,JpaSpecificationExecutor<StepDefinePo> {

    @Query("from StepDefinePo where stepDefineId = :stepDefineId")
    StepDefinePo findById(@Param("stepDefineId") String stepDefineId);
}
