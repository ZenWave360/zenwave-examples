package io.zenwave360.example.core.inbound;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [Customer, PaymentDetails, ShippingDetails]. */
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
  Optional<Customer> updateCustomer(Long id, CustomerInput customer);

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
  Optional<Customer> getCustomer(Long id);

  /**
   * Delete the "id" customer.
   *
   * @param id the id of the entity.
   */
  void deleteCustomer(Long id);

  // PaymentDetails

  /**
   * Creates a paymentDetails.
   *
   * @param paymentDetails the entity to save.
   * @return the persisted entity.
   */
  PaymentDetails createPaymentDetails(PaymentDetailsInput paymentDetails);

  /**
   * Updates a paymentDetails.
   *
   * @param paymentDetails the entity to update.
   * @return the persisted entity.
   */
  Optional<PaymentDetails> updatePaymentDetails(Long id, PaymentDetailsInput paymentDetails);

  /**
   * Get all the PaymentDetails.
   *
   * @param criteria the criteria with pagination information.
   * @return the list of entities.
   */
  Page<PaymentDetails> listPaymentDetails(Pageable pageable);

  /**
   * Get the "id" paymentDetails.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<PaymentDetails> getPaymentDetails(Long id);

  /**
   * Delete the "id" paymentDetails.
   *
   * @param id the id of the entity.
   */
  void deletePaymentDetails(Long id);

  // ShippingDetails

  /**
   * Creates a shippingDetails.
   *
   * @param shippingDetails the entity to save.
   * @return the persisted entity.
   */
  ShippingDetails createShippingDetails(ShippingDetailsInput shippingDetails);

  /**
   * Updates a shippingDetails.
   *
   * @param shippingDetails the entity to update.
   * @return the persisted entity.
   */
  Optional<ShippingDetails> updateShippingDetails(Long id, ShippingDetailsInput shippingDetails);

  /**
   * Get all the ShippingDetails.
   *
   * @param criteria the criteria with pagination information.
   * @return the list of entities.
   */
  Page<ShippingDetails> listShippingDetails(Pageable pageable);

  /**
   * Get the "id" shippingDetails.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  Optional<ShippingDetails> getShippingDetails(Long id);

  /**
   * Delete the "id" shippingDetails.
   *
   * @param id the id of the entity.
   */
  void deleteShippingDetails(Long id);
}
