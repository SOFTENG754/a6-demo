package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.LessonPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LearningWithVisualizationStepDefinitions {
    private LessonPage lessonPage;
    private String word;

    @Before("@learningWithVisualization")
    public void before() {
        WebDriver driver = ChromeWebDriverManager.getDriver();
        lessonPage = new LessonPage(driver);
    }

    @Given("The word has an image")
    public void the_word_has_an_image() {
        word = "valid word";
        lessonPage.insertWord(word);
    }

    @Given("The word does not have an image")
    public void the_word_does_not_have_an_image() {
        word = "invalid word";
        lessonPage.insertWord(word);
    }

    @Given("The server is down when getting image")
    public void the_server_is_down_when_getting_image() {
        word = "server down";
        lessonPage.insertWord(word);
    }

    @When("I click on the show image button")
    public void i_click_on_the_show_image_button() {
        lessonPage.clickShowImageButton();
    }

    @Then("I should see the image of the word")
    public void i_should_see_the_image_of_the_word() {
        // @todo this is a workaround to wait for image to load
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String expectedImageUrl = "http://localhost:8080/path/to/dummy/image.png";
        String imageUrl = lessonPage.getImageUrl();
        assertEquals(expectedImageUrl, imageUrl);
    }

    @Then("I should see the default image")
    public void i_should_see_the_default_image() {
        String expectedImageUrl = "http://localhost:8080/path/to/default/image.png";
        String imageUrl = lessonPage.getImageUrl();
        assertEquals(expectedImageUrl, imageUrl);
    }

    @Then("I should see an error message saying connection error")
    public void i_should_see_an_error_message_saying_connection_error() {
        String alertText = lessonPage.getAlertText();
        String expectedAlertText = "Connection error";
        assertEquals(expectedAlertText, alertText);
    }
}
