package io.zenwave360.example.infrastructure.jpa.inmemory;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.PaymentDetailsRepository;

public class PaymentDetailsRepositoryInMemory extends InMemoryJpaRepository<PaymentDetails> implements PaymentDetailsRepository {}
