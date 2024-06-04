package nz.ac.auckland.se754.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CourseCategoryPage {

    @FindBy(className = "category-name")
    private List<WebElement> categoryNames;
    public CourseCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String[] getCategories() {
        return categoryNames.stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
    }
}
