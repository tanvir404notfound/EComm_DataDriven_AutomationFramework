# E-Commerce Automation Framework

Description: A robust, scalable automation testing framework designed for e-commerce applications, utilizing Selenium Webriver, Java, Maven, TestNG, Docker, Selenium Grid, and Apache POI.
This project demonstrates data-driven testing and parallel execution for efficient testing workflows.

## Features
-Implements Page Object Model(POM) for better code reusability and maintainibilty.
-Supports data-driven testing with TestNG and Apache POI.
-Integrates parallel execution using TestNG, Selenium Grid, and Docker.
-Generates detailed reports with ExtentReports.->Comprehensive test coverage for UI and functional tests.


## Technologies Used
-Web Automation Tool: Selenium WebDriver
-Languages: Java
-Testing tool/framework: TestNG
-Build tool: Maven
-Reporting Tool: ExtentReports
-CI/CD: Jenkins

## Setup and installation
git clone https://github.com/tanvir404notfound/EComm_DataDriven_AutomationFramework.git
cd EComm_DataDriven_AutomationFramework
mvn install

## How to run the tests
mvn test

## Project Structure
src/test/java  -> Contains all test cases and assertions.
src/main/java  -> Contains page objectsand utilities
src/test/resources/  -> Test Data files(excel)
reports -> Generated ExtentReports(html).




