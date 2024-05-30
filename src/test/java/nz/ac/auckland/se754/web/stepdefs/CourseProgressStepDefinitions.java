package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.CoursePage;
import nz.ac.auckland.se754.web.pages.CoursesPage;
import nz.ac.auckland.se754.web.pages.LoginPage;
import nz.ac.auckland.se754.web.service.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CourseProgressStepDefinitions {
    WebDriver driver;
    CoursesPage coursesPage;
    CoursePage coursePage;
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
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        coursesPage = new CoursesPage(driver);
        loginPage = new LoginPage(driver);
        coursePage = new CoursePage(driver);
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
        driver.quit();
    }

    @Given("I am new to the site")
    public void i_am_new_to_the_site() {
        userName = "newUser";
        password = "password";
    }

    @Given("I am a returning user")
    public void i_am_a_returning_user() {
        userName = "returnUser";
        password = "password";
    }

    @Given("I am logged in")
    public void i_am_logged_in() {
        driver.get("http://localhost:8080/login");
        loginPage.insertUserName(userName);
        loginPage.insertPassword(password);
        loginPage.clickLogin();
    }

    @When("I visit the courses page")
    public void iVisitTheCoursesPage() {
        driver.get("http://localhost:8080/courses");
    }

    @When("I selected a new course")
    public void iSelectedANewCourse() {
        coursePage.selectCourseOne();
    }

    @Then("I should be directed to the course page")
    public void iShouldBeDirectedToTheCoursePage() {
        String expectedUrl = "http://localhost:8080/courses/1";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @And("see my progress for this course to be initialized")
    public void seeMyProgressForThisCourseToBeInitialized() {
        String progressString = coursePage.getProgress();
        String expectedString = "0/2";
        assertEquals(expectedString, progressString);
    }
}
