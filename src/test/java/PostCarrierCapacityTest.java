import Pages.CarrierBaseClass;
import Pages.CarrierMyCapacityPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PostCarrierCapacityTest extends CarrierBaseClass {
@BeforeMethod
public void openCarrierCapacityPage() {
    carrierCapacityPage = open("/my-capacity", CarrierMyCapacityPage.class);
    System.out.println("Open MyCapacityPage");
    sleep(3000);
}

    @Test
    public void postCarrierCapacity() {
        carrierCapacityPage.getCreateCapacityButton().click();
        carrierCapacityPage.getOpenDateField().setValue(getProperty("open.date"));
        carrierCapacityPage.getCloseDateField().setValue(getProperty("close.date"));
        carrierCapacityPage.getEquipment().selectOptionByValue(getProperty("equipment.type"));
        carrierCapacityPage.getLoadType().selectOptionByValue(getProperty("load.type"));
        carrierCapacityPage.getOriginCity().setValue(getProperty("origin.city"));
        carrierCapacityPage.getOriginProvince().selectOptionByValue(getProperty("origin.province"));
        carrierCapacityPage.getDestinationCity().setValue(getProperty("destination.city"));
        carrierCapacityPage.getDestinationProvince().selectOptionByValue(getProperty("destination.province"));
        carrierCapacityPage.getSubmitButton().click();

        sleep(2000);
    }
    @AfterMethod
    public void deteleTestCaparity()
    {
        carrierCapacityPage.getCapacityListCheckboxItemOne().setSelected(true);
        carrierCapacityPage.getItemOptionsButton().click();
        carrierCapacityPage.getItemOptionDelete().shouldBe(visible).click();
        carrierCapacityPage.getConfirmDeleteOperationButton().click();
        sleep(3000);
        //List<String> openDateText = new ArrayList<>();

        //carrierCapacityPage.getCapacityListCheckboxItemOne().shouldBe(disabled);
        //for(SelenideElement element : carrierCapacityPage.getCapacityListOpenDateField())
        //{
          //  openDateText.add(element.getText());
        //}
        //assertThat(openDateText, hasSize(12));
        //sleep(10000);
    }
}
