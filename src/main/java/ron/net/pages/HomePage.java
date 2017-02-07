package ron.net.pages;

import org.omg.CORBA.BooleanHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Sample page
 */
public class HomePage extends Page {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    //  @FindBy(how = How.TAG_NAME, using = "h1")
    @FindBy(xpath = "html/head/title")
    //  @CacheLookup
    public WebElement header;
    @FindBy(css = "#login")
    public WebElement loginField;
    @FindBy(css = "#password")
    public WebElement passwordField;
    @FindBy(css = "#LoginForm > .submit.btn.btn_red >.input_btn")
    public WebElement submitButton;
    @FindBy(css = ".error_txt>div>span")
    public WebElement errorField;
    @FindBy(css = ".nav_links :nth-child(1)")
    public WebElement privatePersonLink;
    @FindBy(css = ".nav_links :nth-child(2)")
    public WebElement smallBusinessLink;

    @FindBy(css = ".nav_links :nth-child(3)")
    public WebElement corpBusinessLink;
    @FindBy(css = ".nav_links :nth-child(4)")
    public WebElement finInstitutesLink;

    @FindBy(xpath = ".//*[@class='nav_main_sub']/div[2]/div/table/tbody/tr/td[3]/a")
    public WebElement makeMoneyLink;
//    @FindAll()

    public void login(String login, String password){
      loginField.sendKeys(login);
      passwordField.sendKeys(password);
      submitButton.click();
    }

    public void waitForElementPresent(){
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(elementToBeClickable(errorField));
    }

    public Boolean isElementPresent(WebElement elem){
        return elem.isDisplayed();
    }

    public void hoverOverElement(WebElement parentElement, WebElement childElement){
        Actions act = new Actions(driver);
        act.moveToElement(parentElement);
        act.perform();
        Assert.assertTrue(isElementPresent(childElement));
    }

    public String getElementLink(WebElement elem){
        return elem.getAttribute("href");
    }



}
