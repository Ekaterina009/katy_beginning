package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Harry", "Potter", "+8944885995", "HarryPotter@wizard.com"));
    }
    app.getContactHelper().editContact();
    app.getContactHelper().deleteSelectedContact();
    app.logout();
  }

}
