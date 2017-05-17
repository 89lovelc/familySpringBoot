package com.hjh.cn.dao;

import com.hjh.cn.domain.CameraPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by 89lovelc on 2017/5/16.
 */
@RepositoryRestResource(path="camera")
public interface CameraDao extends JpaRepository<CameraPo,String>,JpaSpecificationExecutor<CameraPo> {

    @Query("from CameraPo")
    public List<CameraPo> listAll();

}
