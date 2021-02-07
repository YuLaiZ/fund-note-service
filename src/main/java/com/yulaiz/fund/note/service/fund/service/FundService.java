package com.yulaiz.fund.note.service.fund.service;

import com.yulaiz.fund.note.service.fund.entity.FundEntity;

public interface FundService {

    /**
     * 根据基金ID查询基金详情
     *
     * @param fundId
     * @return
     */
    FundEntity queryFundDetailById(Long fundId);

    /**
     * 根据基金代码查询基金详情
     *
     * @param fundCode
     * @return
     */
    FundEntity queryFundDetailByCode(String fundCode);
}
