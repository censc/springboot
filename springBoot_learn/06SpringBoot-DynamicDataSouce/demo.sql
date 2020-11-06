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

 Date: 03/11/2020 10:32:11
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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `sys_admin_user` VALUES (14, 'jdbc_test', '$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'jdbc_test', 1, '123456', '123456@qq.com', NULL, 1, 0, NULL, NULL, NULL, NULL, NULL, 0, 0, 0, '');
INSERT INTO `sys_admin_user` VALUES (15, 'jpa_test', '$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'jpa测试者', 0, '15858585858', '123456@qq.com', '', 1, 0, '', '2020-11-02 09:37:32', '2020-11-02 09:37:32', '2020-11-02 09:37:32', '2020-11-02 09:37:32', 0, 0, 0, 'jpa测试');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `parent_id` bigint(20) DEFAULT 0 COMMENT '父级ID',
  `level_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '等级路径',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '部门名称',
  `sort` int(4) DEFAULT 0 COMMENT '排序',
  `status` tinyint(1) DEFAULT 1 COMMENT '状态(0:停用,1:正常)',
  `deleted_flag` tinyint(1) DEFAULT 0 COMMENT '删除状态(0:未删除,1:已删除)',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '部门描述',
  `created_at` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `deleted_at` datetime(0) DEFAULT NULL COMMENT '删除时间',
  `created_by` bigint(20) DEFAULT 0 COMMENT '创建者id',
  `updated_by` bigint(20) DEFAULT 0 COMMENT '更新者id',
  `deleted_by` bigint(20) DEFAULT 0 COMMENT '删除这id',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '0', '系统管理', 0, 1, 0, '系统管理', '2020-10-17 17:08:44', '2020-10-17 17:08:46', NULL, 0, 0, 0);
INSERT INTO `sys_dept` VALUES (2, 0, '0', 'demo公司', 0, 1, 0, 'demo公司', '2020-10-17 17:10:17', '2020-10-17 17:10:19', NULL, 0, 0, 0);
INSERT INTO `sys_dept` VALUES (3, 2, '0,2', '财务部', 0, 1, 0, '财务部', '2020-10-17 17:11:35', '2020-10-17 17:11:37', NULL, 0, 0, 0);
INSERT INTO `sys_dept` VALUES (4, 2, '0,2', '研发部', 0, 1, 0, '研发部', '2020-10-17 17:12:01', '2020-10-17 17:12:03', NULL, 0, 0, 0);
INSERT INTO `sys_dept` VALUES (5, 2, '0,2', '编辑部', 0, 1, 0, '编辑部', '2020-10-17 17:12:31', '2020-10-17 17:12:33', NULL, 0, 0, 0);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT 0 COMMENT '父ID',
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '路由地址',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '权限',
  `sort` int(4) DEFAULT 0 COMMENT '排序',
  `is_view` tinyint(1) DEFAULT 1 COMMENT '显示状态{0:隐藏,1:显示}',
  `is_link` tinyint(1) DEFAULT 0 COMMENT '是否外部链接{0:否,1:是}',
  `status` tinyint(1) DEFAULT 1 COMMENT '状态{0:停用,1:正常}',
  `menu_type` tinyint(1) DEFAULT 1 COMMENT '菜单类型{1:菜单2:目录,3:按钮}',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 'system/index', '', 0, 1, 0, 1, 1);
INSERT INTO `sys_menu` VALUES (2, '用户管理', 1, 'system/user/index', 'system:user:index', 0, 1, 0, 1, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `sort` int(4) DEFAULT 0 COMMENT '排序',
  `status` tinyint(1) DEFAULT 1 COMMENT '状态{0:停用,1:正常}',
  `deleted_flag` tinyint(1) DEFAULT 0 COMMENT '删除状态{0:未删除,1:删除}',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `created_at` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `deleted_at` datetime(0) DEFAULT NULL COMMENT '删除时间',
  `created_by` bigint(20) DEFAULT 0 COMMENT '创建者ID',
  `updated_by` bigint(20) DEFAULT 0 COMMENT '更新着ID',
  `deleted_by` bigint(20) DEFAULT NULL COMMENT '删除者ID',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理员', 0, 1, 0, '系统管理员', '2020-10-17 17:17:03', '2020-10-17 17:17:07', NULL, 0, 0, 0);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);

SET FOREIGN_KEY_CHECKS = 1;
