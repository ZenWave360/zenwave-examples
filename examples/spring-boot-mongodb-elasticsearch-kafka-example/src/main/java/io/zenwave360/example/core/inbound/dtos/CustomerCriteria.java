package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/** */
public class CustomerCriteria extends PageRequest implements Serializable, Pageable {

    public CustomerCriteria() {
        this(0, 10, Sort.unsorted());
    }

    public CustomerCriteria(int page, int size, Sort sort) {
        super(page, size, sort);
    }

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String username;

    public CustomerCriteria withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerCriteria withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerCriteria withPassword(String password) {
        this.password = password;
        return this;
    }

    public CustomerCriteria withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerCriteria withUsername(String username) {
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
