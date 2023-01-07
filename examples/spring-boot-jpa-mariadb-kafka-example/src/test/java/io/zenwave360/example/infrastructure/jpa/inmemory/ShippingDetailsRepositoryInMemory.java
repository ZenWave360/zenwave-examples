package io.zenwave360.example.infrastructure.jpa.inmemory;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.ShippingDetailsRepository;

public class ShippingDetailsRepositoryInMemory extends InMemoryJpaRepository<ShippingDetails> implements ShippingDetailsRepository {}
