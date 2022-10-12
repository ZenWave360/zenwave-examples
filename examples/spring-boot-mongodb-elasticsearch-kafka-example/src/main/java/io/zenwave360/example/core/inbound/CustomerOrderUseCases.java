package io.zenwave360.example.core.inbound;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** Inbound Service Port for managing [CustomerOrder]. */
public interface CustomerOrderUseCases {

    // CustomerOrder

    /**
     * Creates a customerOrder.
     *
     * @param customerOrder the entity to save.
     * @return the persisted entity.
     */
    CustomerOrder createCustomerOrder(CustomerOrderInput customerOrder);

    /**
     * Updates a customerOrder.
     *
     * @param customerOrder the entity to update.
     * @return the persisted entity.
     */
    Optional<CustomerOrder> updateCustomerOrder(String id, CustomerOrderInput customerOrder);

    /**
     * Get all the CustomerOrders.
     *
     * @param criteria the criteria with pagination information.
     * @return the list of entities.
     */
    Page<CustomerOrder> listCustomerOrders(Pageable pageable);
    /**
     * Get all the CustomerOrders matching the search criteria.
     *
     * @param criteria the criteria with pagination information.
     * @return the list of entities.
     */
    Page<CustomerOrder> searchCustomerOrders(CustomerOrderSearchCriteria criteria, Pageable pageable);

    /**
     * Get the "id" customerOrder.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerOrder> getCustomerOrder(String id);

    /**
     * Delete the "id" customerOrder.
     *
     * @param id the id of the entity.
     */
    void deleteCustomerOrder(String id);
}
