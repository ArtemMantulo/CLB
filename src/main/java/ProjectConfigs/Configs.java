package ProjectConfigs;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.RepeatableCompotents;
import Utils.DriverManager;
import com.codeborne.selenide.Selenide;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static Utils.DriverManager.setUpDriver;
import static com.codeborne.selenide.Selenide.open;


public class Configs extends DriverManager {
    public LoginPage loginPage;
    public MainPage mainPage;
    public RepeatableCompotents repeatableCompotents;

    @BeforeClass
    public void  beforeClassRunner() {
        System.out.println("BeforeClass Open LoginPage");
        setUpDriver();
        loginPage = open("", LoginPage.class);
        mainPage = new MainPage();
        repeatableCompotents = new RepeatableCompotents();


    }
    @AfterClass
    public void afterLoginWithValidCredentialsAsBrokerConnect() {
        System.out.println("AfterClass Close Driver");
        Selenide.closeWebDriver();
    }
}
