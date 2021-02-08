package com.yulaiz.fund.note.service.fundValuation.service.impl;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.fundValuation.dao.FundValuationRepository;
import com.yulaiz.fund.note.service.fundValuation.entity.FundValuationEntity;
import com.yulaiz.fund.note.service.fundValuation.entity.FundValuationEntity_;
import com.yulaiz.fund.note.service.fundValuation.service.FundValuationService;
import com.yulaiz.fund.note.service.utils.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FundValuationServiceImpl implements FundValuationService {
    private static final Log log = LogFactory.get();

    @Autowired
    private FundValuationRepository fundValuationRepository;

    /**
     * 获取基金指定日期估值
     *
     * @param fundId
     * @param valuationDate
     * @return
     */
    @Override
    public FundValuationEntity queryFundValuationByDate(Long fundId, Date valuationDate) {
        if (fundId == null || fundId <= 0 || valuationDate == null) {
            return null;
        }
        Spec<FundValuationEntity> spec = (root, predicates, criteriaBuilder) -> {
            predicates.add(criteriaBuilder.equal(root.get(FundValuationEntity_.fundId), fundId));
            predicates.add(criteriaBuilder.equal(root.get(FundValuationEntity_.valuationDate), valuationDate));
        };
        Optional<FundValuationEntity> entity = this.fundValuationRepository.findOne(spec);
        return entity.orElse(null);
    }

    /**
     * 保存基金指定日期估值
     *
     * @param fundId
     * @param valuationDate
     * @param fundValuation
     * @return
     */
    @Override
    public void saveFundValuation(Long fundId, Date valuationDate, String fundValuation) {
        FundValuationEntity fundValuationEntity = this.queryFundValuationByDate(fundId, valuationDate);
        if (fundValuationEntity == null) {
            fundValuationEntity = new FundValuationEntity();
            fundValuationEntity.setFundId(fundId);
//            fundValuationEntity.setFundCode();
        }
        fundValuationEntity.setFundValuation(fundValuation);
        fundValuationEntity.setUpdateTime(new Date());
        this.fundValuationRepository.save(fundValuationEntity);
    }
}
