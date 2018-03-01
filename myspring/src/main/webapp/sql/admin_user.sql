/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : wws

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2018-03-01 10:47:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `userage` varchar(20) DEFAULT NULL,
  `account` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('7', '管理员一号', 'hsufigm+eq1+qtLWI7sSOhfRSg/D9/VhZZvuMMOH5B7m1EixZNuUOsA2+CQShEgyKwhOz1C4+jkPXyLnwDW8IQ==', '18812321321', '1', '18', 'admin');
INSERT INTO `admin_user` VALUES ('8', 'wang', 'hsufigm+eq1+qtLWI7sSOhfRSg/D9/VhZZvuMMOH5B7m1EixZNuUOsA2+CQShEgyKwhOz1C4+jkPXyLnwDW8IQ==', null, null, null, 'wang');
INSERT INTO `admin_user` VALUES ('13', 'rrr', 'KZl7BdU8LZdoLS1KS8GI2o8pqz/0agrD5g6Lr58b6K4OnJYDBQDNBTM5f4Gf61Pj5Af0VhbieyDM6m1GzKCMxw==', null, null, '12', 'rrr');
INSERT INTO `admin_user` VALUES ('14', 'bffgd', 'gA+Vq8XO2k/PUJxQfO7PIVFoNKTmLmwKFYj2jBNk58Qg1wOSsv5JCnHzr7dsZ1MA9xqlkCXBDtGzFlRhymgf2g==', '123123', '1', '12', 'bffgd');
INSERT INTO `admin_user` VALUES ('15', 'eee', 'gA+Vq8XO2k/PUJxQfO7PIVFoNKTmLmwKFYj2jBNk58Qg1wOSsv5JCnHzr7dsZ1MA9xqlkCXBDtGzFlRhymgf2g==', '123213', '2', '12', 'eee');
INSERT INTO `admin_user` VALUES ('16', 'retr', 'gA+Vq8XO2k/PUJxQfO7PIVFoNKTmLmwKFYj2jBNk58Qg1wOSsv5JCnHzr7dsZ1MA9xqlkCXBDtGzFlRhymgf2g==', '18321312321', '1', '123', 'retr');
INSERT INTO `admin_user` VALUES ('17', '张三', 'hsufigm+eq1+qtLWI7sSOhfRSg/D9/VhZZvuMMOH5B7m1EixZNuUOsA2+CQShEgyKwhOz1C4+jkPXyLnwDW8IQ==', '18756765756', '1', '18', 'zhangsan');
INSERT INTO `admin_user` VALUES ('18', '李四', 'hsufigm+eq1+qtLWI7sSOhfRSg/D9/VhZZvuMMOH5B7m1EixZNuUOsA2+CQShEgyKwhOz1C4+jkPXyLnwDW8IQ==', '123123', '1', '12', 'lisi');
INSERT INTO `admin_user` VALUES ('19', 'qq', 'gA+Vq8XO2k/PUJxQfO7PIVFoNKTmLmwKFYj2jBNk58Qg1wOSsv5JCnHzr7dsZ1MA9xqlkCXBDtGzFlRhymgf2g==', '1', '2', '12', 'qqq');
INSERT INTO `admin_user` VALUES ('20', 'eeee', 'gA+Vq8XO2k/PUJxQfO7PIVFoNKTmLmwKFYj2jBNk58Qg1wOSsv5JCnHzr7dsZ1MA9xqlkCXBDtGzFlRhymgf2g==', 'q', '1', 'q', 'eeeee');
INSERT INTO `admin_user` VALUES ('21', 'ttt', 'gA+Vq8XO2k/PUJxQfO7PIVFoNKTmLmwKFYj2jBNk58Qg1wOSsv5JCnHzr7dsZ1MA9xqlkCXBDtGzFlRhymgf2g==', '1', '1', '1', 'ttt');
INSERT INTO `admin_user` VALUES ('22', 'asd', 'gA+Vq8XO2k/PUJxQfO7PIVFoNKTmLmwKFYj2jBNk58Qg1wOSsv5JCnHzr7dsZ1MA9xqlkCXBDtGzFlRhymgf2g==', '1', '1', '1', 'asd');
