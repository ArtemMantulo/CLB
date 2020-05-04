package Pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class RepeatableCompotents {
    private SelenideElement
            itemOptionsButton = $("i.fa.fa-gear"),
            itemOptionDelete = $x("//button[text()='Delete']"),
            confirmDeleteOperationButton = $x("//span[@class = \"ladda-label\"]"),
            firstItemCheckbox = $x("//div[@class= \"rt-tr -odd\"]/div/input");
}
