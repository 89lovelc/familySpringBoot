package com.hjh.cn.service;

import com.hjh.cn.domain.UserPo;

/**
 * Created by 89lovelc on 2017/5/5.
 */
public interface UserService {

    UserPo validUser(String userName, String password);
}
