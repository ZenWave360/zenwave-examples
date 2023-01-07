package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class PaymentDetailsInput implements Serializable {

  private Long id;

  private Integer version;

  private String cardHolderName;

  private String creditCardNumber;

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=customer, commentInTo=null, injectedFieldInTo=paymentDetails,
  // options={destination={}, global={}, source={}}, from=PaymentDetails, to=Customer,
  // type=ManyToOne, isInjectedFieldInToRequired=false}, otherEntityName=Customer, ownerSide=true,
  // isCollection=false, fieldName=customer, otherEntityFieldName=paymentDetails}

  private Long customerId;

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=paymentDetails(creditCardNumber), commentInTo=null, injectedFieldInTo=null,
  // options={destination={}, global={}, source={}}, from=CustomerOrder, to=PaymentDetails,
  // type=ManyToOne, isInjectedFieldInToRequired=null}, otherEntityName=CustomerOrder,
  // ownerSide=false, isCollection=true, otherEntityFieldName=paymentDetails}

  public Long getId() {
    return id;
  }

  public PaymentDetailsInput withId(Long id) {
    this.id = id;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public PaymentDetailsInput withCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
    return this;
  }

  public PaymentDetailsInput withCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
    return this;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
