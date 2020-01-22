/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : excellent_course

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 22/01/2020 12:22:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for annex
-- ----------------------------
DROP TABLE IF EXISTS `annex`;
CREATE TABLE `annex`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `section_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'untitled',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'unnamed',
  `upload_time` date NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'unnamed',
  `year` year NULL DEFAULT 2000,
  `principal_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人id（教师id）',
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '暂无所属学院',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('12cb72c64ed95e7f48e830c9860bac2f', '测试课程', 2000, NULL, '暂无所属学院');
INSERT INTO `course` VALUES ('67fc9ece568ee53b92d240310d2cc018', '测试课程2', 2000, NULL, '暂无所属学院');
INSERT INTO `course` VALUES ('6fc8a69eaa7b3c16b9b2004ebbd314d2', '测试课程2', 2000, NULL, '暂无所属学院');

-- ----------------------------
-- Table structure for section
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'unnamed',
  `data` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '栏目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) NULL DEFAULT NULL COMMENT '文件类型',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL地址',
  `create_on` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件上传' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `time` int(11) NULL DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_on` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (7, 1, 'admin', '登录', 0, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2020-01-05 21:42:03');
INSERT INTO `sys_log` VALUES (8, 1, 'admin', '登录', 15, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2020-01-05 21:47:04');
INSERT INTO `sys_log` VALUES (9, 1, 'admin', '登录', 0, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2020-01-05 21:53:27');
INSERT INTO `sys_log` VALUES (10, 1, 'admin', '登录', 16, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2020-01-05 21:54:17');
INSERT INTO `sys_log` VALUES (11, 1, 'admin', '登录', 31, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', NULL, '127.0.0.1', '2020-01-05 21:56:26');
INSERT INTO `sys_log` VALUES (12, 1, 'admin', '登录', 156, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"8435\",null]', '127.0.0.1', '2020-01-05 22:03:41');
INSERT INTO `sys_log` VALUES (13, 1, 'admin', '登录', 4, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"8951\",null]', '127.0.0.1', '2020-01-05 22:18:42');
INSERT INTO `sys_log` VALUES (14, 1, 'admin', '登录', 3388, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"7836\",null]', '127.0.0.1', '2020-01-06 23:00:30');
INSERT INTO `sys_log` VALUES (15, 1, 'admin', '登录', 3012, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"6737\",null]', '127.0.0.1', '2020-01-06 23:06:57');
INSERT INTO `sys_log` VALUES (16, 1, 'admin', '登录', 413, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"8331\",null]', '127.0.0.1', '2020-01-07 23:11:19');
INSERT INTO `sys_log` VALUES (17, 1, 'admin', '登录', 309, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"5453\",null]', '127.0.0.1', '2020-01-08 23:42:23');
INSERT INTO `sys_log` VALUES (18, 1, 'admin', '登录', 174, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"9926\",null]', '127.0.0.1', '2020-01-12 12:35:00');
INSERT INTO `sys_log` VALUES (19, 1, 'admin', '登录', 2, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"9426\",null]', '127.0.0.1', '2020-01-12 12:35:51');
INSERT INTO `sys_log` VALUES (20, 1, 'admin', '登录', 72, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"9574\",null]', '127.0.0.1', '2020-01-12 16:32:23');
INSERT INTO `sys_log` VALUES (21, 1, 'admin', '登录', 18, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"2331\",null]', '127.0.0.1', '2020-01-12 17:02:57');
INSERT INTO `sys_log` VALUES (22, 1, 'admin', '流程定义导入', 82, 'com.yangzc.studentboot.workflow.definition.controller.ProcessDefinitionController.upload()', '[null]', '127.0.0.1', '2020-01-12 17:37:16');
INSERT INTO `sys_log` VALUES (23, 1, 'admin', '流程定义导入', 26940, 'com.yangzc.studentboot.workflow.definition.controller.ProcessDefinitionController.upload()', '[null]', '127.0.0.1', '2020-01-12 17:42:38');
INSERT INTO `sys_log` VALUES (24, 1, 'admin', '登录', 20, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"2179\",null]', '127.0.0.1', '2020-01-12 17:50:59');
INSERT INTO `sys_log` VALUES (25, 1, 'admin', '登录', 24, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"8753\",null]', '127.0.0.1', '2020-01-12 19:20:43');
INSERT INTO `sys_log` VALUES (26, 1, 'admin', '流程定义导入', 370, 'com.yangzc.studentboot.workflow.definition.controller.ProcessDefinitionController.upload()', '[null]', '127.0.0.1', '2020-01-12 19:20:54');
INSERT INTO `sys_log` VALUES (27, 1, 'admin', '登录', 61, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"1145\",null]', '127.0.0.1', '2020-01-12 20:16:54');
INSERT INTO `sys_log` VALUES (28, 1, 'admin', '登录', 28, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"1497\",null]', '127.0.0.1', '2020-01-12 20:22:12');
INSERT INTO `sys_log` VALUES (29, 1, 'admin', '登录', 14, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"5926\",null]', '127.0.0.1', '2020-01-12 20:27:22');
INSERT INTO `sys_log` VALUES (30, -1, '[\"admin\",\"111111\",\"5751\",null]', '登录', 0, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"5751\",null]', '127.0.0.1', '2020-01-12 20:27:31');
INSERT INTO `sys_log` VALUES (31, -1, '[\"admin\",\"111111\",\"5751\",null]', '登录', 1, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"5751\",null]', '127.0.0.1', '2020-01-12 20:27:34');
INSERT INTO `sys_log` VALUES (32, -1, '[\"admin\",\"111111\",\"7998\",null]', '登录', 1, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"7998\",null]', '127.0.0.1', '2020-01-12 20:27:43');
INSERT INTO `sys_log` VALUES (33, 1, 'admin', '登录', 3, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"0059\",null]', '127.0.0.1', '2020-01-12 20:28:06');
INSERT INTO `sys_log` VALUES (34, -1, '[\"lyf\",\"123456\",\"2116\",null]', '登录', 3, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"123456\",\"2116\",null]', '127.0.0.1', '2020-01-12 20:29:10');
INSERT INTO `sys_log` VALUES (35, -1, '[\"lyf\",\"123456\",\"6720\",null]', '登录', 11, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"123456\",\"6720\",null]', '127.0.0.1', '2020-01-12 20:29:17');
INSERT INTO `sys_log` VALUES (36, 2, 'lyf', '登录', 9, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"111111\",\"6720\",null]', '127.0.0.1', '2020-01-12 20:29:25');
INSERT INTO `sys_log` VALUES (37, 2, 'lyf', '补贴申请', 46, 'com.yangzc.studentboot.workflow.allowance.controller.BizAllowanceController.addSave()', '[{\"createBy\":\"刘亦菲\",\"createTime\":1578832549913,\"id\":1,\"params\":{},\"reason\":\"测试数据，1111111111111\",\"title\":\"申请奖学金1111111111111\",\"totalMoney\":2000}]', '127.0.0.1', '2020-01-12 20:35:50');
INSERT INTO `sys_log` VALUES (38, -1, '[\"yangzc\",\"111111\",\"6997\",null]', '登录', 30324, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"yangzc\",\"111111\",\"6997\",null]', '127.0.0.1', '2020-01-12 20:51:33');
INSERT INTO `sys_log` VALUES (39, 3, 'yangzc', '登录', 3910, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"yangzc\",\"111111\",\"6997\",null]', '127.0.0.1', '2020-01-12 20:52:14');
INSERT INTO `sys_log` VALUES (40, -1, '[\"yangzc\",\"111111\",\"3444\",null]', '登录', 4, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"yangzc\",\"111111\",\"3444\",null]', '127.0.0.1', '2020-01-12 20:52:57');
INSERT INTO `sys_log` VALUES (41, 3, 'yangzc', '登录', 3, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"yangzc\",\"111111\",\"2553\",null]', '127.0.0.1', '2020-01-12 20:53:02');
INSERT INTO `sys_log` VALUES (42, -1, '[\"lyf\",\"111111\",\"6366\",null]', '登录', 1, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"111111\",\"6366\",null]', '127.0.0.1', '2020-01-12 20:53:44');
INSERT INTO `sys_log` VALUES (43, 2, 'lyf', '登录', 3, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"111111\",\"8500\",null]', '127.0.0.1', '2020-01-12 20:53:49');
INSERT INTO `sys_log` VALUES (44, 2, 'lyf', '补贴申请', 7, 'com.yangzc.studentboot.workflow.allowance.controller.BizAllowanceController.addSave()', '[{\"createBy\":\"lyf\",\"createTime\":1578833684729,\"id\":2,\"params\":{},\"reason\":\"测试数据\",\"title\":\"申请交通补贴2222222222\",\"totalMoney\":300}]', '127.0.0.1', '2020-01-12 20:54:45');
INSERT INTO `sys_log` VALUES (45, 2, 'lyf', '补贴申请提交', 344, 'com.yangzc.studentboot.workflow.allowance.controller.BizAllowanceController.submitApply()', '[1]', '127.0.0.1', '2020-01-12 21:04:19');
INSERT INTO `sys_log` VALUES (46, 1, 'admin', '登录', 61, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"6404\",null]', '127.0.0.1', '2020-01-12 21:17:13');
INSERT INTO `sys_log` VALUES (47, 2, 'lyf', '登录', 3, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"111111\",\"1741\",null]', '127.0.0.1', '2020-01-12 21:17:43');
INSERT INTO `sys_log` VALUES (48, 1, 'admin', '登录', 3, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"8497\",null]', '127.0.0.1', '2020-01-12 21:20:17');
INSERT INTO `sys_log` VALUES (49, 1, 'admin', '登录', 12, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"8151\",null]', '127.0.0.1', '2020-01-12 21:27:27');
INSERT INTO `sys_log` VALUES (50, 1, 'admin', '登录', 54, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"2025\",null]', '127.0.0.1', '2020-01-12 21:38:41');
INSERT INTO `sys_log` VALUES (51, -1, '[\"lyf\",\"111111\",\"8697\",null]', '登录', 1, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"111111\",\"8697\",null]', '127.0.0.1', '2020-01-12 21:39:10');
INSERT INTO `sys_log` VALUES (52, 2, 'lyf', '登录', 4, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"111111\",\"9780\",null]', '127.0.0.1', '2020-01-12 21:39:15');
INSERT INTO `sys_log` VALUES (53, 3, 'yangzc', '登录', 10, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"yangzc\",\"111111\",\"4334\",null]', '127.0.0.1', '2020-01-12 21:56:06');
INSERT INTO `sys_log` VALUES (54, 2, 'lyf', '登录', 5, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"lyf\",\"111111\",\"1587\",null]', '127.0.0.1', '2020-01-12 21:57:32');
INSERT INTO `sys_log` VALUES (55, 1, 'admin', '登录', 5, 'com.yangzc.studentboot.login.controller.LoginController.ajaxLogin()', '[\"admin\",\"111111\",\"7940\",null]', '127.0.0.1', '2020-01-12 22:45:11');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_on` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_on` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '权限管理', NULL, NULL, 0, 'fa fa-gear', 1, '2019-12-21 00:00:00', '2019-12-21 00:00:00');
INSERT INTO `sys_menu` VALUES (2, 1, '系统菜单', 'sys/menu/', 'sys:menu:menu', 1, 'fa fa-th-list', 12, '2019-12-21 00:00:00', '2019-12-21 00:00:00');
INSERT INTO `sys_menu` VALUES (3, 1, '角色管理', 'sys/role', 'sys:role:role', 1, 'fa fa-paw', 11, '2019-12-21 00:00:00', '2019-12-21 00:00:00');
INSERT INTO `sys_menu` VALUES (4, 1, '用户权限', 'sys/user/', 'sys:user:user', 1, '', 10, '2019-12-21 00:00:00', '2019-12-21 00:00:00');
INSERT INTO `sys_menu` VALUES (5, 0, '学员管理', '', '', 0, 'fa fa-user', 2, '2019-12-21 00:00:00', '2019-12-21 00:00:00');
INSERT INTO `sys_menu` VALUES (6, 5, '学员列表', 'stu/list/', 'stu:list', 1, '', 20, '2019-12-21 00:00:00', '2019-12-21 00:00:00');
INSERT INTO `sys_menu` VALUES (7, 2, '新增', '', 'sys:menu:add', 2, '', 120, '2019-12-29 00:00:00', '2019-12-29 00:00:00');
INSERT INTO `sys_menu` VALUES (8, 2, '编辑', '', 'sys:menu:edit', 2, '', 122, '2019-12-29 00:00:00', '2019-12-29 00:00:00');
INSERT INTO `sys_menu` VALUES (9, 2, '删除', '', 'sys:menu:remove', 2, '', 123, '2019-12-29 00:00:00', '2019-12-29 00:00:00');
INSERT INTO `sys_menu` VALUES (10, 2, '批量删除', '', 'sys:menu:batchRemove', 2, '', 124, '2019-12-29 00:00:00', '2019-12-29 00:00:00');
INSERT INTO `sys_menu` VALUES (11, 6, '添加', '', 'stu:create', 2, '', 200, NULL, NULL);
INSERT INTO `sys_menu` VALUES (13, 0, '补贴办理', '', '', 0, 'fa fa-tasks', 3, NULL, '2020-01-12 12:46:21');
INSERT INTO `sys_menu` VALUES (16, 0, '日志管理', '', '', 0, 'fa fa-table', 4, '2020-01-04 23:08:10', NULL);
INSERT INTO `sys_menu` VALUES (17, 16, '日志查看', '/log/list', 'log:list', 1, '', 40, '2020-01-04 23:08:49', '2020-01-04 23:09:02');
INSERT INTO `sys_menu` VALUES (18, 0, '系统监控', '', '', 0, 'fa fa-video-camera', 5, '2020-01-06 23:36:13', '2020-01-06 23:37:17');
INSERT INTO `sys_menu` VALUES (19, 18, '数据监控', '/druid/index.html', '', 1, '', 50, '2020-01-06 23:39:33', NULL);
INSERT INTO `sys_menu` VALUES (22, 13, '补贴申请', '/workflow/allowance/apply/list', 'workflow:allowance:apply:list', 1, '', 30, '2020-01-12 12:47:21', '2020-01-12 21:20:33');
INSERT INTO `sys_menu` VALUES (23, 13, '我的待办', '/workflow/allowance/task/list', 'workflow:allowance:task:list', 1, '', 31, '2020-01-12 12:48:41', '2020-01-12 12:51:02');
INSERT INTO `sys_menu` VALUES (24, 13, '我的已办', '/workflow/allowance/done/list', 'workflow:allowance:done:list', 1, '', 32, '2020-01-12 12:52:08', NULL);
INSERT INTO `sys_menu` VALUES (25, 0, '流程设计', '', '', 0, 'fa fa-send', 6, '2020-01-12 12:56:32', '2020-01-12 12:57:12');
INSERT INTO `sys_menu` VALUES (26, 25, '流程模型', '/workflow/model/list', 'workflow:model:list', 1, '60', 60, '2020-01-12 12:59:10', '2020-01-12 17:02:12');
INSERT INTO `sys_menu` VALUES (27, 25, '流程定义', '/workflow/definition/list', 'workflow:definition:list', 1, '', 61, '2020-01-12 13:00:13', '2020-01-12 16:59:17');
INSERT INTO `sys_menu` VALUES (28, 22, '查询', '', 'workflow:allowance:apply:query', 2, '', 300, '2020-01-12 13:05:26', '2020-01-12 13:05:48');
INSERT INTO `sys_menu` VALUES (29, 22, '添加', '', 'workflow:allowance:apply:add', 2, '', 301, '2020-01-12 13:06:39', NULL);
INSERT INTO `sys_menu` VALUES (30, 23, '审批', '', 'workflow:allowance:task:audit', 2, '', 310, '2020-01-12 13:08:35', '2020-01-12 13:10:46');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_sign` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色标识',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` bigint(255) NULL DEFAULT NULL COMMENT '创建用户id',
  `create_on` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_on` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级用户角色', 'admin', '拥有最高权限', NULL, '2019-12-21 00:00:00', '2019-12-21 00:00:00');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1, 2);
INSERT INTO `sys_role_menu` VALUES (3, 1, 3);
INSERT INTO `sys_role_menu` VALUES (4, 1, 4);
INSERT INTO `sys_role_menu` VALUES (5, 1, 5);
INSERT INTO `sys_role_menu` VALUES (6, 1, 6);
INSERT INTO `sys_role_menu` VALUES (7, 1, 7);
INSERT INTO `sys_role_menu` VALUES (8, 1, 8);
INSERT INTO `sys_role_menu` VALUES (9, 1, 9);
INSERT INTO `sys_role_menu` VALUES (10, 1, 10);
INSERT INTO `sys_role_menu` VALUES (11, 1, 11);
INSERT INTO `sys_role_menu` VALUES (12, 1, 13);
INSERT INTO `sys_role_menu` VALUES (15, 1, 16);
INSERT INTO `sys_role_menu` VALUES (16, 1, 17);
INSERT INTO `sys_role_menu` VALUES (17, 1, 18);
INSERT INTO `sys_role_menu` VALUES (18, 1, 19);
INSERT INTO `sys_role_menu` VALUES (19, 1, 22);
INSERT INTO `sys_role_menu` VALUES (20, 1, 23);
INSERT INTO `sys_role_menu` VALUES (21, 1, 24);
INSERT INTO `sys_role_menu` VALUES (22, 1, 25);
INSERT INTO `sys_role_menu` VALUES (23, 1, 26);
INSERT INTO `sys_role_menu` VALUES (24, 1, 27);
INSERT INTO `sys_role_menu` VALUES (25, 1, 28);
INSERT INTO `sys_role_menu` VALUES (26, 1, 29);
INSERT INTO `sys_role_menu` VALUES (27, 1, 30);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `dept_id` bigint(20) NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(255) NULL DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `create_by` bigint(255) NULL DEFAULT NULL COMMENT '创建用户id',
  `create_on` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_on` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `gender` bigint(32) NULL DEFAULT NULL COMMENT '性别',
  `birth` datetime(0) NULL DEFAULT NULL COMMENT '出身日期',
  `pic_id` bigint(32) NULL DEFAULT NULL,
  `live_address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现居住地',
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在城市',
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '超级管理员', '27bd386e70f280e24c2f4f2a549b82cf', NULL, 'yangzc23@aliyun.com', '17721038951', 1, 1, '2019-12-21 18:05:39', '2019-12-21 18:05:39', NULL, '1999-10-15 00:00:00', NULL, NULL, NULL, '上海市', '上海市市辖区', '徐汇区');
INSERT INTO `sys_user` VALUES (2, 'lyf', '刘亦菲', '7fdb1d9008f45950c1620ba0864e5fbd', NULL, 'lyf@aliyun.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (3, 'yangzc', '杨振春', 'b926e2a0b1cc80a3020a4cdb44c901fa', NULL, 'yangzc23@aliyun.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_user` VALUES (4, 'admin', 'orypeu', 'orypeu', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 1);
INSERT INTO `sys_user_role` VALUES (3, 3, 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'unname',
  `sex` int(11) NULL DEFAULT 0 COMMENT '1或2，1代表男，2代表女',
  `birthday` date NULL DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `fax` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `education` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `degree` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通信地址',
  `research` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '研究方向',
  `situation` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '教学情况',
  `academic` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '学术研究',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
