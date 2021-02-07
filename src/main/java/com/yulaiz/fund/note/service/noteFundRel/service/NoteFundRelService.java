package com.yulaiz.fund.note.service.noteFundRel.service;

import com.yulaiz.fund.note.service.noteFundRel.entity.NoteFundRelEntity;

import java.util.List;

public interface NoteFundRelService {
    /**
     * 获取账本基金列表
     *
     * @param noteId
     * @return
     */
    List<NoteFundRelEntity> queryNoteFundRelListById(Long noteId);
}
