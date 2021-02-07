package com.yulaiz.fund.note.service.fundValue.service.impl;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.fundValue.dao.FundValueRepository;
import com.yulaiz.fund.note.service.fundValue.entity.FundValueEntity;
import com.yulaiz.fund.note.service.fundValue.entity.FundValueEntity_;
import com.yulaiz.fund.note.service.fundValue.service.FundValueService;
import com.yulaiz.fund.note.service.utils.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FundValueServiceImpl implements FundValueService {
    private static final Log log = LogFactory.get();

    @Autowired
    private FundValueRepository fundValueRepository;

    /**
     * 获取基金最近净值
     *
     * @param fundId
     * @return
     */
    @Override
    public FundValueEntity queryFundValueRecently(Long fundId) {
        if (fundId == null || fundId <= 0) {
            return null;
        }
        Optional<FundValueEntity> entity = this.fundValueRepository.findById(fundId);
        return entity.orElse(null);
    }

    /**
     * 获取基金指定日期净值
     *
     * @param fundId
     * @param fundDate
     * @return
     */
    @Override
    public FundValueEntity queryFundValueByDate(Long fundId, Date fundDate) {
        if (fundId == null || fundId <= 0 || fundDate == null) {
            return null;
        }
        Spec<FundValueEntity> spec = (root, predicates, criteriaBuilder) -> {
            predicates.add(criteriaBuilder.equal(root.get(FundValueEntity_.fundId), fundId));
            predicates.add(criteriaBuilder.equal(root.get(FundValueEntity_.fundDate), fundDate));
        };
        Optional<FundValueEntity> entity = this.fundValueRepository.findOne(spec);
        return entity.orElse(null);
    }
}
