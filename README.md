# Cucumber framework basics - Demo
### Demo-project for illustration cucumber framework & ui automation on ["Планета Кіно" website](https://planetakino.ua/)

### Software requirements
- [Java 8+](https://java.com/en/) 
- [Maven 3+](https://maven.apache.org/download.cgi) are required for running the project. The framework uses [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java), [Webdriver Manager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager) and [TestNG](https://mvnrepository.com/artifact/org.testng/testng).

### Local setup
To perform successful run you need to specify your planetakino.ua credentials in src/main/resources/config/prod.properties file first

To run "all green" tests demo:
```
mvn clean test -Dcucumber.filter.tags=@smoke
```
To run example tables demo:
```
mvn clean test -Dcucumber.filter.tags=@security_check
```
You run demo with passed/failed/pending tests:
```
mvn clean test -Dcucumber.filter.tags=@reporting_demo
```

### Bonus
bonus.feature file contains different localization
Please visit for more information [Cucumber official guides](https://cucumber.io/docs/guides/)