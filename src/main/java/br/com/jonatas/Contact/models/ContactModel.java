package br.com.jonatas.Contact.models;

import java.util.UUID;

public class ContactModel {

  private UUID id;
  private String email;
  private String name;
  private String phone;

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
}
