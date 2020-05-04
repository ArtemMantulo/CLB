package Pages;

import ProjectConfigs.Configs;
import org.testng.annotations.*;

import static Utils.ConfigProvider.getProperty;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class CarrierBaseClass extends Configs {
    public LoginPage loginPage;
    public CarrierMyCapacityPage carrierCapacityPage;

   @BeforeMethod
    public void logInAsCarrier() {
        System.out.println("BeforeMethod LoginAsCarrier");
       loginPage = new LoginPage();
        this.loginPage.getUserEmail().setValue(getProperty("carrier.email"));
        this.loginPage.getUserPassword().setValue(getProperty("carrier.password"));
        this.loginPage.getSelectAccountOption().selectOption(getProperty("carrier.type"));
        this.loginPage.getSubmitButton().click();
        sleep(3000);
    }

}
