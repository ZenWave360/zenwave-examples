package io.zenwave360.example.infrastructure.mongodb.inmemory;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.mongodb.CustomerOrderRepository;

public class CustomerOrderRepositoryInMemory extends InMemoryMongodbRepository<CustomerOrder> implements CustomerOrderRepository {}
