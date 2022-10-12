package io.zenwave360.example.core.outbound.mongodb.inmemory;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.mongodb.CustomerOrderRepository;

public class CustomerOrderRepositoryInMemory extends InMemoryMongoRepository<CustomerOrder> implements CustomerOrderRepository {}
