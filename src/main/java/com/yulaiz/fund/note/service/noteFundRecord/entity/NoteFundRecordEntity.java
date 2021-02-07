package com.yulaiz.fund.note.service.noteFundRecord.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "fn_note_fund_record")
public class NoteFundRecordEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "fund_id")
    private Long fundId;

    @Column(name = "operating")
    private Long operating;

    @Column(name = "apply_date")
    private java.sql.Date applyDate;

    @Column(name = "confirm_date")
    private java.sql.Date confirmDate;

    @Column(name = "purchasing_amount")
    private Long purchasingAmount;

    @Column(name = "redeeming_amount")
    private Long redeemingAmount;

    @Column(name = "fund_share")
    private Long fundShare;

    @Column(name = "transaction_fee")
    private Long transactionFee;

    @Column(name = "update_time")
    private java.util.Date updateTime;

}
