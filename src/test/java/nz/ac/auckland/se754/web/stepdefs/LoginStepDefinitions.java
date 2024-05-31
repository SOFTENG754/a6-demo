package nz.ac.auckland.se754.web.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before("@login")
    public void before() {
        driver = ChromeWebDriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I visit the login page")
    public void i_visit_the_login_page() {
        driver.get("http://localhost:8080/login");
    }

    @When("I enter {string} as user name field")
    public void i_enter_as_user_name_field(String string) {
        loginPage.insertUserName(string);
    }

    @When("I enter {string} as password field")
    public void i_enter_as_password_field(String string) {
        loginPage.insertPassword(string);
    }

    @When("I press the submit button")
    public void i_press_the_submit_button() {
        loginPage.clickLogin();
    }

    @Then("I should see the welcome page")
    public void i_should_see_the_welcome_page() {
        assertTrue(loginPage.getMessage().contains("Welcome user1"));
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        assertTrue(loginPage.getError().contains("Invalid Credentials"));
    }
}
