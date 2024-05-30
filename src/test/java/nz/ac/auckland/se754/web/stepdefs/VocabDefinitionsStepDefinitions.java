package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.LessonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VocabDefinitionsStepDefinitions {
    private WebDriver driver;
    private LessonPage lessonPage;
    private String word;


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
        lessonPage = new LessonPage(driver);
    }

    @AfterStep
    public void afterEachStep() {
        // to make the test at human speed
        if (System.getenv().getOrDefault("headless", "false").equals("false")) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am in a lesson")
    public void i_am_in_a_lesson() {
        driver.get("http://localhost:8080/lesson");
    }

    @Given("The word has a definition")
    public void the_word_has_a_definition() {
        word = "valid word";
        lessonPage.insertWord(word);
    }

    @Given("The word does not have a definition")
    public void the_word_does_not_have_a_definition() {
        word = "invalid word";
        lessonPage.insertWord(word);
    }

    @Given("The word has an example")
    public void the_word_has_an_example() {
        word = "valid word";
        lessonPage.insertWord(word);
    }

    @When("I click on the definition button")
    public void i_click_on_the_definition_button() {
        lessonPage.clickDefinitionButton();
    }

    @When("I click on the example button")
    public void i_click_on_the_example_button() {
        lessonPage.clickExampleButton();
    }

    @Then("I should see the definition of the word")
    public void i_should_see_the_definition_of_the_word() {
        String definition = lessonPage.getDefinition();
        String expectedDefinition = "valid definition";
        assertEquals(definition, expectedDefinition);

    }

    @Then("I should see an alert message pop-up saying unable to find definition")
    public void i_should_see_an_alert_message_pop_up_saying_unable_to_find_definition() {
        String alertText = lessonPage.getAlertText();
        String expectedAlertText = "Unable to find definition";
        assertEquals(alertText, expectedAlertText);
    }

    @Then("I should see the example of the word")
    public void i_should_see_the_example_of_the_word() {
        String example = lessonPage.getExample();
        String expectedExpected = "valid example";
        assertEquals(example, expectedExpected);

    }
}
