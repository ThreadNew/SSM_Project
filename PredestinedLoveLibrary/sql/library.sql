/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-28 11:31:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'reader:readerLoad');
INSERT INTO `sys_permission` VALUES ('2', 'reader:toReader');
INSERT INTO `sys_permission` VALUES ('3', 'book:toBook');
INSERT INTO `sys_permission` VALUES ('4', 'book:insertBook');
INSERT INTO `sys_permission` VALUES ('5', 'book:findBookInfo');
INSERT INTO `sys_permission` VALUES ('6', 'book:deleteBook');
INSERT INTO `sys_permission` VALUES ('7', 'book:searchBook');
INSERT INTO `sys_permission` VALUES ('8', 'book:editBook');
INSERT INTO `sys_permission` VALUES ('9', 'iterm:all');
INSERT INTO `sys_permission` VALUES ('10', 'bookClass:toBookClass');
INSERT INTO `sys_permission` VALUES ('11', 'bookClass:insertBookClass');
INSERT INTO `sys_permission` VALUES ('12', 'bookClass:selectBookClass');
INSERT INTO `sys_permission` VALUES ('13', 'bookClass:deleteBookClass');
INSERT INTO `sys_permission` VALUES ('14', 'bookClass:editBookClass');
INSERT INTO `sys_permission` VALUES ('15', 'bookClass:updateBookClass');
INSERT INTO `sys_permission` VALUES ('16', 'borrow:toBorrow');
INSERT INTO `sys_permission` VALUES ('17', 'borrow:insertBorrow');
INSERT INTO `sys_permission` VALUES ('18', 'borrow:selectBorrowInfo');
INSERT INTO `sys_permission` VALUES ('19', 'borrow:deleteBorrow');
INSERT INTO `sys_permission` VALUES ('20', 'borrow:comeBorrowEdit');
INSERT INTO `sys_permission` VALUES ('21', 'borrow:borrowOperator');
INSERT INTO `sys_permission` VALUES ('22', 'reader:findReader');
INSERT INTO `sys_permission` VALUES ('23', 'reader:deleteReader');
INSERT INTO `sys_permission` VALUES ('24', 'reader:editReader');
INSERT INTO `sys_permission` VALUES ('25', 'reader:updateReader');
INSERT INTO `sys_permission` VALUES ('26', 'reader:searchReader');
INSERT INTO `sys_permission` VALUES ('27', 'readerType:insertReaderType');
INSERT INTO `sys_permission` VALUES ('28', 'readerType:searchReaderType');
INSERT INTO `sys_permission` VALUES ('29', 'readerType:editReaderType');
INSERT INTO `sys_permission` VALUES ('30', 'readerType:updateReaderType');
INSERT INTO `sys_permission` VALUES ('31', 'readerType:deleteReaderType');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'SysManager');
INSERT INTO `sys_role` VALUES ('2', 'BookManager');
INSERT INTO `sys_role` VALUES ('3', 'Manager');

-- ----------------------------
-- Table structure for `sys_rp`
-- ----------------------------
DROP TABLE IF EXISTS `sys_rp`;
CREATE TABLE `sys_rp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) NOT NULL,
  `perName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_rp
-- ----------------------------
INSERT INTO `sys_rp` VALUES ('1', 'SysManager', 'iterm:all');
INSERT INTO `sys_rp` VALUES ('2', 'Manager', 'reader:toReader');
INSERT INTO `sys_rp` VALUES ('4', 'BookManager', 'book:toBook');
INSERT INTO `sys_rp` VALUES ('5', 'BookManager', 'book:insertBook');
INSERT INTO `sys_rp` VALUES ('6', 'BookManager', 'book:findBookInfo');
INSERT INTO `sys_rp` VALUES ('7', 'BookManager', 'book:deleteBook');
INSERT INTO `sys_rp` VALUES ('8', 'BookManager', 'book:searchBook');
INSERT INTO `sys_rp` VALUES ('9', 'BookManager', 'book:editBook');
INSERT INTO `sys_rp` VALUES ('10', 'BookManager', 'bookClass:toBookClass');
INSERT INTO `sys_rp` VALUES ('11', 'BookManager', 'bookClass:insertBookClass');
INSERT INTO `sys_rp` VALUES ('12', 'BookManager', 'bookClass:selectBookClass');
INSERT INTO `sys_rp` VALUES ('13', 'BookManager', 'bookClass:deleteBookClass');
INSERT INTO `sys_rp` VALUES ('14', 'BookManager', 'bookClass:editBookClass');
INSERT INTO `sys_rp` VALUES ('15', 'BookManager', 'bookClass:updateBookClass');
INSERT INTO `sys_rp` VALUES ('16', 'Manager', 'borrow:toBorrow');
INSERT INTO `sys_rp` VALUES ('17', 'Manager', 'borrow:insertBorrow');
INSERT INTO `sys_rp` VALUES ('18', 'Manager', 'borrow:selectBorrowInfo');
INSERT INTO `sys_rp` VALUES ('19', 'Manager', 'borrow:deleteBorrow');
INSERT INTO `sys_rp` VALUES ('20', 'Manager', 'borrow:comeBorrowEdit');
INSERT INTO `sys_rp` VALUES ('21', 'Manager', 'borrow:borrowOperator');
INSERT INTO `sys_rp` VALUES ('22', 'Manager', 'reader:findReader');
INSERT INTO `sys_rp` VALUES ('23', 'Manager', 'reader:searchReader');

-- ----------------------------
-- Table structure for `sys_ur`
-- ----------------------------
DROP TABLE IF EXISTS `sys_ur`;
CREATE TABLE `sys_ur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_ur
-- ----------------------------
INSERT INTO `sys_ur` VALUES ('5', '201503396', 'SysManager');
INSERT INTO `sys_ur` VALUES ('7', '201503395', 'BookManager');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `date` date DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '201503396', '1234', '2018-04-15', 'upload/313560.jpg');
INSERT INTO `sys_user` VALUES ('4', '201503395', '1234', '2018-04-27', 'upload/313593.jpg');
INSERT INTO `sys_user` VALUES ('5', '201503394', '1234', '2018-04-27', 'upload/312229.jpg');

-- ----------------------------
-- Table structure for `tb_book`
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `bkID` varchar(20) NOT NULL,
  `bkCode` varchar(20) NOT NULL,
  `bkName` varchar(50) NOT NULL,
  `bkAuthor` varchar(30) DEFAULT NULL,
  `bkPress` varchar(50) DEFAULT NULL,
  `bkDatePress` date DEFAULT NULL,
  `bkISBN` varchar(15) NOT NULL,
  `bkCatalog` varchar(30) NOT NULL,
  `bkLanguage` varchar(20) DEFAULT NULL,
  `bkPages` int(11) DEFAULT NULL,
  `bkPrice` float DEFAULT NULL,
  `bkDateIn` date DEFAULT NULL,
  `bkBrief` varchar(100) DEFAULT NULL,
  `bkCover` varchar(50) DEFAULT NULL,
  `bkStatus` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`bkID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('0001', '12345', '计算机科学与技术', '陈强', '长江大学', '2018-04-05', '123456', 'TP', '日文', null, '65.5', '2018-04-19', '计算机', 'upload/book/111.jpg', '在馆');
INSERT INTO `tb_book` VALUES ('2', '2', '2', '2', '2', '2018-04-26', '2', 'TP', '中文', '85', '2', '2018-04-28', '2', 'upload/book/301041.jpg', '在馆');

-- ----------------------------
-- Table structure for `tb_bookclass`
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookclass`;
CREATE TABLE `tb_bookclass` (
  `bkCatalog` varchar(50) NOT NULL,
  `bkClassName` varchar(50) NOT NULL,
  PRIMARY KEY (`bkCatalog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookclass
-- ----------------------------
INSERT INTO `tb_bookclass` VALUES ('TP', '自动化技术');

-- ----------------------------
-- Table structure for `tb_borrow`
-- ----------------------------
DROP TABLE IF EXISTS `tb_borrow`;
CREATE TABLE `tb_borrow` (
  `borrowID` int(11) NOT NULL AUTO_INCREMENT,
  `rdID` varchar(50) NOT NULL,
  `bkID` varchar(50) NOT NULL,
  `idContinueTimes` int(11) DEFAULT NULL,
  `idDateOut` date NOT NULL,
  `idDateRetPlan` date NOT NULL,
  `idOverDay` int(11) DEFAULT NULL,
  `idOverMoney` float DEFAULT NULL,
  `idPunishMoney` float DEFAULT NULL,
  `isHasReturn` varchar(255) NOT NULL,
  `operatorLend` varchar(255) DEFAULT NULL,
  `operatorRet` varchar(255) DEFAULT NULL,
  `idDateRetAct` date DEFAULT NULL,
  PRIMARY KEY (`borrowID`),
  KEY `rdID` (`rdID`),
  KEY `bkID` (`bkID`),
  CONSTRAINT `tb_borrow_ibfk_1` FOREIGN KEY (`rdID`) REFERENCES `tb_reader` (`rdID`),
  CONSTRAINT `tb_borrow_ibfk_2` FOREIGN KEY (`bkID`) REFERENCES `tb_book` (`bkID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_borrow
-- ----------------------------
INSERT INTO `tb_borrow` VALUES ('7', '201503396', '2', '2', '2018-04-26', '2018-05-11', '-14', '-0.7', '-0.7', '已还', 'q', 'v', '2018-04-26');

-- ----------------------------
-- Table structure for `tb_reader`
-- ----------------------------
DROP TABLE IF EXISTS `tb_reader`;
CREATE TABLE `tb_reader` (
  `rdID` varchar(50) NOT NULL,
  `rdName` varchar(20) NOT NULL,
  `rdSex` varchar(2) DEFAULT NULL,
  `rdType` smallint(6) NOT NULL,
  `rdDept` varchar(50) DEFAULT NULL,
  `rdPhone` varchar(20) DEFAULT NULL,
  `rdEmail` varchar(30) DEFAULT NULL,
  `rdDateReg` date DEFAULT NULL,
  `rdPhoto` varchar(50) DEFAULT NULL,
  `rdStatus` varchar(10) NOT NULL,
  `rdBorrowQty` int(11) DEFAULT NULL,
  `rdPwd` varchar(20) NOT NULL,
  `rdAdminRoles` varchar(20) NOT NULL,
  PRIMARY KEY (`rdID`),
  KEY `rdType` (`rdType`),
  CONSTRAINT `tb_reader_ibfk_1` FOREIGN KEY (`rdType`) REFERENCES `tb_readertype` (`rdType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('201503394', '陈悦', '女', '0', '长江大学', '13677203517', '1402583417@qq.com', '2018-04-27', 'upload/312229.jpg', '有效', '0', '1234', 'Manager');
INSERT INTO `tb_reader` VALUES ('201503395', '陈真', '男', '0', '长江大学', '13677203517', '1402583417@qq.com', '2018-04-27', 'upload/313593.jpg', '有效', '0', '1234', 'BookManager');
INSERT INTO `tb_reader` VALUES ('201503396', '陈强', '男', '0', '长江大学', '13677203517', '1402583417@qq.com', '2018-04-17', 'upload/313560.jpg', '有效', '0', '1234', 'SysManager');

-- ----------------------------
-- Table structure for `tb_readertype`
-- ----------------------------
DROP TABLE IF EXISTS `tb_readertype`;
CREATE TABLE `tb_readertype` (
  `rdType` smallint(6) NOT NULL,
  `rdTypeName` varchar(20) NOT NULL,
  `CanLendQty` int(11) DEFAULT NULL,
  `CanLendDay` int(11) DEFAULT NULL,
  `CanContinueTimes` int(11) DEFAULT NULL,
  `PunishRate` float DEFAULT NULL,
  `DateValid` smallint(5) unsigned zerofill NOT NULL,
  PRIMARY KEY (`rdType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_readertype
-- ----------------------------
INSERT INTO `tb_readertype` VALUES ('0', '教师', '5', '15', '5', '0.05', '00000');
INSERT INTO `tb_readertype` VALUES ('1', '学生', '3', '10', '3', '0.1', '00004');
