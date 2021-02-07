package com.yulaiz.fund.note.service.note.service;

import com.yulaiz.fund.note.service.note.entity.NoteEntity;

import java.util.List;

public interface NoteService {
    /**
     * 获取用户账本列表
     *
     * @param userId
     * @return
     */
    List<NoteEntity> queryNoteListByUser(Long userId);
}
