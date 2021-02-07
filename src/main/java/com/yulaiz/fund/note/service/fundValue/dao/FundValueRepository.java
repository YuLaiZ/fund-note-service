package com.yulaiz.fund.note.service.fundValue.dao;

import com.yulaiz.fund.note.service.fundValue.entity.FundValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FundValueRepository extends JpaRepository<FundValueEntity, Long>, JpaSpecificationExecutor<FundValueEntity> {

}
