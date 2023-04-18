/*
 Navicat Premium Data Transfer
 
 Source Server         : local-mac
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : gaox
 
 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001
 
 Date: 19/04/2023 02:35:06
 */
SET
    NAMES utf8mb4;

SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_mark
-- ----------------------------
DROP TABLE IF EXISTS `book_mark`;

CREATE TABLE `book_mark`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) NOT NULL COMMENT '书签名',
    `url`         varchar(4096)         DEFAULT NULL COMMENT 'url',
    `icon`        text COMMENT '书签图标',
    `type`        tinyint(1) DEFAULT '1' COMMENT '书签类型: 0 url,1 folder',
    `level`       int(4) DEFAULT '0' COMMENT '层级',
    `order_num`   int(11) NOT NULL DEFAULT '1' COMMENT '在目录中的顺序',
    `parent_id`   bigint(20) NOT NULL COMMENT '父级目录  父级目录0时是根目录',
    `parent_ids`  varchar(4096)         DEFAULT NULL COMMENT '父级目录列表',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
    `state`       tinyint(4) NOT NULL DEFAULT '1' COMMENT '禁用/启用 （0,1）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC COMMENT = '书签表';

-- ----------------------------
-- Table structure for context
-- ----------------------------
DROP TABLE IF EXISTS `context`;

CREATE TABLE `context`
(
    `id`      bigint(21) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
    `session` varchar(64) DEFAULT NULL COMMENT 'session id',
    `version` int(11) unsigned DEFAULT '0' COMMENT '版本号',
    `context` mediumtext COMMENT '内容：5M',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '内容表';

-- ----------------------------
-- Table structure for folder
-- ----------------------------
DROP TABLE IF EXISTS `folder`;

CREATE TABLE `folder`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) NOT NULL COMMENT '目录名',
    `icon`        text COMMENT '目录图标',
    `type`        tinyint(1) DEFAULT '1' COMMENT '书签类型: 0 url,1 folder',
    `level`       int(4) DEFAULT '0' COMMENT '层级',
    `order_num`   int(11) NOT NULL DEFAULT '1' COMMENT '在目录中的顺序',
    `parent_id`   bigint(20) NOT NULL COMMENT '父级目录  父级目录0时是根目录',
    `parent_ids`  varchar(4096)         DEFAULT NULL COMMENT '父级目录列表',
    `create_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
    `state`       tinyint(4) NOT NULL DEFAULT '0' COMMENT '禁用/启用 （0,1）',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC COMMENT = '文件夹表';

SET
FOREIGN_KEY_CHECKS = 1;