package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String home;
  private final String mail;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }

  public ContactData(String firstname, String lastname, String home, String mail) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.home = home;
    this.mail = mail;
  }


  public ContactData(int id, String firstname, String lastname, String home, String mail) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.home = home;
    this.mail = mail;
  }

  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

}
