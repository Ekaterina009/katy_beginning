package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreationTests() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("Harry", "Potter", "+8944885995", "HarryPotter@wizard.com"));
    submitContactCreation();
    returnToHomePage();
    logout();
  }

}
