package com.hjh.cn.dao;

import com.hjh.cn.domain.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by 89lovelc on 2017/5/5.
 */
@RepositoryRestResource(path = "user")
public interface UserDao extends JpaRepository<UserPo,String>, JpaSpecificationExecutor<UserPo> {

    @Query(" from UserPo where userName = :userName and userPassword = :password ")
    UserPo queryByuserNameAndPassword(@Param("userName") String  userName,@Param("password") String password);
}
