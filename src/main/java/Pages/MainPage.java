package Pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter

    public class MainPage {
    private SelenideElement
            welcomeTitle = $(".h3.mb-3.font-weight-normal"),
            companyNameTitle = $(".font-weight-normal>strong"),
            accountIcon = $(".jss1>img"),
            logOutButton = $x("//a[text() = \"Logout\"]");

}
