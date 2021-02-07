package com.yulaiz.fund.note.service.fund.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.yulaiz.fund.note.service.fund.dao.FundRepository;
import com.yulaiz.fund.note.service.fund.entity.FundEntity;
import com.yulaiz.fund.note.service.fund.entity.FundEntity_;
import com.yulaiz.fund.note.service.fund.service.FundService;
import com.yulaiz.fund.note.service.utils.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FundServiceImpl implements FundService {
    private static final Log log = LogFactory.get();

    @Autowired
    private FundRepository fundRepository;

    /**
     * 根据基金ID查询基金详情
     *
     * @param fundId
     * @return
     */
    @Override
    public FundEntity queryFundDetailById(Long fundId) {
        if (fundId == null || fundId <= 0) {
            return null;
        }
        Optional<FundEntity> entity = this.fundRepository.findById(fundId);
        return entity.orElse(null);
    }

    /**
     * 根据基金代码查询基金详情
     *
     * @param fundCode
     * @return
     */
    @Override
    public FundEntity queryFundDetailByCode(String fundCode) {
        if (StrUtil.isBlank(fundCode)) {
            return null;
        }
        Spec<FundEntity> spec = (root, predicates, criteriaBuilder) -> {
            predicates.add(criteriaBuilder.equal(root.get(FundEntity_.fundCode), fundCode));
        };
        Optional<FundEntity> entity = this.fundRepository.findOne(spec);
        return entity.orElse(null);
    }
}
