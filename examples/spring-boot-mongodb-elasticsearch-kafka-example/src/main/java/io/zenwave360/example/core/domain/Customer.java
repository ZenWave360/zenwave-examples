package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
@Document(collection = "Customer")
public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id private String id;

  @Field
  @NotNull
  @Size(min = 3, max = 250)
  private String firstName;

  @Field
  @NotNull
  @Size(min = 3, max = 250)
  private String lastName;

  @Field
  @NotNull
  @Size(min = 3, max = 250)
  private String password;

  @Field
  @NotNull
  @Size(min = 3, max = 250)
  private String email;

  @Field
  @NotNull
  @Size(min = 3, max = 250)
  private String username;

  public String getId() {
    return id;
  }

  public Customer withId(String id) {
    this.id = id;
    return this;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Customer withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Customer withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Customer withPassword(String password) {
    this.password = password;
    return this;
  }

  public Customer withEmail(String email) {
    this.email = email;
    return this;
  }

  public Customer withUsername(String username) {
    this.username = username;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
