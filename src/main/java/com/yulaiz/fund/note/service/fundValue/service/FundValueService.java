package com.yulaiz.fund.note.service.fundValue.service;

import com.yulaiz.fund.note.service.fundValue.entity.FundValueEntity;

import java.util.Date;

public interface FundValueService {
    /**
     * 获取基金最近净值
     *
     * @param fundId
     * @return
     */
    FundValueEntity queryFundValueRecently(Long fundId);

    /**
     * 获取基金指定日期净值
     *
     * @param fundId
     * @param fundDate
     * @return
     */
    FundValueEntity queryFundValueByDate(Long fundId, Date fundDate);
}
