package com.hjh.cn.dao;

import com.hjh.cn.domain.RaspberryPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by 89lovelc on 2017/5/7.
 */
@RepositoryRestResource(path = "rasp")
public interface RaspberryDao  extends JpaRepository<RaspberryPo,String> , JpaSpecificationExecutor<RaspberryPo>{
}
