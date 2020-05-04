package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class BrokerContactsPage {
    private SelenideElement
            uploadCSVButton = $("#raised-button-file"),
            uploadContactButton = $("span.jss9"),
            firstContactCheckbox = $("input#select-0");

    private ElementsCollection
            fieldsWithSomeContactsInfo = $$x("//div[@class = \"rt-tr-group\"]/div/div/div/span");




}
