import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class})
public class CheckboxTests extends ConfigTests{
    int x = 1;
    @BeforeClass
    public void beforeClass(){
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "src/main/resources/CheckboxFailedTests";
        Configuration.baseUrl = " http://the-internet.herokuapp.com";
    }

    //@Test(dependsOnMethods = "beforeClass", alwaysRun = true)
    @Test(groups = {"FrontEnd"})
    public void checkboxTest(){
        open("/checkboxes");
        ElementsCollection checkbox = $("#checkboxes").$$(by("type", "checkbox"));
        checkbox.forEach(box ->box.setSelected(true));
        softAssert.assertFalse((checkbox.get(0).isSelected()), "first checkbox is selected");
    }
    //@Test(priority = 2)
    @Test(groups = {"BackEnd"})
    public void uncheckboxTest(){
        open("/checkboxes");
        ElementsCollection checkbox = $("#checkboxes").$$(by("type", "checkbox"));
        checkbox.forEach(box ->box.setSelected(false));
        softAssert.assertFalse((checkbox.get(0).isSelected()), "first checkbox is not selected");
    }
    @Test(retryAnalyzer = Retry.class)
    public void retryTest(){
        Assert.assertEquals(x,6);
        counter();
    }
    private int counter(){
        return x++;
    }

}
