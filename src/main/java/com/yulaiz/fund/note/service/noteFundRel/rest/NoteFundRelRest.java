package com.yulaiz.fund.note.service.noteFundRel.rest;

import cn.hutool.core.util.StrUtil;
import com.yulaiz.fund.note.service.config.rest.response.RestResponse;
import com.yulaiz.fund.note.service.config.rest.response.RestResponseBuilder;
import com.yulaiz.fund.note.service.noteFundRel.entity.NoteFundRelEntity;
import com.yulaiz.fund.note.service.noteFundRel.service.NoteFundRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/noteFundRel")
public class NoteFundRelRest {

    @Autowired
    private NoteFundRelService noteFundRelService;

    @RequestMapping(value = "/queryNoteFundRelListById", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public RestResponse queryNoteFundRelListById(@RequestParam String noteId) {
        if (StrUtil.isBlank(noteId)) {
            return RestResponseBuilder.createFailBuilder("账本ID不能为空").builder();
        }
        List<NoteFundRelEntity> list = this.noteFundRelService.queryNoteFundRelListById(Long.parseLong(noteId));
        return RestResponseBuilder.createSuccessBuilder(list).builder();
    }

}
