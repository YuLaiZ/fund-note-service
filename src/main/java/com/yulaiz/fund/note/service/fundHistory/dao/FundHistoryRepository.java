package com.yulaiz.fund.note.service.fundHistory.dao;

import com.yulaiz.fund.note.service.fundHistory.entity.FundHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FundHistoryRepository extends JpaRepository<FundHistoryEntity, Long>, JpaSpecificationExecutor<FundHistoryEntity> {

}
