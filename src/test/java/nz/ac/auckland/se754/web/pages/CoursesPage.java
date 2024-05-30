package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CoursesPage {
    public CoursesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".course-item")
    private List<WebElement> courses;

    @FindBy(how = How.CSS, using = ".course-tag")
    private List<WebElement> tags;

    public List<WebElement> getCourses() {
        return courses;
    }

    public ArrayList<String> getCourseTags() {
        ArrayList<String> courseTags = new ArrayList<>();
        for (WebElement tag : tags) {
            courseTags.add(tag.getText());
        }
        return courseTags;
    }
}
