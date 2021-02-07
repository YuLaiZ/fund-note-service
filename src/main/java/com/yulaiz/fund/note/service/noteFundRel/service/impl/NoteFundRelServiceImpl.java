package com.yulaiz.fund.note.service.noteFundRel.service.impl;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.noteFundRel.dao.NoteFundRelRepository;
import com.yulaiz.fund.note.service.noteFundRel.entity.NoteFundRelEntity;
import com.yulaiz.fund.note.service.noteFundRel.entity.NoteFundRelEntity_;
import com.yulaiz.fund.note.service.noteFundRel.service.NoteFundRelService;
import com.yulaiz.fund.note.service.utils.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteFundRelServiceImpl implements NoteFundRelService {
    private static final Log log = LogFactory.get();

    @Autowired
    private NoteFundRelRepository noteFundRelRepository;

    /**
     * 获取账本基金列表
     *
     * @param noteId
     * @return
     */
    @Override
    public List<NoteFundRelEntity> queryNoteFundRelListById(Long noteId) {
        if (noteId == null || noteId <= 0) {
            return null;
        }
        Spec<NoteFundRelEntity> spec = (root, predicates, criteriaBuilder) -> {
            predicates.add(criteriaBuilder.equal(root.get(NoteFundRelEntity_.noteId), noteId));
        };
        return this.noteFundRelRepository.findAll(spec);
    }
}
