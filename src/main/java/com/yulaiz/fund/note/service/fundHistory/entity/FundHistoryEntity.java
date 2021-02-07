package com.yulaiz.fund.note.service.fundHistory.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "fn_fund_history")
public class FundHistoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fund_id")
    private Long fundId;

    @Column(name = "fund_code")
    private String fundCode;

    @Column(name = "fund_date")
    private Date fundDate;

    @Column(name = "fund_net")
    private String fundNet;

    @Column(name = "update_time")
    private Date updateTime;

}
