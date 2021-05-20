package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String home;
  private final String mail;


  public ContactData(String firstname, String lastname, String home, String mail) {
    this.id = 0;
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


  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
  }

}
