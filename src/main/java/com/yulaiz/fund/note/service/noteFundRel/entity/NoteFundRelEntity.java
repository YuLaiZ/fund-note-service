package com.yulaiz.fund.note.service.noteFundRel.entity;

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
@Table(name = "fn_note_fund_rel")
public class NoteFundRelEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rel_id")
	private Long relId;

	@Column(name = "note_id")
	private Long noteId;

	@Column(name = "fund_id")
	private Long fundId;

	@Column(name = "hold_status")
	private Long holdStatus;

	@Column(name = "update_time")
	private Date updateTime;

}
