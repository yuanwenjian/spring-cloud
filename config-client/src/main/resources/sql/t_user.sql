/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : prataculture

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-04-03 18:45:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varbinary(50) DEFAULT NULL COMMENT '电话',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `company` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `status` tinyint(1) DEFAULT NULL COMMENT '激活状态 ',
  `role_type` varchar(50) DEFAULT NULL COMMENT '权限类别 admin/general',
  `register_date` datetime DEFAULT NULL COMMENT '注册时间',
  `keyuuid` varchar(50) DEFAULT NULL COMMENT '用于密码找回验证',
  `role_id` bigint(20) DEFAULT NULL COMMENT '用户的角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'yuanwj', 0x3133323435363738393635, '61ea237869d2233213160586571088c6', '苑文建', '百迈客', '0', 'general', '2017-12-18 14:55:35', 'd5e7bf49d32e4faba552448a3a47a18d', null);
