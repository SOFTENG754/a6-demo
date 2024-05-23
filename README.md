# SOFTENG754 Demo A6 - 2024

Demo SpringBoot + JSP + Cucumber + Selenium

Requires Gradle 7.3

at `gradle/wrapper/gradle-wrapper.properties`
you should have
`distributionUrl=https\://services.gradle.org/distributions/gradle-7.3-all.zip`

Tested with JDK 17

Make sure you have the right driver for your browser under webdrivers fodler

also you need to set the env variables "headless" to true or false.
Headless means that run the Selenium driver without opening the browser, this is needed for CI

to run the web application
`./gradlew bootRun`
then go to http://localhost:8080/login
username: user1 password:password

to run the cucumber tests
` ./gradlew cucumber`
