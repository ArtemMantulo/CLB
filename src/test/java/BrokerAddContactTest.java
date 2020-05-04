import Pages.BrokerBaseClass;
import Pages.BrokerContactsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;


public class BrokerAddContactTest extends BrokerBaseClass {
    @BeforeMethod
    public void openBrokerContactsPage() {

        brokerContactsPage = open("/contacts", BrokerContactsPage.class);
        System.out.println("Open BrokerContactsPage");
        sleep(3000);
    }

    @Test
    public void addContactWithCSVFile() {
        // Uploading CSV file
       brokerContactsPage.getUploadCSVButton().uploadFile(new File(getProperty("csvfile.path")));
       brokerContactsPage.getUploadContactButton().click();
        sleep(2000);
        // Storing contacts info of all contact and verify if added contact email is displayed
        List<String> listOfContactInfo = new ArrayList<>();
        brokerContactsPage.getFieldsWithSomeContactsInfo()
                .stream()
                .forEach(element -> listOfContactInfo.add(element.getText()));
        listOfContactInfo.forEach(e -> System.out.println(e));
        assertThat(listOfContactInfo, hasItem(getProperty("contact.email")));
    }
    @AfterMethod
    public void deleteTestContact()
    {
        // Deleting added contact and verify that contact item checkbox is not displayed
        // (in case there is no contact in the list the first item checkbox should be disabled)
        brokerContactsPage.getFirstContactCheckbox().setSelected(true);
        repeatableCompotents.getItemOptionsButton().click();
        repeatableCompotents.getItemOptionDelete().click();
        repeatableCompotents.getConfirmDeleteOperationButton().click();
        refresh();
        repeatableCompotents.getFirstItemCheckbox().shouldNot(exist);
        sleep(3000);

    }

}
