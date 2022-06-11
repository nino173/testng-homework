import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Configuration.assertionMode;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class})
public class RadioButtonTests extends ConfigTests {
    @BeforeClass
    public void beforeclass(){
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "src/main/resources/RadioButtonFailedTests";
        Configuration.reopenBrowserOnFail = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test()
   public void yesradiobuttonTest(){
        open("/radio-button");
        SelenideElement yesButton = $(by("for","yesRadio"));
        yesButton.click();
        softAssert.assertFalse(yesButton.isEnabled(),"option YES is enabled");
   }
    @Test
    public void noradiobuttonTest(){
        open("/radio-button");
        SelenideElement noButton = $("#noRadio");
        softAssert.assertFalse(noButton.isEnabled(),"option NO is available");
    }


}