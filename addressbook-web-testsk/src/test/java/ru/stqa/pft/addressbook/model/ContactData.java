package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String home;
  private final String mail;

  public ContactData(String firstname, String lastname, String home, String mail) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.home = home;
    this.mail = mail;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHome() {
    return home;
  }

  public String getMail() {
    return mail;
  }
}