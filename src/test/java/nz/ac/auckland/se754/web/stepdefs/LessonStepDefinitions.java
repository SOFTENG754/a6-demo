package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import nz.ac.auckland.se754.web.pages.LessonPage;
import org.openqa.selenium.WebDriver;

public class LessonStepDefinitions {
    private WebDriver driver;

    @Before("@vocabDefinitions or @learningWithVisualization or @learningWithAudio or @reviewFailedTasks")
    public void before() {
        driver = ChromeWebDriverManager.getDriver();
    }

    @Given("I am in a lesson")
    public void i_am_in_a_lesson() {
        driver.get("http://localhost:8080/lesson");
    }
}
