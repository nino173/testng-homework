import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners({ SoftAsserts.class})
public class ConfigTests {
    SoftAssert softAssert = new SoftAssert();
    @BeforeSuite
    public void beforeSuit(){
        Configuration.timeout = 5000;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
    }

    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }
    @AfterMethod
    public void afterMethod(){
        WebDriverRunner.closeWebDriver();
    }

    @AfterClass
    public void afterClass(){
        softAssert.assertAll();
    }
}

