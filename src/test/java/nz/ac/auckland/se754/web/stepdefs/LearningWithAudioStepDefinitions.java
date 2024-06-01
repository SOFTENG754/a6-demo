package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.LessonPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LearningWithAudioStepDefinitions {
    private LessonPage lessonPage;
    private String word;

    @Before("@learningWithAudio")
    public void before() {
        WebDriver driver = ChromeWebDriverManager.getDriver();
        lessonPage = new LessonPage(driver);
    }

    @Given("I select a word has pronunciation available")
    public void i_select_a_word_has_pronunciation_available() {
        word = "valid word";
        lessonPage.insertWord(word);
    }

    @When("I click on the pronounce button")
    public void i_click_on_the_pronounce_button() {
        lessonPage.clickPronounceButton();
    }

    @Then("I should hear the pronunciation of the word")
    public void i_should_see_the_image_of_the_word() {
        // @todo this is a workaround to wait for image to load
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String expectedPronounceAudioUrl = "http://localhost:8080/path/to/dummy/audio.wav";
        String pronounceAudioUrl = lessonPage.getPronounceAudioUrl();
        assertEquals(expectedPronounceAudioUrl, pronounceAudioUrl);
    }
}
