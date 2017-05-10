package com.hjh.cn;

import com.hjh.cn.dao.UserDao;
import com.hjh.cn.domain.UserPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 89lovelc on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes =Application.class)
public class TestCRUD {

    @Autowired
    private UserDao userDao;

    @Test
    public void saveUser(){
        UserPo user = new UserPo();

        user.setUserName("123");
        user.setUserPassword("123");
        userDao.save(user);

    }

}
