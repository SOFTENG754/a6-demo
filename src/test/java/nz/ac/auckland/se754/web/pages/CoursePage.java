package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
    public CoursePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCourse() {
    }

    public String getProgress() {
        return "";
    }
}
