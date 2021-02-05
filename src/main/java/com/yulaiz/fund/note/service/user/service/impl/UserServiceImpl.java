package com.yulaiz.fund.note.service.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.exception.FundNoteException;
import com.yulaiz.fund.note.service.user.dao.UserRepository;
import com.yulaiz.fund.note.service.user.entity.UserEntity;
import com.yulaiz.fund.note.service.user.entity.UserEntity_;
import com.yulaiz.fund.note.service.user.service.UserService;
import com.yulaiz.fund.note.service.utils.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        if (StrUtil.isBlank(userPhone)) {
            log.error("查找用户时参数为空");
            throw new FundNoteException("手机号不能为空");
        }
        Spec<UserEntity> spec = (root, predicates, criteriaBuilder) -> {
            predicates.add(criteriaBuilder.equal(root.get(UserEntity_.userPhone), userPhone));
        };
        Optional<UserEntity> userEntityOptional = this.userRepository.findOne(spec);
        return userEntityOptional.orElse(null);
    }

    /**
     * 保存用户
     *
     * @param userEntity
     */
    @Override
    public void saveUser(UserEntity userEntity) {
        if (userEntity == null) {
            log.error("保存用户时参数为空");
            throw new FundNoteException("用户不能为空");
        }
        if (userEntity.getUserId() != null) {
            Optional<UserEntity> old = this.userRepository.findById(userEntity.getUserId());
            if (!old.isPresent()) {
                log.warn("更新用户时指定用户ID不存在,转为新增");
                userEntity.setUserId(null);
            } else {
                BeanUtil.copyProperties(userEntity, old.get(), new CopyOptions().ignoreNullValue());
            }
        }
        if (userEntity.getCreateTime() == null) {
            userEntity.setCreateTime(new Date());
        }
        this.userRepository.save(userEntity);
    }
}
