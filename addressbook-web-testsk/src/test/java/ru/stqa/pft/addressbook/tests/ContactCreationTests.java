package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstname("Harry").withLastname("Potter").withHome("+8944885995")
            .withMail("HarryPotter@wizard.com")});
    list.add(new Object[] {new ContactData().withFirstname("Bill").withLastname("Kill").withHome("+8944885996")
            .withMail("BillKill@unit.com")});
    list.add(new Object[] {new ContactData().withFirstname("Marry").withLastname("Key").withHome("+8944885997")
            .withMail("MarryKey@corporation.com")});
    return list.iterator();
  }


  @Test(dataProvider = "validContacts")
  public void testContactCreationTests(ContactData contact) throws Exception {
      Contacts before = app.contact().all();
      File photo = new File("src/test/resources/2021-05-31.png");
      app.contact().create(contact);
      assertThat(app.contact().count(), equalTo(before.size() + 1));
      Contacts after = app.contact().all();
      // app.logout();
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));
    }
}
