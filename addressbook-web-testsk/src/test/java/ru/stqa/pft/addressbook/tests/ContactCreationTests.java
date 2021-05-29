package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreationTests() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Larry").withLastname("Potter").withHome("+8944885995").withMail("HarryPotter@wizard.com");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
   // app.logout();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));
  }

}
