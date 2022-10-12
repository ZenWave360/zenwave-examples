package io.zenwave360.example.adapters.web;

import io.zenwave360.example.adapters.web.mappers.*;
import io.zenwave360.example.adapters.web.model.*;
import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

/** REST controller for . */
@RestController
@RequestMapping("/api")
public class CustomerApiController implements CustomerApi {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private NativeWebRequest request;

  @Autowired private CustomerDTOsMapper mapper;

  @Autowired private CustomerUseCases customerUseCases;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<CustomerPaginatedDTO> searchCustomers(
      Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort, CustomerCriteriaDTO reqBody) {
    CustomerCriteria customerCriteria = mapper.asCustomerCriteria(reqBody);
    Page<Customer> customers = customerUseCases.searchCustomers(customerCriteria, pageOf(page, limit, sort));
    CustomerPaginatedDTO responseDTO = mapper.asCustomerPaginatedDTO(customers);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerPaginatedDTO> listCustomers(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    Page<Customer> customers = customerUseCases.listCustomers(pageOf(page, limit, sort));
    CustomerPaginatedDTO responseDTO = mapper.asCustomerPaginatedDTO(customers);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO reqBody) {
    CustomerInput customerInput = mapper.asCustomerInput(reqBody);
    Customer customer = customerUseCases.createCustomer(customerInput);
    CustomerDTO responseDTO = mapper.asCustomerDTO(customer);
    return ResponseEntity.status(201).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerDTO> getCustomer(String id) {
    Optional<Customer> customer = customerUseCases.getCustomer(id);
    if (customer.isPresent()) {
      CustomerDTO responseDTO = mapper.asCustomerDTO(customer.get());
      return ResponseEntity.status(200).body(responseDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<CustomerDTO> updateCustomer(String id, CustomerDTO reqBody) {
    CustomerInput customerInput = mapper.asCustomerInput(reqBody);
    Optional<Customer> customer = customerUseCases.updateCustomer(id, customerInput);
    if (customer.isPresent()) {
      CustomerDTO responseDTO = mapper.asCustomerDTO(customer.get());
      return ResponseEntity.status(200).body(responseDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<Void> deleteCustomer(String id) {
    customerUseCases.deleteCustomer(id);
    return ResponseEntity.status(204).build();
  }

  protected Pageable pageOf(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    return PageRequest.of(page.orElse(0), limit.orElse(10));
  }
}
