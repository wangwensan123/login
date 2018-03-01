/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : wws

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-03-01 10:48:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(100) DEFAULT NULL,
  `rolecode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('17', '管理员', 'manager');
INSERT INTO `admin_role` VALUES ('24', '普通角色', 'common');
INSERT INTO `admin_role` VALUES ('25', '超级管理员', 'administrator');
