package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreationTests() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Harry", "Potter", "+8944885995", "HarryPotter@wizard.com"));
    app.getContactHelper().submitContactCreation();
    app.returnToHomePage();
    app.logout();
  }

}
