-- 创建 收件人地址信息
create table if not exists t_subAccount(
	accountId varchar(32) not null primary key comment '定订购者ID',
    subAccount varchar(30) not null comment '订购者账号',
    subName varchar(30) not null comment '收件人姓名',
    subGender varchar(10) comment '收件人性别' ,
    subAddress varchar(100) comment '收件人地址',
    subPhone varchar(20) comment '收件人联系方式',
    subPostCode varchar(10) comment '收件人邮编',
    createTime datetime comment '创建日期',
    updateTime datetime comment '修改日期',
    createUser varchar(20) comment '创建人',
    updateUser varchar(20) comment '更新人',
    info varchar(500) comment '备注'
)
default charset=utf8;

-- 历史订单信息
create table if not exists t_order(
orderId varchar(32) not null primary key comment '订单编号',
orderName varchar(50) not null comment '订单名称',
orderPrice double default 0 comment '订单价格',
orderNum int default 0 comment '订单数量',
orderFactory varchar(100) comment '订单来源(厂家,淘宝,京东等)',
createTime datetime comment '创建日期',
updateTime datetime comment '修改日期',
createUser varchar(20) comment '创建人',
updateUser varchar(20) comment '更新人',
subAccount varchar(30) not null comment '订购者账号',
info varchar(500) comment '订单备注'
)
default charset=utf8;