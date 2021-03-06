package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTests extends TestBase {

  @BeforeMethod public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Bill").withLastname("Duff")
              .withHome("+8944885995").withMobilePhone("+8 4488 5991").withWorkPhone("+8-4188-5945")
              .withMail("BillDuff@plain.com").withMail2("BillDuff@plain.ru").withMail3("BillDuff@plain.de").withAddress("Lenina 12"));
    }
  }

  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  @Test
  public void testAddress() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
  }

  @Test
  public void testMails() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfoFromEditForm)));
  }

  private String  mergeMails(ContactData contact) {
    return Arrays.asList(contact.getMail(),contact.getMail2(), contact.getMail3())
            .stream().filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }

}
