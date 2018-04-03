/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : prataculture

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-04-03 18:41:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_relevant_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_relevant_news`;
CREATE TABLE `t_relevant_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) NOT NULL,
  `research_date` varchar(50) DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_relevant_news
-- ----------------------------
INSERT INTO `t_relevant_news` VALUES ('1', '草业中心举办第五届学术交流年会', '2017-12-18 16:05:53', 'http://www.grass-env.com/news/20171218/n7550449.html', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('2', '“京津冀盐碱地生态植被修复联合实验室” 成立', '2017-8-23 11:27:04', 'http://www.grass-env.com/news/2017823/n9944440.html', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('3', '林 - 草 - 鸡生态种养循环现场观摩会成功举办', '2017-7-10 14:44:42', 'http://www.grass-env.com/news/2017710/n4397432.html', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('4', '草业中心举办第四届学术交流年会', '2016-12-27 15:38:44', 'http://www.grass-env.com/news/20161227/n4963413.html', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('5', '孟林研究员在第一届 “草畜 +” 一体化学术交流暨产业发展研讨会作学术报告', '2016-6-22 9:56:34 ', 'http://www.grass-env.com/news/2016622/n5864392.html', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('6', '第二届中蒙博览会——2017 年草原与草业创新发展国际论坛举行', '2017 年 09 月 28 日 08:53	', 'http://news.sina.com.cn/c/2017-09-28/doc-ifymksyw4467179.shtml', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('7', '2017全国草业机械学术交流会在西宁召开', '2017 年 08 月 25 日 09:10', 'http://news.sina.com.cn/c/2017-08-25/doc-ifykiurx1608644.shtml', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('8', '中科院内蒙古草业研究中心 2017 年度学术年会暨第一届学术委员会会议召开 吴团英出席并讲话', '2017 年 06 月 02 日 09:03', 'http://finance.sina.com.cn/roll/2017-06-02/doc-ifyfuvpm7122939.shtml', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('9', '肯尼亚、南非草牧业考察报告', '2017-7-24', 'http://www.caaa.cn/show/newsarticle.php?ID=385913', '2017-12-19 10:50:56');
INSERT INTO `t_relevant_news` VALUES ('10', '国家牧草产业技术创新战略联盟成果丰硕', '2017 年 01 月 16 日 12:13', 'http://www.xjxnw.gov.cn/c/2017-01-16/1101326.shtml', '2017-12-19 10:50:56');
