package Pages;

import ProjectConfigs.Configs;
import org.testng.annotations.*;

import static Utils.ConfigProvider.getProperty;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class BrokerBaseClass extends Configs {
    public LoginPage loginPage = new LoginPage();
    public BrokerContactsPage brokerContactsPage;


    @BeforeMethod
    public void logInAsBroker() {
        System.out.println("BeforeMethod LoginAsBroker");
        this.loginPage.getUserEmail().setValue(getProperty("broker.email"));
        this.loginPage.getUserPassword().setValue(getProperty("broker.password"));
        this.loginPage.getSelectAccountOption().selectOption(getProperty("broker.type"));
        this.loginPage.getSubmitButton().click();
        sleep(3000);
    }
}
