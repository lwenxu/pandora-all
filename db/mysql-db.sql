-- MySQL dump 10.13  Distrib 8.0.13, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: pandora
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `config` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(128) NOT NULL COMMENT '名称',
  `VALUE` varchar(16) NOT NULL,
  `TYPE` varchar(64) NOT NULL COMMENT '类型分组',
  `VALUE_TYPE` varchar(64) NOT NULL COMMENT '数据类型',
  `SORT` int(6) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`),
  KEY `idx_code` (`TYPE`),
  KEY `idx_value` (`VALUE`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'查看自己','DA0','data_access_type','数据权限',1,NULL,'11111111111111111123'),(2,'查看本公司','DA1','data_access_type','数据权限',3,NULL,'hello,go'),(3,'查看同机构','DA2','data_access_type','数据权限',3,NULL,NULL),(4,'查看本部门','DA3','data_access_type','数据权限',4,NULL,NULL),(5,'查看集团','DA4','data_access_type','数据权限',5,NULL,NULL),(6,'查看母公司','DA5','data_access_type','数据权限',6,'2017-10-14 11:45:02.000000',NULL),(7,'普通功能','FN0','function_type','功能点类型',2,'2017-10-23 10:18:03.000000',NULL),(8,'含数据权限','FN1','function_type','功能点类型',1,'2017-10-23 10:20:05.000000',NULL),(9,'管理岗位','JT_01','job_type','岗位类型',1,NULL,NULL),(10,'技术岗位','JT_02','job_type','岗位类型',2,NULL,NULL),(11,'董事会','JT_S_01','job_sub_managment_type','管理岗位子类型',1,NULL,NULL),(12,'秘书','JT_S_02','job_sub_managment_type','管理岗位子类型',2,NULL,NULL),(13,'技术经理','JT_S_03','job_dev_sub_type','技术岗位子类型',1,NULL,NULL),(14,'程序员','JT_S_04','job_dev_sub_type','技术岗位子类型',2,NULL,NULL),(15,'菜单','MENU_M','menu_type','菜单类型',3,NULL,NULL),(16,'导航','MENU_N','menu_type','菜单类型',2,NULL,NULL),(17,'系统','MENU_S','menu_type','菜单类型',1,NULL,NULL),(18,'集团总部','ORGT0','org_type','机构类型',1,NULL,NULL),(19,'分公司','ORGT1','org_type','机构类型',2,NULL,NULL),(20,'部门','ORGT2','org_type','机构类型',3,NULL,NULL),(21,'小组','ORGT3','org_type','机构类型',4,NULL,NULL),(22,'操作角色','R0','role_type','数据权限',1,NULL,NULL),(23,'工作流角色','R1','role_type','用户角色',2,NULL,NULL),(24,'禁用','S0','user_state','用户状态',2,NULL,NULL),(25,'启用','S1','user_state','用户状态',1,NULL,NULL),(26,'随碟附送分','昂按','kkkk','水电费水电费',NULL,'2018-02-28 15:43:34.447000',''),(27,'随碟附送分','昂按','kkkk','水电费水电费',NULL,'2018-02-28 15:46:08.035000',''),(28,'sdfsdf','sdf','sfsdf','sdfsdf',1,'2018-02-28 15:47:56.384000',''),(29,'sdfsd','asas','sd','sd',NULL,'2018-02-28 15:50:32.214000',''),(30,'sdfsd','asas','sd','sd',NULL,'2018-02-28 15:50:50.241000',''),(31,'男','1','gender','性别',NULL,'2018-03-10 11:36:19.930000',''),(32,'女','2','gender','性别',NULL,'2018-03-10 11:36:20.001000',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_audit`
--

DROP TABLE IF EXISTS `core_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `core_audit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FUNCTION_NAME` varchar(45) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `USER_NAME` varchar(45) DEFAULT NULL,
  `IP` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  `SUCCESS` tinyint(4) DEFAULT NULL,
  `MESSAGE` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_audit`
--

LOCK TABLES `core_audit` WRITE;
/*!40000 ALTER TABLE `core_audit` DISABLE KEYS */;
INSERT INTO `core_audit` VALUES (1,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 19:58:50.876000',1,''),(2,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 19:58:51.377000',1,''),(3,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:00:10.972000',1,''),(4,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:00:11.130000',1,''),(5,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:00:39.562000',1,''),(6,'用户编辑',1,'超级管理员','172.16.49.65','2018-02-06 20:10:15.399000',1,''),(7,'用户列表',1,'超级管理员','172.16.49.65','2018-02-06 20:10:15.846000',1,''),(8,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:10:16.882000',1,''),(9,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:10:17.056000',1,''),(10,'用户编辑',1,'超级管理员','172.16.49.65','2018-02-06 20:14:46.789000',0,'java.sql.SQLException: Error on delete of \'C:\\Users\\ADMINI~1\\AppData\\Local\\Temp\\#sql978_2c3_6.MYI\' (Errcode: 13 - Permission denied)'),(11,'用户编辑',1,'超级管理员','172.16.49.65','2018-02-06 20:15:12.861000',1,''),(12,'用户列表',1,'超级管理员','172.16.49.65','2018-02-06 20:15:13.294000',1,''),(13,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:15:14.636000',1,''),(14,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:15:14.876000',1,''),(15,'未定义',1,'超级管理员','172.16.49.65','2018-02-06 20:16:23.824000',1,''),(16,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:42:58.091000',1,''),(17,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:42:58.394000',1,''),(18,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:53:11.745000',1,''),(19,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:53:11.943000',1,''),(20,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:53:13.058000',1,''),(21,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:53:28.999000',1,''),(22,'角色添加',1,'超级管理员','172.16.49.65','2018-02-07 09:53:29.162000',1,''),(23,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:53:43.017000',1,''),(24,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:53:43.148000',1,''),(25,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:53:45.338000',1,''),(26,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:56:03.185000',1,''),(27,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:56:03.646000',1,''),(28,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:56:06.264000',1,''),(29,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:56:07.508000',1,''),(30,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:56:09.524000',1,''),(31,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 09:56:10.738000',1,''),(32,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:02:00.590000',1,''),(33,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:02:00.803000',1,''),(34,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:02:02.991000',1,''),(35,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:05:40.367000',1,''),(36,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:05:40.496000',1,''),(37,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:05:42.173000',1,''),(38,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:06:02.218000',1,''),(39,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:07:45.273000',1,''),(40,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:07:45.943000',1,''),(41,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:07:47.715000',1,''),(42,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:08:03.378000',1,''),(43,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:08:03.484000',1,''),(44,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:08:16.535000',1,''),(45,'未定义',1,'超级管理员','172.16.49.65','2018-02-07 10:08:16.691000',1,'');
/*!40000 ALTER TABLE `core_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `file` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(64) DEFAULT NULL COMMENT '文件名称',
  `PATH` varchar(255) DEFAULT NULL COMMENT '路径',
  `USER_ID` int(20) DEFAULT NULL COMMENT '上传人id',
  `CREATE_TIME` datetime(6) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='文件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (19,'dict_upload_template.xls','20180311/dict_upload_template.xls.8caa38fb-52ef-4c73-85ea-abfb1f5c5dc4',1,'2018-03-11 15:36:58.906000'),(20,'dict_upload_template.xls','20180311/dict_upload_template.xls.f50b7f0f-d376-4a95-be6a-14f5aa4a81e6',1,'2018-03-11 15:37:15.884000'),(21,'dict_upload_template.xls','20180311/dict_upload_template.xls.b0b9434d-e367-43ef-b8ac-366cf7b018b6',1,'2018-03-11 15:38:52.600000'),(22,'dict_upload_template.xls','20180311/dict_upload_template.xls.15f02d15-2dd0-4cb7-b2e5-4f7d72fb497d',1,'2018-03-11 15:39:02.091000'),(23,'dict_upload_template.xls','20180311/dict_upload_template.xls.f12350bc-31da-4875-a78e-0135f512fb4c',1,'2018-03-11 15:41:52.323000'),(24,'dict_upload_template.xls','20180311/dict_upload_template.xls.5bf626e5-2152-45a5-a432-fc2e9fcb7903',1,'2018-03-11 15:43:18.066000'),(25,'dict_upload_template.xls','20180311/dict_upload_template.xls.3cd3eb95-aab9-4105-8d28-76a723274709',1,'2018-03-11 15:43:58.096000'),(26,'dict_upload_template.xls','20180311/dict_upload_template.xls.d3dc557b-1e77-4955-a3be-7a8b4f86407c',1,'2018-03-11 15:45:02.882000'),(34,'dict_upload_template.xls','20180311/dict_upload_template.xls.d50f8245-ec3e-4de1-9742-0c5c12105f27',1,'2018-03-11 16:30:36.191000'),(37,'副本 功能列表.xlsx','20180311/副本 功能列表.xlsx.bc7554e3-2a30-4667-aa61-0e280340b2be',1,'2018-03-11 18:53:41.504000'),(38,'副本 功能列表.xlsx','20180311/副本 功能列表.xlsx.d991eb1f-24a9-4db1-87c1-7ef9d2b8a40a',1,'2018-03-11 22:10:57.873000');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_tag`
--

DROP TABLE IF EXISTS `file_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `file_tag` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `KEY` varchar(64) NOT NULL COMMENT 'key，关键字',
  `VALUE` varchar(255) NOT NULL COMMENT '关键字对应的值',
  `FILE_ID` int(20) NOT NULL COMMENT 'sys_file的id，文件id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='文件标签';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_tag`
--

LOCK TABLES `file_tag` WRITE;
/*!40000 ALTER TABLE `file_tag` DISABLE KEYS */;
INSERT INTO `file_tag` VALUES (1,'customer','12332',1),(2,'type','crdit',2);
/*!40000 ALTER TABLE `file_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `function_point`
--

DROP TABLE IF EXISTS `function_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `function_point` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  `URL` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `function_point`
--

LOCK TABLES `function_point` WRITE;
/*!40000 ALTER TABLE `function_point` DISABLE KEYS */;
INSERT INTO `function_point` VALUES (1,'用户功能',NULL,'/admin/user/index.do'),(2,'用户列表',NULL,NULL),(3,'用户编辑',NULL,NULL),(6,'组织机构',NULL,'/admin/org/index.do'),(7,'角色管理',NULL,'/admin/role/index.do'),(8,'菜单管理',NULL,'/admin/menu/index.do'),(9,'功能点管理',NULL,'/admin/function/index.do'),(10,'角色功能授权',NULL,'/admin/role/function.do'),(11,'角色数据授权',NULL,'/admin/role/data.do'),(12,'代码生成',NULL,'/core/codeGen/index.do'),(13,'字典管理',NULL,'/admin/dict/index.do'),(18,'审计查询',NULL,'/admin/audit/index.do'),(19,'相关文档',NULL,'/trade/interAndRelate/file.do'),(91,'测试','2017-10-11 16:59:01.000000','/test/test.do'),(161,'角色添加','2017-10-23 09:45:05.000000',NULL),(167,'工作流监控',NULL,'/admin/workflow/index.do'),(180,'代码生成测试',NULL,NULL),(181,'博客查询功能',NULL,''),(182,'博客测试',NULL,'/admin/blog/index.do'),(183,'项目生成','2018-03-01 09:38:17.068000','/core/codeGen/project.do');
/*!40000 ALTER TABLE `function_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menu` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  `FUNCTION_ID` int(6) DEFAULT NULL,
  `TYPE` varchar(6) DEFAULT NULL COMMENT '1,系统，2 导航 3 菜单项（对应某个功能点）',
  `ORDER` int(65) NOT NULL DEFAULT '0',
  `ICON` varchar(255) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (8,'系统管理',NULL,NULL,'MENU_S',1,NULL),(10,'用户管理',NULL,1,'MENU_M',1,NULL),(11,'组织机构管理',NULL,6,'MENU_M',2,NULL),(12,'角色管理',NULL,7,'MENU_M',3,NULL),(13,'菜单项',NULL,8,'MENU_M',4,NULL),(14,'功能点管理',NULL,9,'MENU_M',5,NULL),(15,'字典数据管理',NULL,13,'MENU_M',6,NULL),(16,'审计查询',NULL,18,'MENU_M',7,NULL),(17,'代码生成',NULL,12,'MENU_M',8,''),(18,'基础管理',NULL,NULL,'MENU_N',1,NULL),(19,'监控管理',NULL,NULL,'MENU_N',2,NULL),(20,'流程监控',NULL,167,'MENU_M',3,NULL),(21,'角色功能授权',NULL,10,'MENU_M',8,NULL),(22,'角色数据授权',NULL,11,'MENU_M',9,NULL),(23,'博客测试1',NULL,182,'MENU_M',9,''),(24,'代码生成','2018-03-01 09:39:31.096000',NULL,'MENU_N',1,''),(25,'子系统生成','2018-03-01 09:42:35.839000',183,'MENU_M',1,'');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org`
--

DROP TABLE IF EXISTS `org`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `org` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) NOT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='组织表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org`
--

LOCK TABLES `org` WRITE;
/*!40000 ALTER TABLE `org` DISABLE KEYS */;
INSERT INTO `org` VALUES (1,'集团','2018-02-02 17:18:50.000000'),(3,'信息科技部门',NULL),(4,'贵州银行','2018-02-02 17:18:56.000000'),(5,'贵州银行金融科技开发公司',NULL),(6,'金科研发',NULL),(7,'金科研发部门','2018-02-05 13:49:52.754000'),(8,'金科研发2部','2018-02-05 13:50:43.901000');
/*!40000 ALTER TABLE `org` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `CREATE_TIME` datetime(6) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=174 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'部门管理员',NULL),(2,'公司CEO',NULL),(3,'助理',NULL),(12,'2324324','2017-09-06 04:08:00.000000'),(13,'哈哈','2017-09-06 04:09:05.000000'),(15,'ivy','2017-09-06 05:35:04.000000'),(17,'我','2017-09-06 21:23:03.000000'),(18,'234','2017-09-06 21:41:03.000000'),(19,'1','2017-09-06 21:42:02.000000'),(173,'部门辅助管理员',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_function`
--

DROP TABLE IF EXISTS `role_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_function` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(65) DEFAULT NULL,
  `FUNCTION_ID` int(65) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_function`
--

LOCK TABLES `role_function` WRITE;
/*!40000 ALTER TABLE `role_function` DISABLE KEYS */;
INSERT INTO `role_function` VALUES (1,1,1),(2,1,2),(3,1,3),(4,2,2),(5,3,2),(6,3,3),(162,1,6),(164,1,91),(174,173,1),(176,173,2),(177,173,3),(178,173,167),(192,3,1),(194,3,12),(196,3,180),(197,NULL,1),(198,NULL,2),(199,NULL,3),(200,NULL,6),(201,NULL,91),(202,NULL,8),(205,1,182),(206,1,181);
/*!40000 ALTER TABLE `role_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_menu`
--

DROP TABLE IF EXISTS `role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_menu` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(65) DEFAULT NULL,
  `MENU_ID` int(65) DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_menu`
--

LOCK TABLES `role_menu` WRITE;
/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
INSERT INTO `role_menu` VALUES (1,1,10,NULL),(163,1,11,NULL),(175,173,10,NULL),(193,3,10,NULL),(195,3,17,NULL),(196,NULL,10,NULL),(197,NULL,11,NULL),(198,NULL,13,NULL),(200,1,23,NULL);
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `nickname` varchar(16) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  `update_Time` datetime DEFAULT NULL,
  `STATE` varchar(16) DEFAULT NULL COMMENT '用户状态 1:启用 0:停用',
  `EMAIL` varchar(30) DEFAULT '',
  `PHONE` varchar(11) DEFAULT '',
  `AVATAR` int(11) DEFAULT NULL,
  `RANK` int(11) NOT NULL DEFAULT '0',
  `SCORE` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','超级管理员1','24a70a4e5192772091287427f673eacf','2017-09-13 09:21:03.000000','2017-09-13 09:21:03','S1','','',NULL,0,0),(171,'lixx','李小小',NULL,'2018-01-28 11:21:20.914000',NULL,'S1','','',NULL,0,0),(172,'lixx2','李xx2','123456','2018-01-28 11:22:38.814000',NULL,'S1','','',NULL,0,0),(173,'test1','test1','123','2018-01-28 14:44:55.407000',NULL,'S1','','',NULL,0,0),(174,'hank250','李小熊',NULL,'2018-02-16 11:36:41.438000',NULL,'S1','','',NULL,0,0),(175,'test123','test12344',NULL,'2018-03-11 16:19:21.675000',NULL,'S1','','',NULL,0,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(20) DEFAULT NULL,
  `ROLE_ID` int(20) DEFAULT NULL,
  `ORG_ID` int(20) DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,3,1,4,NULL),(2,4,2,5,NULL),(3,75,3,6,'2017-09-21 18:03:05.000000'),(35,1,1,1,'2017-09-06 01:12:02.000000'),(36,1,3,6,'2017-09-06 03:33:05.000000'),(38,1,1,3,'2017-09-06 03:35:02.000000'),(41,1,1,5,'2017-09-06 03:58:02.000000'),(42,3,3,1,'2017-09-06 04:01:00.000000'),(47,47,3,1,'2017-09-06 22:00:01.000000'),(49,5,3,4,'2017-09-06 22:01:00.000000'),(52,47,2,1,'2017-09-07 01:12:02.000000'),(53,48,3,4,'2017-09-07 01:14:04.000000'),(55,68,2,3,'2017-09-07 21:42:03.000000'),(125,74,1,4,'2017-10-17 09:37:02.000000'),(144,74,3,NULL,'2017-10-17 16:55:00.000000'),(145,67,3,NULL,'2017-10-17 16:55:01.000000'),(146,73,3,NULL,'2017-10-17 16:55:02.000000'),(147,22,3,NULL,'2017-10-17 16:55:04.000000'),(148,68,3,NULL,'2017-10-17 16:56:00.000000'),(168,72,1,3,'2017-10-24 14:40:04.000000'),(169,41,1,NULL,'2017-10-25 08:58:01.000000'),(171,170,1,5,'2017-10-25 09:08:05.000000'),(172,171,1,4,'2018-02-02 09:36:40.967000');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-16 11:52:37
