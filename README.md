# SOEN 6011 Project: Advanced Tangent Calculator

## Overview
This repository hosts the "6011 Project," a Java application developed as part of the SOEN6011 course. The application provides a graphical user interface for calculating the tangent resuls with user inputs.

## Features
- Calculate the tangent of any given angle in degrees or radians.
- Handle special cases where the tangent function is undefined.
- Graphical User Interface for easy interaction with the calculator.

## Prerequisites
To build and run this project, you need:
- Java JDK 11 or newer
- Apache Maven 3.6.3 or higher

## Getting Started


### Clone the Repository
To get started with this project, first clone the repository to your local machine:

```bash
git@github.com:itshisher/SOEN6011_project_tangent_function.git
```

### Programming Style 
Styling checked by PMD, following is the command:
```bash
pmd check -d /Users/itshisher/Desktop/Master\ degree/Summer\ 2024/SOEN6011/project/SOEN6011_project_tangent_function/tangentFunction/src -R rulesets/java/quickstart.xml -f text > PMDReport.txt

```

### Code Analysis
static code analyzed locally by SonarQube, following is the code to run the analysis: 
```bash
mvn clean
verify sonar:sonar
-Dsonar.projectKey=6011project
-Dsonar.projectName='6011project'
-Dsonar.host.url=http://localhost:9000
-Dsonar.token=sqp_4020947251f574ab99d20f205c62138f70ebcda9
```

### Semantic Versioning
Semantic Versioning provided by logs in the txt file called **version**.

### Junit test cases
This project uses JUnit for unit testing. To run the tests, execute:
```bash
mvn test
```
Make sure the directory is under the main folder **tangentFunction**.


