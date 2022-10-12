package io.zenwave360.example.core.implementation;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.implementation.mappers.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import io.zenwave360.example.core.outbound.mongodb.*;
import io.zenwave360.example.core.outbound.search.*;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/** Service Implementation for managing [CustomerOrder]. */
@Service
public class CustomerOrderUseCasesImpl implements CustomerOrderUseCases {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final CustomerOrderMapper customerOrderMapper;
  private final CustomerOrderRepository customerOrderRepository;

  /** Constructor. */
  public CustomerOrderUseCasesImpl(CustomerOrderMapper customerOrderMapper, CustomerOrderRepository customerOrderRepository) {
    this.customerOrderMapper = customerOrderMapper;
    this.customerOrderRepository = customerOrderRepository;
  }

  // CustomerOrder

  @Override
  public CustomerOrder createCustomerOrder(CustomerOrderInput customerOrderInput) {
    log.debug("Request to save CustomerOrderInput : {}", customerOrderInput);
    var customerOrder = customerOrderMapper.update(new CustomerOrder(), customerOrderInput);
    return customerOrderRepository.save(customerOrder);
  }

  @Override
  public Optional<CustomerOrder> updateCustomerOrder(String id, CustomerOrderInput customerOrderInput) {
    log.debug("Request to update CustomerOrder : {}", customerOrderInput);

    return customerOrderRepository
        .findById(id)
        .map(
            existingCustomerOrder -> {
              return customerOrderMapper.update(existingCustomerOrder, customerOrderInput);
            })
        .map(customerOrderRepository::save);
  }

  @Override
  public Page<CustomerOrder> listCustomerOrders(Pageable pageable) {
    log.debug("Request list of CustomerOrders: {}", pageable);
    return customerOrderRepository.findAll(pageable);
  }

  @Override
  public Page<CustomerOrder> searchCustomerOrders(CustomerOrderSearchCriteria criteria, Pageable pageable) {
    log.debug("Request to search CustomerOrders: {} - {}", criteria, pageable);
    // TODO implement this search by criteria
    return customerOrderRepository.findAll(criteria);
  }

  @Override
  public Optional<CustomerOrder> getCustomerOrder(String id) {
    log.debug("Request to get CustomerOrder : {}", id);
    return customerOrderRepository.findById(id);
  }

  @Override
  public void deleteCustomerOrder(String id) {
    log.debug("Request to delete CustomerOrder : {}", id);
    customerOrderRepository.deleteById(id);
  }
}
