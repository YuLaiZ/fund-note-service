package com.yulaiz.fund.note.service.fundValuation.service;

import com.yulaiz.fund.note.service.fundValuation.entity.FundValuationEntity;

import java.util.Date;

public interface FundValuationService {
    /**
     * 获取基金指定日期估值
     *
     * @param fundId
     * @param valuationDate
     * @return
     */
    FundValuationEntity queryFundValuationByDate(Long fundId, Date valuationDate);

    /**
     * 保存基金指定日期估值
     *
     * @param fundId
     * @param valuationDate
     * @param fundValuation
     * @return
     */
    void saveFundValuation(Long fundId, Date valuationDate, String fundValuation);
}
