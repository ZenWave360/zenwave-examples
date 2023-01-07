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
public class CustomerOrderApiController implements CustomerOrderApi {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private NativeWebRequest request;

  @Autowired private CustomerOrderDTOsMapper mapper;

  @Autowired private CustomerOrderUseCases customerOrderUseCases;

  @Autowired private CustomerUseCases customerUseCases;

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<CustomerOrderPaginatedDTO> searchCustomerOrders(
      Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort, CustomerOrderSearchCriteriaDTO reqBody) {
    CustomerOrderSearchCriteria customerOrderSearchCriteria = mapper.asCustomerOrderSearchCriteria(reqBody);
    Page<CustomerOrder> customerOrders = customerOrderUseCases.searchCustomerOrders(customerOrderSearchCriteria, pageOf(page, limit, sort));
    CustomerOrderPaginatedDTO responseDTO = mapper.asCustomerOrderPaginatedDTO(customerOrders);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerOrderPaginatedDTO> listCustomerOrders(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    Page<CustomerOrder> customerOrders = customerOrderUseCases.listCustomerOrders(pageOf(page, limit, sort));
    CustomerOrderPaginatedDTO responseDTO = mapper.asCustomerOrderPaginatedDTO(customerOrders);
    return ResponseEntity.status(200).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerOrderDTO> createCustomerOrder(CustomerOrderDTO reqBody) {
    CustomerOrderInput customerOrderInput = mapper.asCustomerOrderInput(reqBody);
    CustomerOrder customerOrder = customerOrderUseCases.createCustomerOrder(customerOrderInput);
    CustomerOrderDTO responseDTO = mapper.asCustomerOrderDTO(customerOrder);
    return ResponseEntity.status(201).body(responseDTO);
  }

  @Override
  public ResponseEntity<CustomerOrderDTO> getCustomerOrder(Long id) {
    Optional<CustomerOrder> customerOrder = customerOrderUseCases.getCustomerOrder(id);
    if (customerOrder.isPresent()) {
      CustomerOrderDTO responseDTO = mapper.asCustomerOrderDTO(customerOrder.get());
      return ResponseEntity.status(200).body(responseDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<CustomerOrderDTO> updateCustomerOrder(Long id, CustomerOrderDTO reqBody) {
    CustomerOrderInput customerOrderInput = mapper.asCustomerOrderInput(reqBody);
    Optional<CustomerOrder> customerOrder = customerOrderUseCases.updateCustomerOrder(id, customerOrderInput);
    if (customerOrder.isPresent()) {
      CustomerOrderDTO responseDTO = mapper.asCustomerOrderDTO(customerOrder.get());
      return ResponseEntity.status(200).body(responseDTO);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public ResponseEntity<Void> deleteCustomerOrder(Long id) {
    customerOrderUseCases.deleteCustomerOrder(id);
    return ResponseEntity.status(204).build();
  }

  protected Pageable pageOf(Optional<Integer> page, Optional<Integer> limit, Optional<List<String>> sort) {
    return PageRequest.of(page.orElse(0), limit.orElse(10));
  }
}
