# Cucumber Hello World

* Requirement
```
Introduction to Cucumber using Hello World Example
```

## Create project using maven
```
mvn archetype:generate -DgroupId=hello.world -DartifactId=hello-world -Dversion=1.0 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Add gradle
```
gradle init --type pom
```
## Examples
* [Hello World Calculator](#hello-world-calculator)

### Hello World Calculator
* Create Core Java project using [maven](#create-project-using-maven)
* Create source folder - **src/test/resources**
* Create **features** folder in **src/test/resources**
* Create **[calculator_functions.feature](src/test/resources/features/calculator_functions.feature)** file
* Write **Gherkin** feature
* Write **[CalculatorTest.java](src/test/java/com/calculate/CalculatorTest.java)**
* **[CalculatorTest.java](src/test/java/com/calculate/CalculatorTest.java)** is mapped to **[calculator_functions.feature](src/test/resources/features/calculator_functions.feature)**
* Write **[CucumberTest.java](src/test/java/com/calculate/CucumberTest.java)**
* Declare below annotations at class level
```
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" }, snippets = SnippetType.CAMELCASE, features = "classpath:features")
```
* Right click on **[CucumberTest.java](src/test/java/com/calculate/CucumberTest.java)** - Run As - Junit Test
* Feature should be executed successfully