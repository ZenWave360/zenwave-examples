package io.zenwave360.example.config;

import io.zenwave360.example.core.implementation.*;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

  public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();

  public CustomerUseCasesImpl customerUseCases() {
    return new CustomerUseCasesImpl(customerRepository(), customerSearchRepository());
  }

  public CustomerOrderUseCasesImpl customerOrderUseCases() {
    return new CustomerOrderUseCasesImpl(customerOrderRepository());
  }
}
