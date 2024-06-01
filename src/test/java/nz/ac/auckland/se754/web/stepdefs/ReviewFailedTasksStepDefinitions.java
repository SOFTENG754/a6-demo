package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.LessonPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ReviewFailedTasksStepDefinitions {
    private WebDriver driver;
    private LessonPage lessonPage;

    @Before("@reviewFailedTasks")
    public void before() {
        driver = ChromeWebDriverManager.getDriver();
        lessonPage = new LessonPage(driver);
    }

    @When("I have {int}% failed tasks")
    public void i_have_failed_tasks(Integer int1) {
        driver = ChromeWebDriverManager.getDriver();
        lessonPage = new LessonPage(driver);
        if (int1 == 0) {
            lessonPage.submitTask("task1", "a");
            lessonPage.submitTask("task2", "i");
        } else if (int1 == 50) {
            lessonPage.submitTask("task1", "a");
            lessonPage.submitTask("task2", "incorrectAnswer");
        } else if (int1 == 100) {
            lessonPage.submitTask("task1", "incorrectAnswer");
            lessonPage.submitTask("task2", "incorrectAnswer");
        }
    }

    @Then("I should see a list of tasks with no failed tasks")
    public void i_should_see_a_list_of_tasks_with_no_failed_tasks() {
        String taskOneStatus = lessonPage.getTaskStatus("task1");
        String taskTwoStatus = lessonPage.getTaskStatus("task2");
        String expectedTaskOneStatus = "Passed: task1";
        String expectedTaskTwoStatus = "Passed: task2";
        assertEquals(expectedTaskOneStatus, taskOneStatus);
        assertEquals(expectedTaskTwoStatus, taskTwoStatus);
    }

    @Then("I should see a list of tasks with half failed tasks")
    public void i_should_see_a_list_of_tasks_with_half_failed_tasks() {
        String taskOneStatus = lessonPage.getTaskStatus("task1");
        String taskTwoStatus = lessonPage.getTaskStatus("task2");
        String expectedTaskOneStatus = "Passed: task1";
        String expectedTaskTwoStatus = "Failed: task2";
        assertEquals(expectedTaskOneStatus, taskOneStatus);
        assertEquals(expectedTaskTwoStatus, taskTwoStatus);
    }

    @Then("I should see a list of tasks with all failed tasks")
    public void i_should_see_a_list_of_tasks_with_all_failed_tasks() {
        String taskOneStatus = lessonPage.getTaskStatus("task1");
        String taskTwoStatus = lessonPage.getTaskStatus("task2");
        String expectedTaskOneStatus = "Failed: task1";
        String expectedTaskTwoStatus = "Failed: task2";
        assertEquals(expectedTaskOneStatus, taskOneStatus);
        assertEquals(expectedTaskTwoStatus, taskTwoStatus);
    }

}
