package com.yulaiz.fund.note.service.fundValue.entity;

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
@Table(name = "fn_fund_value")
public class FundValueEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fund_id")
    private Long fundId;

    @Column(name = "fund_code")
    private String fundCode;

    @Column(name = "fund_date")
    private Date fundDate;

    @Column(name = "fund_value")
    private String fundValue;

    @Column(name = "update_time")
    private Date updateTime;

}
