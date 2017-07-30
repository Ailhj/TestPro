# TestPro
vuejs demo
programmed via Idea Intellij 2016.3


This project uses maven repository to manage all dependencies. The following artifacts can be found in pom.xml-
Spring mvc setting at spring-servlet.xml
spring-webmvc / spring-context / spring-core - 4.3.9.RELEASE
mysql-connector-java - 6.0.6
jackson-databind - 2.8.9
javax.mail - 1.5.6

Database - mysql 5.7.16
All connectors are within Utility/sqlUtil

Files of the project:
Controller/HomeController contains all controllers

Model/user is used to pass data to vuejs
Model/userView is used among the Utils
Model/emailVeri was planed to pass values for the emailConfirm page, which is implemented by a single string. Not used in project

Utility/emailUtil contains a function handling smtp
Utility/messsageUtil contains a function creating hashcode
Utility/sqlUtil contains all functions interacting with mysql
Utility/test is an executeable java file used as test sandbox. Not used in project

HTML files - old vuejs codes, have been transfered to jsp
JSP/test The main page.
JSP/test2 test sandbox. Not used in project
emailConfirm.jsp It is planned to be the view catching email verification data. Now is only getting a string.

The group effect is handle by vuejs, kids with the same parent will be assign a chechbox with the same binding value.
Email smtp is provided by gmail. 7 day expire/ issue limitation is applied
Verification message is digested from parent name via md5, currently no salt added.

user table columns:
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `kid` varchar(45) DEFAULT NULL,
  `parent` varchar(45) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `verification` varchar(45) DEFAULT NULL,
  `expireDate` datetime DEFAULT NULL,
  `issueCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`iduser`)

2017-07-29 Changes:
Add static resource exception in spring-servlet.xml which allow the access to HTML forder by mapping "/HTML/**"
Duplicate js code from JSP/test.jsp to HTML/test.html
The mapping for HTML/test.html is localhost/HTML/test.html
