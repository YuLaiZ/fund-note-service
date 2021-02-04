package com.yulaiz.fund.note.service.user.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.user.dao.UserRepository;
import com.yulaiz.fund.note.service.user.entity.UserEntity;
import com.yulaiz.fund.note.service.user.entity.UserEntity_;
import com.yulaiz.fund.note.service.user.service.UserService;
import com.yulaiz.fund.note.service.utils.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Log log = LogFactory.get();

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据手机号查找用户
     *
     * @param userPhone
     * @return
     */
    @Override
    public UserEntity queryUserByPhone(String userPhone) {
        Spec<UserEntity> spec = (root, predicates, criteriaBuilder) -> {
            if (StrUtil.isBlank(userPhone)) {
                predicates.add(criteriaBuilder.equal(root.get(UserEntity_.userPhone), userPhone));
            }
        };
        Optional<UserEntity> userEntityOptional = this.userRepository.findOne(spec);
        return userEntityOptional.orElse(null);
    }
}
