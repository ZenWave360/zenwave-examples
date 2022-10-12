package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
public class PaymentDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Field private String creditCardNumber;

    public PaymentDetails withCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
