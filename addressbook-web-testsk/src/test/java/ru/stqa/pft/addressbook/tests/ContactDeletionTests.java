package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Harry", "Potter", "+8944885995", "HarryPotter@wizard.com"));
    }
    app.getContactHelper().editContact();
    app.getContactHelper().deleteSelectedContact();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
    app.logout();
  }

}
