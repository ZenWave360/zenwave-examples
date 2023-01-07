package io.zenwave360.example.core.outbound.jpa;

import io.zenwave360.example.core.domain.ShippingDetails;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/** Spring Data JPA repository for the ShippingDetails entity. */
@SuppressWarnings("unused")
@Repository
public interface ShippingDetailsRepository extends JpaRepository<ShippingDetails, Long> {}
