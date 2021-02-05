package com.yulaiz.fund.note.service.user.rest;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.user.entity.UserEntity;
import com.yulaiz.fund.note.service.user.service.UserService;
import com.yulaiz.fund.note.service.utils.RestResponse;
import com.yulaiz.fund.note.service.utils.RestResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRest {
    private static final Log log = LogFactory.get();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUserByPhone", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public RestResponse findUserByPhone(@RequestParam String userPhone) {
        log.info("==========>>ClassName: {}. MethodName:{}.", this.getClass().getName(), ThreadUtil.getStackTrace()[1].getMethodName());
        log.info("==========>>Params: userPhone:{}.", userPhone);
        UserEntity userEntity = this.userService.queryUserByPhone(userPhone);
        if (userEntity == null) {
            log.debug("无该用户");
            userEntity = new UserEntity();
            userEntity.setUserId(-1L);
        }
        RestResponse response = RestResponseBuilder.createSuccessBuilder(userEntity).builder();
        log.info("==========>>MethodName:{}, Rest:{}.", ThreadUtil.getStackTrace()[1].getMethodName(), JSONUtil.toJsonStr(response));
        return response;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse saveUser(@RequestBody UserEntity userEntity) {
        log.info("==========>>ClassName: {}. MethodName:{}.", this.getClass().getName(), ThreadUtil.getStackTrace()[1].getMethodName());
        log.info("==========>>Params: UserEntity:{}.", JSONUtil.toJsonStr(userEntity));
        this.userService.saveUser(userEntity);
        RestResponse response = RestResponseBuilder.createSuccessBuilder().builder();
        log.info("==========>>MethodName:{}, Rest:{}.", ThreadUtil.getStackTrace()[1].getMethodName(), JSONUtil.toJsonStr(response));
        return response;
    }
}
