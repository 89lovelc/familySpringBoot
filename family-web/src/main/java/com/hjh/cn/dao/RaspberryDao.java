package com.hjh.cn.dao;

import com.hjh.cn.po.RaspberryPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@RepositoryRestResource(path = "rasp")
public interface RaspberryDao  extends JpaRepository<RaspberryPo,String> , JpaSpecificationExecutor<RaspberryPo>{
    @Query("from RaspberryPo")
    List<RaspberryPo> listAll();

    @Query("from RaspberryPo  where raspberryId = :raspberryId")
    RaspberryPo findById(@Param("raspberryId") String raspberryId);
}
