import Pages.BrokerBaseClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginBrokerTest extends BrokerBaseClass {
    @Test
    public void loginWithValidCredentialsAsBrokerConnect() {
        mainPage.getWelcomeTitle().shouldHave(text("Welcome"));
        mainPage.getCompanyNameTitle().shouldHave(exactText("The Canadian Load Board"));
        mainPage.getAccountIcon().click();
        mainPage.getLogOutButton().click();
        sleep(3000);
    }

}