/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.23.10
 Source Server Type    : MySQL
 Source Server Version : 50087
 Source Host           : 192.168.23.10:3306
 Source Schema         : production

 Target Server Type    : MySQL
 Target Server Version : 50087
 File Encoding         : 65001

 Date: 24/12/2018 17:35:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_plan
-- ----------------------------
DROP TABLE IF EXISTS `order_plan`;
CREATE TABLE `order_plan`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `ORDER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单名称',
  `PRO_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称及规格',
  `PLAN_COUNT` int(11) NULL DEFAULT NULL COMMENT '计划生产数',
  `ACTUAL_COUNT` int(11) NULL DEFAULT NULL COMMENT '实际生产数',
  `DIFF_COUNT` int(11) NULL DEFAULT NULL COMMENT '差异数',
  `ACH_RATE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '达成率',
  `PRO_DATE` datetime NULL DEFAULT NULL COMMENT '生产时间',
  `PROPERTIE` int(11) NULL DEFAULT NULL COMMENT '紧要程度',
  PRIMARY KEY USING BTREE (`ID`)
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
