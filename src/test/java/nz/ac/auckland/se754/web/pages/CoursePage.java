package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CoursePage {
    @FindBy(how = How.ID, using = "course-one")
    private WebElement courseOne;

    @FindBy(how = How.ID, using = "course-one-progress")
    private WebElement courseOneProgress;

    public CoursePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCourseOne() {
        courseOne.click();
    }

    public String getProgress() {
        return courseOneProgress.getText();
    }
}
