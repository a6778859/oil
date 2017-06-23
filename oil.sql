# Host: localhost  (Version: 5.5.53)
# Date: 2017-06-23 14:50:32
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `userid` int(11) NOT NULL DEFAULT '0',
  `username` varchar(50) DEFAULT NULL COMMENT '账号',
  `userpassword` varchar(50) DEFAULT NULL COMMENT '密码',
  `errorcount` int(3) DEFAULT '0' COMMENT '密码错误次数',
  `locktime` timestamp NULL DEFAULT NULL COMMENT '加锁时间(加锁时间为1个钟头)',
  `lockstate` int(3) DEFAULT '1' COMMENT '1为正常  2为锁住状态',
  `totalmoney` decimal(18,2) DEFAULT NULL COMMENT '剩余金额',
  `addtime` timestamp NULL DEFAULT NULL COMMENT '录入时间',
  `updatetime` timestamp NULL DEFAULT NULL COMMENT '更改时间',
  `state` int(3) DEFAULT '1' COMMENT '状态 1为正常   2为异常',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "admin"
#

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e',6,'2017-06-07 08:54:49',1,NULL,'0000-00-00 00:00:00',NULL,1),(2,'ad','e10adc3949ba59abbe56e057f20f883e',0,NULL,1,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

#
# Structure for table "oil"
#

DROP TABLE IF EXISTS `oil`;
CREATE TABLE `oil` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `useorderid` varchar(30) NOT NULL DEFAULT '' COMMENT '用户传入的id',
  `userid` varchar(20) DEFAULT NULL,
  `money` decimal(18,2) DEFAULT NULL,
  `state` int(3) DEFAULT NULL COMMENT '1为成功 0为处理中  其他自定义',
  `addtime` timestamp NULL DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL,
  `remark` varchar(255) DEFAULT '',
  PRIMARY KEY (`orderid`),
  UNIQUE KEY `useorderid` (`useorderid`,`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "oil"
#

/*!40000 ALTER TABLE `oil` DISABLE KEYS */;
/*!40000 ALTER TABLE `oil` ENABLE KEYS */;
