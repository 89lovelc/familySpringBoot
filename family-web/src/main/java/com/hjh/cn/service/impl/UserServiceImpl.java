package com.hjh.cn.service.impl;

import com.hjh.cn.dao.UserDao;
import com.hjh.cn.domain.UserPo;
import com.hjh.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 89lovelc on 2017/5/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserPo validUser(String userName, String password) {
        UserPo userPo = userDao.queryByuserNameAndPassword(userName,password);
        return userPo;
    }
}
