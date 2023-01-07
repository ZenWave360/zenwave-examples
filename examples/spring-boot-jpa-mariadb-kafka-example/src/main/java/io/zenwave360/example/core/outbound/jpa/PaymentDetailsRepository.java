package io.zenwave360.example.core.outbound.jpa;

import io.zenwave360.example.core.domain.PaymentDetails;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/** Spring Data JPA repository for the PaymentDetails entity. */
@SuppressWarnings("unused")
@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {}
