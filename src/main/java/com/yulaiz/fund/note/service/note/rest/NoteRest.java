package com.yulaiz.fund.note.service.note.rest;

import cn.hutool.core.util.StrUtil;
import com.yulaiz.fund.note.service.config.rest.response.RestResponse;
import com.yulaiz.fund.note.service.config.rest.response.RestResponseBuilder;
import com.yulaiz.fund.note.service.note.entity.NoteEntity;
import com.yulaiz.fund.note.service.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteRest {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/queryNoteListByUser", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public RestResponse queryNoteListByUser(@RequestParam String userId) {
        if (StrUtil.isBlank(userId)) {
            return RestResponseBuilder.createFailBuilder("用户ID不能为空").builder();
        }
        List<NoteEntity> list = this.noteService.queryNoteListByUser(Long.parseLong(userId));
        return RestResponseBuilder.createSuccessBuilder(list).builder();
    }
}
