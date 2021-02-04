package com.yulaiz.fund.note.service.user.service;

import com.yulaiz.fund.note.service.user.entity.UserEntity;

public interface UserService {
    /**
     * 根据手机号查找用户
     *
     * @param userPhone
     * @return
     */
    UserEntity queryUserByPhone(String userPhone);
}
