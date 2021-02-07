package com.yulaiz.fund.note.service.noteFundRel.dao;

import com.yulaiz.fund.note.service.noteFundRel.entity.NoteFundRelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoteFundRelRepository extends JpaRepository<NoteFundRelEntity, Long>, JpaSpecificationExecutor<NoteFundRelEntity> {
}
