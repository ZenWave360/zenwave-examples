package io.zenwave360.example.infrastructure.jpa.inmemory;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.CustomerOrderRepository;

public class CustomerOrderRepositoryInMemory extends InMemoryJpaRepository<CustomerOrder> implements CustomerOrderRepository {}
