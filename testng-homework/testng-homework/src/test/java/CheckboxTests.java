import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

@Listeners({ SoftAsserts.class})
public class CheckboxTests extends ConfigTests{
    @BeforeClass
    public void beforeClass(){
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "src/main/resources/CheckboxFailedTests";
        Configuration.baseUrl = " http://the-internet.herokuapp.com";
    }

    @Test
    public void checkboxTest(){
        open("/checkboxes");
        ElementsCollection checkbox = $("#checkboxes").$$(by("type", "checkbox"));
        checkbox.forEach(box ->box.setSelected(true));
        softAssert.assertFalse((checkbox.get(0).isSelected()), "first checkbox is selected");
    }
    @Test(dependsOnMethods = "checkboxTest")
    public void uncheckboxTest(){
        open("/checkboxes");
        ElementsCollection checkbox = $("#checkboxes").$$(by("type", "checkbox"));
        checkbox.forEach(box ->box.setSelected(false));
        softAssert.assertFalse((checkbox.get(0).isSelected()), "first checkbox is not selected");
    }

}
