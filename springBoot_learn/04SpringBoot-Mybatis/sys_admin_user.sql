/*
 Navicat Premium Data Transfer

 Source Server         : home
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 31/10/2020 08:46:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_user`;
CREATE TABLE `sys_admin_user`  (
  `admin_user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮箱',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态{0:停用,1:正常}',
  `deleted_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记{0:未删,1:删除}',
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后登陆IP',
  `login_time` datetime(0) DEFAULT NULL COMMENT '最后登陆时间',
  `created_at` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `deleted_at` datetime(0) DEFAULT NULL COMMENT '删除时间',
  `created_by` bigint(20) DEFAULT 0 COMMENT '创建者ID',
  `updated_by` bigint(20) DEFAULT 0 COMMENT '更新者ID',
  `deleted_by` bigint(20) DEFAULT 0 COMMENT '删除者ID',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_admin_user
-- ----------------------------
INSERT INTO `sys_admin_user` VALUES (1, 'admin', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '卡卡罗特', 1, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '超级管理');
INSERT INTO `sys_admin_user` VALUES (2, 'singlezhang', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '张三', 1, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通管理');
INSERT INTO `sys_admin_user` VALUES (4, 'xiaoli', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '小李', 3, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (6, 'yiming', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '一鸣', 3, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (7, 'lisan', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '李三', 4, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (8, 'laoqian', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '老钱', 3, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (9, 'xiaomi', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '小米', 5, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (10, 'jiekema', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '杰克马', 5, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (11, 'misschen', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '小陈', 4, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (12, 'jiekema2', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '杰克马2', 3, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');
INSERT INTO `sys_admin_user` VALUES (13, 'jiekema3', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '杰克马3', 3, '123456', 'admin@qq.com', NULL, 1, 0, '127.0.0.1', '2020-10-17 16:16:11', '2020-10-17 16:16:16', '2020-10-17 16:16:18', NULL, 0, 0, 0, '普通员工');

SET FOREIGN_KEY_CHECKS = 1;
