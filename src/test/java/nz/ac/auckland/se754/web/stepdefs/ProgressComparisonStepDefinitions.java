package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.CoursesPage;
import nz.ac.auckland.se754.web.pages.LoginPage;
import nz.ac.auckland.se754.web.pages.ProgressPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ProgressComparisonStepDefinitions {
    WebDriver driver;
    CoursesPage coursesPage;
    ProgressPage progressPage;
    LoginPage loginPage;
    String userName;
    String password;

    @Before("@compareLearningProgress")
    public void before() {
        driver = ChromeWebDriverManager.getDriver();
        coursesPage = new CoursesPage(driver);
        loginPage = new LoginPage(driver);
        progressPage = new ProgressPage(driver);
    }

    @Given("I am a new user to the application")
    public void iAmANewUserToTheApplication() {
        userName = "newUser";
        password = "password";
    }

    @Given("I just logged in")
    public void iJustLoggedIn() {
        driver.get("http://localhost:8080/login");
        loginPage.insertUserName(userName);
        loginPage.insertPassword(password);
        loginPage.clickLogin();
    }

    @When("I navigate to the progress page")
    public void iNavigateToTheProgressPage() {
        driver.get("http://localhost:8080/progress");
    }

    @Then("I should see my learning progress being initialized")
    public void iShouldSeeMyLearningProgressBeingInitialized() {
        String myProgress = progressPage.getMyProgress();
        String expectedProgress = "0 course completed";
        assertEquals(expectedProgress, myProgress);
    }

    @Given("I have visited the application before")
    public void iHaveVisitedTheApplicationBefore() {
        userName = "returnUser";
        password = "password";
    }

    @Given("I have completed a few courses")
    public void iHaveCompletedCourseCompletedCourses() {
        // backend related, nothing to test for frontend
    }

    @Then("I should see my learning progress as the number of courses I have completed")
    public void iShouldSeeMyLearningProgressIsLearningProgress() {
        String myProgress = progressPage.getMyProgress();
        String expectedProgress ="4 courses completed";
        assertEquals(expectedProgress, myProgress);
    }

    @When("I search for another user's username which exists")
    public void iSearchForAnotherUserSUsernameWhichExists() {
        progressPage.search("newUser");
    }

    @When("that user's learning progress is public")
    public void thatUserSLearningProgressIsPublic() {
        // backend code, not related to frontend testing
    }

    @Then("I should see their learning progress")
    public void iShouldSeeTheirLearningProgress() {
        String otherUserProgress = progressPage.getOtherUserProgress();
        String expectedProgress ="0 course completed";
        assertEquals(expectedProgress, otherUserProgress);
    }

    @When("I search for another user's username which does not exist")
    public void iSearchForAnotherUserSUsernameWhichDoesNotExist() {
        progressPage.search("randomUser");
    }

    @When("I search for another user which exists but set status to private")
    public void iSearchForAnotherUserWhichExistsButSetStatusToPrivate() {
        progressPage.search("returnUser");
    }

    @Then("I should see an error message indicating that I do not have access to the learning progress")
    public void iShouldSeeAnErrorMessageIndicatingThatIDoNotHaveAccessToTheLearningProgress() {
        String error = progressPage.getError();
        String expectedError = "The user you searched is not found or has set their status to private.";
        assertEquals(expectedError, error);
    }
}
