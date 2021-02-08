package com.yulaiz.fund.note.service.fundValuation.dao;

import com.yulaiz.fund.note.service.fundValuation.entity.FundValuationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FundValuationRepository extends JpaRepository<FundValuationEntity, Long>, JpaSpecificationExecutor<FundValuationEntity> {

}
