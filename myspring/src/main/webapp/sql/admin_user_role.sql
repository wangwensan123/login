/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : wws

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-03-01 10:48:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES ('17', '14', '24');
INSERT INTO `admin_user_role` VALUES ('18', '7', '25');
INSERT INTO `admin_user_role` VALUES ('19', '15', '17');
INSERT INTO `admin_user_role` VALUES ('20', '8', '24');
