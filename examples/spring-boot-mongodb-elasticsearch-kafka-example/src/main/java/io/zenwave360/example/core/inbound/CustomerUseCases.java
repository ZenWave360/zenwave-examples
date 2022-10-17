package io.zenwave360.example.core.inbound;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Customer]. */
public interface CustomerUseCases {

  // Customer

  /**
   * Creates a customer.
   *
   * @param customer the entity to save.
   * @return the persisted entity.
   */
  Customer createCustomer(CustomerInput customer);

  /**
   * Updates a customer.
   *
   * @param customer the entity to update.
   * @return the persisted entity.
   */
  Optional<Customer> updateCustomer(String id, CustomerInput customer);

  /**
   * Get all the Customers.
   *
   * @param criteria the criteria with pagination information.
   * @return the list of entities.
   */
  Page<Customer> listCustomers(Pageable pageable);
  /**
   * Get all the Customers matching the search criteria.
   *
   * @param criteria the criteria with pagination information.
   * @return the list of entities.
   */
  Page<Customer> searchCustomers(CustomerCriteria criteria, Pageable pageable);

  /**
   * Get the "id" customer.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<Customer> getCustomer(String id);

  /**
   * Delete the "id" customer.
   *
   * @param id the id of the entity.
   */
  void deleteCustomer(String id);
}
