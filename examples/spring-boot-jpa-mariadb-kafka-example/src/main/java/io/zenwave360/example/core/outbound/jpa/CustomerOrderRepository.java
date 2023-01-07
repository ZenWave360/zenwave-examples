package io.zenwave360.example.core.outbound.jpa;

import io.zenwave360.example.core.domain.CustomerOrder;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/** Spring Data JPA repository for the CustomerOrder entity. */
@SuppressWarnings("unused")
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {}
