import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.assertionMode;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ SoftAsserts.class})
public class ConfigTests {
    public ConfigTests(){
        Configuration.timeout = 5000;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        baseUrl = "http://the-internet.herokuapp.com";

        assertionMode = AssertionMode.SOFT;
    }
    @BeforeMethod
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @Test
    public void test(){
        open(baseUrl);
    }
    @AfterMethod
    public void closeBrowser(){
        closeWebDriver();
    }

}

