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

    @Override
    public UserPo saveProfile(UserPo userPo) {
        UserPo old  = userDao.findOne(userPo.getUserId());
        userPo.setUserPassword(old.getUserPassword());
        userPo.setAvatar(old.getAvatar());
        userDao.save(userPo);
        return userPo;
    }

    @Override
    public boolean changePwd(String userId, String pwd) {
        UserPo user = userDao.findOne(userId );
        user.setUserPassword(pwd);
        userDao.save(user);
        return true;
    }

    @Override
    public UserPo saveAvatar(String fileName, UserPo user) {
        UserPo u = userDao.findOne(user.getUserId() );
        u.setAvatar(fileName);
        userDao.save(u);
        return u;
    }
}
