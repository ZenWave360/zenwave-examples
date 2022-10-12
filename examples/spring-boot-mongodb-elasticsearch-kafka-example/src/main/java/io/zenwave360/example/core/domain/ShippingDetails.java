package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
public class ShippingDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field private String address;

    public ShippingDetails withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
