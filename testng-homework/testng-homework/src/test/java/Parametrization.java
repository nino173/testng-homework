import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ SoftAsserts.class})
public class Parametrization extends ConfigTests{

    @BeforeClass
    public void beforeClass(){
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    @Parameters({"name","surname","gender","number"})
    public void parametrizationTest(String name, String surname, int gender, int number){
        open("/automation-practice-form");
        SelenideElement nameField = $(By.id("firstName"));
        nameField.sendKeys(name);
        SelenideElement surnameField = $(By.id("lastName"));
        surnameField.sendKeys(surname);
        ElementsCollection genderBox = $("#genterWrapper").$$(by("type", "radio"));
        if(gender<0) genderBox.first().click();
        if(gender>0) genderBox.last().click();
        if(gender==0) $(By.id("gender-ratio-2")).click();
        SelenideElement numberField = $(By.id("userNumber"));
        numberField.sendKeys("" + number);
        $(By.id("submit")).click();

        //validate student name
        nameField.shouldHave(Condition.text(name));
    }
    @Factory
    public Object[] factorymethod()
    {
        open("https://demoqa.com/automation-practice-form");
        return new Object[]{
                new testngFactoryExample()
        };
    }
}
