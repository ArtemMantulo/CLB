import Pages.LoginPage;
import ProjectConfigs.Configs;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class InitialTest extends Configs {
    public LoginPage loginPage;
    @Test
    public void InitialTestOfLoginPage() {
        loginPage = new LoginPage();
       loginPage.getLabelText().shouldBe(exactText("The Canadian Load Board"));
       loginPage.getUserEmail().shouldBe(visible).shouldBe(empty);
       loginPage.getUserPassword().shouldBe().shouldBe(empty);
       loginPage.getSelectAccountOption().is(enabled);
       loginPage.getSubmitButton().is(enabled);
       loginPage.getForgetPasswordLink().shouldBe(visible);
       loginPage.getSignUpLink().shouldBe(visible);
   }

}
