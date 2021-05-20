package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Harry", "Potter", "+8944885995", "HarryPotter@wizard.com"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Harryup", "Potterup", "+8944885991", "HarryPotter@wizard.com");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    app.logout();

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
