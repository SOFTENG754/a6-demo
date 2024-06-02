package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    private final WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public int getScreenTime() {
        WebElement screenTimeElement = driver.findElement(By.id("screenTime"));
        return Integer.parseInt(screenTimeElement.getText());
    }

    public void setScreenTime(int minutes) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("updateScreenTime(arguments[0]);", minutes);
    }

    public int getBreakTime() {
        WebElement breakTimeElement = driver.findElement(By.id("breakTime"));
        return Integer.parseInt(breakTimeElement.getText());
    }

    public void setBreakTime(int minutes) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("updateBreakTime(arguments[0]);", minutes);
    }

    public String getNotification() {
        WebElement notificationElement = driver.findElement(By.id("notification"));
        return notificationElement.getText();
    }
}
