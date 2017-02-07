package ron.net;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ron.net.pages.HomePage;
import ron.net.support.TestNgTestBase;

import java.io.IOException;

public class SampleTestNgTest extends TestNgTestBase {

    private HomePage homepage;

    public SampleTestNgTest() throws IOException {
    }

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        driver.get(baseUrl);
    }

    @DataProvider(name = "alphaTest1")
    public static Object [][] credentials (){
        return new Object [][] {{"Incorrect Login1", "Incorrect password"},
              {"Incorrect Login with forbidden symbols", "Incorrect password"},
              {"Incorrect login with exceeding maximum length", "Incorrect password"},
              {"Incorrect login with post request", "password with post request"}};
    }

    @Test(dataProvider = "alphaTest1")
    public void loginWithIncorrectParameters(String login, String pass){
        homepage.login(login, pass);
        Assert.assertTrue(homepage.isElementPresent(homepage.errorField));


    }
}
