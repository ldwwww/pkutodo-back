DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `userid` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `username` varchar(64) DEFAULT '' COMMENT '用户名',
    `password` varchar(64) DEFAULT '' COMMENT '密码',
    `email` varchar(255) DEFAULT '' COMMENT '邮箱',
    `registerdate` datetime DEFAULT NULL COMMENT '注册日期',
    `login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
    `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
    PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
