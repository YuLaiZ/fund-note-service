package com.yulaiz.fund.note.service.note.entity;

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
@Table(name = "fn_note")
public class NoteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long noteId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "note_name")
    private String noteName;

    @Column(name = "holding_cost")
    private String holdingCost;

    @Column(name = "total_assets")
    private String totalAssets;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_record_time")
    private Date modifyRecordTime;

}
