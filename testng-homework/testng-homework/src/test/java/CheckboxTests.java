import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.assertionMode;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class})
public class CheckboxTests {
    public CheckboxTests(){
        baseUrl = " http://the-internet.herokuapp.com";
        assertionMode = AssertionMode.SOFT;
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "src/main/resources/CheckboxFailedTests";
    }
    @BeforeMethod
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
    }
    @Test(invocationCount = 1, timeOut = 10)
    public void checkboxTest(){
        open("/checkboxes");
        checkCheckbox();
        checkUncheckedCheckbox();
    }
    @Test(priority = 2)
    public void checkUncheckedCheckbox(){
        SelenideElement checkBox =   $$("input").first();
        checkBox.setSelected(false);
        checkBox.is(Condition.enabled);
    }
    @Test(priority = 1)
    public void checkCheckbox(){
        SelenideElement checkBox =   $$("input").last();
        checkBox.setSelected(true);
        checkBox.is(Condition.disabled);

    }
    @AfterMethod
    public void closeBrowser(){
        closeWebDriver();
    }
}
