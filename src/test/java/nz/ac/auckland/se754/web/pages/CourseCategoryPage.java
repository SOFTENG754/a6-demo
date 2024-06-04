package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CourseCategoryPage {
    public CourseCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String[] getCategories() {
        return new String[]{};
    }
}
