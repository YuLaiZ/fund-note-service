package com.yulaiz.fund.note.service.noteFundRecord.dao;

import com.yulaiz.fund.note.service.noteFundRecord.entity.NoteFundRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoteFundRecordRepository extends JpaRepository<NoteFundRecordEntity, Long>, JpaSpecificationExecutor<NoteFundRecordEntity> {
}
