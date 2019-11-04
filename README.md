# Trello_Tets_JAVA
Selenium Project

Testing website with baseURL = https://trello.com/

For run the tests you need:

Java
Maven
chromedriver (https://chromedriver.chromium.org/)


Then you have to change:
1) In \src\test\java\driver\manager\DriverManager.java the path to your chromedriver

After that open console, navigate to project foler and run:
mvn clean test 
or if you have proxy :
mvn clean test -DproxySet=true -DproxyHost=xx.xxx.x.xx -DproxyPort=XXXX

Later you can generate allure report :
mvn allure:report
and open target/site/allure-maven-plugin/index.html

