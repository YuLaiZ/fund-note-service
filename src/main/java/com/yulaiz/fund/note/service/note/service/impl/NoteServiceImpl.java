package com.yulaiz.fund.note.service.note.service.impl;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.note.dao.NoteRepository;
import com.yulaiz.fund.note.service.note.entity.NoteEntity;
import com.yulaiz.fund.note.service.note.entity.NoteEntity_;
import com.yulaiz.fund.note.service.note.service.NoteService;
import com.yulaiz.fund.note.service.utils.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private static final Log log = LogFactory.get();

    @Autowired
    private NoteRepository noteRepository;

    /**
     * 获取用户账本列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<NoteEntity> queryNoteListByUser(Long userId) {
        if (userId == null || userId <= 0) {
            return null;
        }
        Spec<NoteEntity> spec = (root, predicates, criteriaBuilder) -> {
            predicates.add(criteriaBuilder.equal(root.get(NoteEntity_.userId), userId));
        };
        return this.noteRepository.findAll(spec);
    }
}
