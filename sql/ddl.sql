drop table if exists fn_fund;
create table fn_fund
(
    fund_id     int(32) auto_increment comment '基金ID'
        primary key,
    fund_code   varchar(6)   null comment '基金代码',
    fund_name   varchar(128) null comment '基金名称',
    fund_type   int(3)       null comment '基金类型(1-普通开放式公募基金,2-货币基金,3-QDII基金)',
    update_time datetime     null comment '更新时间',
    index fn_fund_code (fund_code)
) comment '基金表';

drop table if exists fn_fund_value;
create table if not exists fn_fund_value
(
    fund_id     int(32) auto_increment comment '基金ID'
        primary key,
    fund_code   varchar(6) null comment '基金代码',
    fund_date   date       null comment '净值日期',
    fund_value  varchar(6) null comment '净值',
    update_time datetime   null comment '更新时间',
    index fn_fund_value_code (fund_code),
    index fn_fund_value_date (fund_date)
) comment '基金净值表';

drop table if exists fn_note;
create table if not exists fn_note
(
    note_id            int(32) auto_increment comment '账本ID'
        primary key,
    user_id            int(32)     null comment '用户ID',
    note_name          varchar(64) null comment '账本名称',
    create_time        datetime    null comment '创建时间',
    modify_record_time datetime    null comment '账本内最后一次更新记录的时间',
    index fn_note_user (user_id)
) comment '账本表';

drop table if exists fn_note_fund_rel;
create table if not exists fn_note_fund_rel
(
    rel_id          int(32) auto_increment comment '关系ID'
        primary key,
    note_id         int(32)    null comment '账本ID',
    fund_id         int(32)    null comment '基金ID',
    fund_code       varchar(6) null comment '基金代码',
    hold_status     int(3)     null comment '持有状态(0-未生效,1-持有,2-清仓)',
    purchasing_cost bigint     null comment '买入成本(分)',
    hold_share      bigint     null comment '持有份额',
    unit_cost       bigint     null comment '单价成本',
    update_time     datetime   null comment '更新时间',
    index fn_note_fund_rel_fund (fund_id),
    index fn_note_fund_rel_note (note_id)
) comment '账本基金关联';

drop table if exists fn_note_fund_record;
create table if not exists fn_note_fund_record
(
    record_id         int(32) auto_increment comment '记录ID'
        primary key,
    rel_id            int(32)  null comment '关系ID',
    note_id           int(32)  null comment '账本ID',
    fund_id           int(32)  null comment '基金ID',
    operating         int(3)   null comment '操作(1-申购,2-赎回,3-现金分红,4-红利再投,5-折算)',
    apply_date        date     null comment '申请日期',
    confirm_date      date     null comment '确认日期',
    purchasing_amount bigint   null comment '申购金额(分)',
    redeeming_amount  bigint   null comment '赎回金额(分)',
    fund_share        bigint   null comment '确认份额*100',
    transaction_fee   bigint   null comment '手续费(分)',
    update_time       datetime null comment '更新时间',
    index fn_note_fund_record_rel (rel_id),
    index fn_note_fund_record_note (note_id),
    index fn_note_fund_record_fund (fund_id)
) comment '账本基金关联';

drop table if exists fn_user;
create table if not exists fn_user
(
    user_id     int(32) auto_increment comment '用户ID'
        primary key,
    user_name   varchar(64) null comment '用户昵称',
    create_time datetime    null comment '创建时间'
) comment '用户表';

