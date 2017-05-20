package com.hjh.cn.dao;

import com.hjh.cn.domain.StepPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/20.
 */
@RepositoryRestResource(path = "step")
public interface StepDao extends JpaRepository<StepPo,String>,JpaSpecificationExecutor<StepPo>{

    @Query("from StepPo  where stepId = :stepId")
    List<StepPo> findByStepId(@Param("stepId") String stepId);
}
