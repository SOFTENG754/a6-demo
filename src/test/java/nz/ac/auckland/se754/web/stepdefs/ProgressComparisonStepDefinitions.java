package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.CoursesPage;
import nz.ac.auckland.se754.web.pages.LoginPage;
import nz.ac.auckland.se754.web.pages.ProgressPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ProgressComparisonStepDefinitions {

    WebDriver driver;
    CoursesPage coursesPage;
    ProgressPage progressPage;
    LoginPage loginPage;
    String userName;
    String password;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        String osName = System.getProperty("os.name").toLowerCase();

        if (System.getenv().getOrDefault("headless", "false").equals("true")) {
            options.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver", "webdrivers/linux/chromedriver");
        } else if(osName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        } else if(osName.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/win/chromedriver.exe");
        }

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1200");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        coursesPage = new CoursesPage(driver);
        loginPage = new LoginPage(driver);
        progressPage = new ProgressPage(driver);
    }

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        if (System.getenv().getOrDefault("headless", "false").equals("false")) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
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
}
