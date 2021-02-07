package com.yulaiz.fund.note.service.fund.dao;

import com.yulaiz.fund.note.service.fund.entity.FundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FundRepository extends JpaRepository<FundEntity, Long>, JpaSpecificationExecutor<FundEntity> {
}
