import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Configuration.assertionMode;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class})
public class RadioButtonTests {

    public RadioButtonTests(){
        baseUrl = " https://demoqa.com ";
        assertionMode = AssertionMode.SOFT;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "src/main/resources/RadioButtonFailedTests";
        Configuration.reopenBrowserOnFail = true;
    }
    @BeforeMethod
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
    }
    @Test(invocationCount = 1, timeOut = 10)
    public void radioButtonTest(){
        open("/radio-button");
        clickYesButton();
        checkNoOption();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }
    @Test(dependsOnMethods = "radioButtonTest")
    public void clickYesButton(){
        $(By.id("yesRadio")).click();
    }
    @Test(dependsOnMethods = "clickYesButton")
    public void checkNoOption(){
        if($(By.id("noButton")).exists()){
            try{
                $(By.id("noButton")).click();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
    @AfterMethod
    public void closeBrowser(){
        closeWebDriver();
    }
}