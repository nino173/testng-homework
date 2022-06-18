import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class testngFactoryExample {

    @DataProvider
    public Object[][] message()
    {
        return new Object [][]{{"Lucifer","MorningStar", 1, 1234567890},
                {"Tamari", " Bagrationi", -1, 1076543220},
                {"Donald", "Duck", 0, 1111111111}};
    }
    @Test(dataProvider="message")
    public void fillData(String name, String surname, Integer gender, Integer number)
    {
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
}
