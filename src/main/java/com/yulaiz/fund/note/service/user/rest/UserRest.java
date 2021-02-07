package com.yulaiz.fund.note.service.user.rest;

import com.yulaiz.fund.note.service.config.rest.response.RestResponse;
import com.yulaiz.fund.note.service.config.rest.response.RestResponseBuilder;
import com.yulaiz.fund.note.service.user.entity.UserEntity;
import com.yulaiz.fund.note.service.user.service.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findUserByPhone", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public RestResponse findUserByPhone(@RequestParam String userPhone) {
        UserEntity userEntity = this.userService.queryUserByPhone(userPhone);
        return RestResponseBuilder.createSuccessBuilder(userEntity).builder();
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse saveUser(@RequestBody UserEntity userEntity) {
        this.userService.saveUser(userEntity);
        return RestResponseBuilder.createSuccessBuilder().builder();
    }
}
