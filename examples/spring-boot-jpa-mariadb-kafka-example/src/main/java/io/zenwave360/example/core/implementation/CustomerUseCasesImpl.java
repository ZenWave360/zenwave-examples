package io.zenwave360.example.core.implementation;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.domain.events.CustomerEventPayload;
import io.zenwave360.example.core.implementation.mappers.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import io.zenwave360.example.core.outbound.events.CustomerEventsProducer;
import io.zenwave360.example.core.outbound.events.ICustomerEventsProducer;
import io.zenwave360.example.core.outbound.jpa.*;
import io.zenwave360.example.core.outbound.search.*;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [Customer, PaymentDetails, ShippingDetails]. */
@Service
@Transactional
public class CustomerUseCasesImpl implements CustomerUseCases {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
  private final CustomerRepository customerRepository;
  private final CustomerSearchRepository customerSearchRepository;

  private final PaymentDetailsMapper paymentDetailsMapper = Mappers.getMapper(PaymentDetailsMapper.class);
  private final PaymentDetailsRepository paymentDetailsRepository;

  private final ShippingDetailsMapper shippingDetailsMapper = Mappers.getMapper(ShippingDetailsMapper.class);
  private final ShippingDetailsRepository shippingDetailsRepository;

  private final EventsMapper eventsMapper = Mappers.getMapper(EventsMapper.class);
  private final ICustomerEventsProducer customerEventsProducer;

  /** Constructor. */
  public CustomerUseCasesImpl(
      CustomerRepository customerRepository,
      CustomerSearchRepository customerSearchRepository,
      PaymentDetailsRepository paymentDetailsRepository,
      ShippingDetailsRepository shippingDetailsRepository,
      ICustomerEventsProducer customerEventsProducer) {
    this.customerRepository = customerRepository;
    this.customerSearchRepository = customerSearchRepository;
    this.paymentDetailsRepository = paymentDetailsRepository;
    this.shippingDetailsRepository = shippingDetailsRepository;
    this.customerEventsProducer = customerEventsProducer;
  }

  // Customer

  @Override
  public Customer createCustomer(CustomerInput customerInput) {
    log.debug("Request to save Customer: {}", customerInput);
    var customer = customerMapper.update(new Customer(), customerInput);
    customer = customerRepository.save(customer); // TODO: you may need to reload the entity here to fetch all the relationships
    CustomerEventPayload payload = new CustomerEventPayload()
            .withId(customer.getId())
            .withEventType(CustomerEventPayload.EventType.CREATED)
            .withCustomer(eventsMapper.asCustomer(customer));
    customerEventsProducer.onCustomerEvent(payload);
    return customer;
  }

  @Override
  public Optional<Customer> updateCustomer(Long id, CustomerInput customerInput) {
    log.debug("Request to update Customer: {}", customerInput);
    var customer = customerRepository.findById(id);
    customer = customer.map(existingcustomer -> customerMapper.update(existingcustomer, customerInput));
    if(customer.isPresent()) {
      CustomerEventPayload payload = new CustomerEventPayload()
              .withId(customer.get().getId())
              .withEventType(CustomerEventPayload.EventType.UPDATED)
              .withCustomer(eventsMapper.asCustomer(customer.get()));
      customerEventsProducer.onCustomerEvent(payload);
    }
    return customer.map(customerRepository::save);
  }

  @Override
  public Page<Customer> listCustomers(Pageable pageable) {
    log.debug("Request list of Customers: {}", pageable);
    return customerRepository.findAll(pageable);
  }

  @Override
  public Page<Customer> searchCustomers(CustomerCriteria criteria, Pageable pageable) {
    log.debug("Request to search Customers: {} - {}", criteria, pageable);
    // TODO implement this search by criteria
    return customerRepository.findAll(pageable);
  }

  @Override
  public Optional<Customer> getCustomer(Long id) {
    log.debug("Request to get Customer : {}", id);
    return customerRepository.findById(id);
  }

  @Override
  public void deleteCustomer(Long id) {
    log.debug("Request to delete Customer : {}", id);
    customerRepository.deleteById(id);
    CustomerEventPayload payload = new CustomerEventPayload()
            .withId(id)
            .withEventType(CustomerEventPayload.EventType.DELETED);
    customerEventsProducer.onCustomerEvent(payload);
  }

  // PaymentDetails

  @Override
  public PaymentDetails createPaymentDetails(PaymentDetailsInput paymentDetailsInput) {
    log.debug("Request to save PaymentDetails: {}", paymentDetailsInput);
    var paymentDetails = paymentDetailsMapper.update(new PaymentDetails(), paymentDetailsInput);
    paymentDetails = paymentDetailsRepository.save(paymentDetails);
    // TODO: you may need to reload the entity here to fetch all the relationships
    return paymentDetails;
  }

  @Override
  public Optional<PaymentDetails> updatePaymentDetails(Long id, PaymentDetailsInput paymentDetailsInput) {
    log.debug("Request to update PaymentDetails: {}", paymentDetailsInput);
    var paymentDetails = paymentDetailsRepository.findById(id);
    paymentDetails = paymentDetails.map(existingpaymentDetails -> paymentDetailsMapper.update(existingpaymentDetails, paymentDetailsInput));
    return paymentDetails.map(paymentDetailsRepository::save);
  }

  @Override
  public Page<PaymentDetails> listPaymentDetails(Pageable pageable) {
    log.debug("Request list of PaymentDetails: {}", pageable);
    return paymentDetailsRepository.findAll(pageable);
  }

  @Override
  public Optional<PaymentDetails> getPaymentDetails(Long id) {
    log.debug("Request to get PaymentDetails : {}", id);
    return paymentDetailsRepository.findById(id);
  }

  @Override
  public void deletePaymentDetails(Long id) {
    log.debug("Request to delete PaymentDetails : {}", id);
    paymentDetailsRepository.deleteById(id);
  }

  // ShippingDetails

  @Override
  public ShippingDetails createShippingDetails(ShippingDetailsInput shippingDetailsInput) {
    log.debug("Request to save ShippingDetails: {}", shippingDetailsInput);
    var shippingDetails = shippingDetailsMapper.update(new ShippingDetails(), shippingDetailsInput);
    shippingDetails = shippingDetailsRepository.save(shippingDetails);
    // TODO: you may need to reload the entity here to fetch all the relationships
    return shippingDetails;
  }

  @Override
  public Optional<ShippingDetails> updateShippingDetails(Long id, ShippingDetailsInput shippingDetailsInput) {
    log.debug("Request to update ShippingDetails: {}", shippingDetailsInput);
    var shippingDetails = shippingDetailsRepository.findById(id);
    shippingDetails = shippingDetails.map(existingshippingDetails -> shippingDetailsMapper.update(existingshippingDetails, shippingDetailsInput));
    return shippingDetails.map(shippingDetailsRepository::save);
  }

  @Override
  public Page<ShippingDetails> listShippingDetails(Pageable pageable) {
    log.debug("Request list of ShippingDetails: {}", pageable);
    return shippingDetailsRepository.findAll(pageable);
  }

  @Override
  public Optional<ShippingDetails> getShippingDetails(Long id) {
    log.debug("Request to get ShippingDetails : {}", id);
    return shippingDetailsRepository.findById(id);
  }

  @Override
  public void deleteShippingDetails(Long id) {
    log.debug("Request to delete ShippingDetails : {}", id);
    shippingDetailsRepository.deleteById(id);
  }
}
