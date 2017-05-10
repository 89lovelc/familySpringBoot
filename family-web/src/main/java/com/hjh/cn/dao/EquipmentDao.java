package com.hjh.cn.dao;

import com.hjh.cn.domain.EquipmentPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@RepositoryRestResource(path = "equipment")
public interface EquipmentDao extends JpaRepository<EquipmentPo,String>,JpaSpecificationExecutor<EquipmentPo>{
    @Query("select count(1) from EquipmentPo where  paspberryId = :id")
    int querySizeByRaspberryId(@Param("id") String id);
}
