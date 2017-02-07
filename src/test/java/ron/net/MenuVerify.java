package ron.net;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ron.net.pages.HomePage;
import ron.net.support.TestNgTestBase;

import java.io.IOException;

/**
 * Created by RomanTo on 2/7/2017.
 */
public class MenuVerify extends TestNgTestBase {
    private HomePage homepage;

    public MenuVerify() throws IOException {
    }

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        driver.get(baseUrl);
    }

    @Test
    public void menuVerify(){
        homepage.hoverOverElement(homepage.smallBusinessLink, homepage.makeMoneyLink);
        Assert.assertTrue(homepage.isElementPresent(homepage.makeMoneyLink));
    }

    @Test
    public void menuLinkVerify(){
        homepage.hoverOverElement(homepage.smallBusinessLink, homepage.makeMoneyLink);
        Assert.assertTrue(homepage.isElementPresent(homepage.makeMoneyLink));
        Assert.assertEquals(homepage.getElementLink(homepage.makeMoneyLink), "https://alfabank" +
                ".ua/small-business/place-and-multiply/deposits", "broken links");
    }
}
