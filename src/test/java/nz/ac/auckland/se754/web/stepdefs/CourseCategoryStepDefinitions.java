package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import nz.ac.auckland.se754.web.pages.CourseCategoryPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CourseCategoryStepDefinitions {
    private WebDriver driver;
    private CourseCategoryPage courseCategoryPage;

    @Before("@courseCategory")
    public void setup() {
        driver = ChromeWebDriverManager.getDriver();
        courseCategoryPage = new CourseCategoryPage(driver);
    }

    @Given("I visit the course category page")
    public void i_visit_the_course_category_page() {
        driver.get("http://localhost:8080/category");
    }

    @Then("I should see all available course categories")
    public void i_should_see_all_available_course_categories() {
        String[] categories = courseCategoryPage.getCategories();
        assertArrayEquals(new String[]{"Category 1", "Category 2", "Category 3"}, categories);

    }
}
