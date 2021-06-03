package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType());
      return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "validContactsFromJson")
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
