package io.zenwave360.example.infrastructure.mongodb.inmemory;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.mongodb.CustomerRepository;

public class CustomerRepositoryInMemory extends InMemoryMongodbRepository<Customer> implements CustomerRepository {}
