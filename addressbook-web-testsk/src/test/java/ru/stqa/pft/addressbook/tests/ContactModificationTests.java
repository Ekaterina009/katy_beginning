package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test

  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Harry", "Potter", "+8944885995", "HarryPotter@wizard.com"));
    }
    app.getContactHelper().editContact();
    app.getContactHelper().fillContactForm(new ContactData("Harryup", "Potterup", "+8944885991", "HarryPotter@wizard.com"));
    app.getContactHelper().submitContactModification();

  }
}
