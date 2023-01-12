package io.zenwave360.example.config;

import io.zenwave360.example.core.outbound.jpa.CustomerOrderRepository;
import io.zenwave360.example.core.outbound.jpa.CustomerRepository;
import io.zenwave360.example.core.outbound.jpa.PaymentDetailsRepository;
import io.zenwave360.example.core.outbound.jpa.ShippingDetailsRepository;
import io.zenwave360.example.core.outbound.search.CustomerSearchRepository;
import io.zenwave360.example.infrastructure.jpa.inmemory.CustomerOrderRepositoryInMemory;
import io.zenwave360.example.infrastructure.jpa.inmemory.CustomerRepositoryInMemory;
import io.zenwave360.example.infrastructure.jpa.inmemory.PaymentDetailsRepositoryInMemory;
import io.zenwave360.example.infrastructure.jpa.inmemory.ShippingDetailsRepositoryInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

// @Configuration
public class InMemoryTestsConfig {
  private final CustomerRepository customerRepository = new CustomerRepositoryInMemory();

  @Bean
  @Primary
  public <T extends CustomerRepository> T customerRepository() {
    return (T) customerRepository;
  }

  @Bean
  @Primary
  public CustomerSearchRepository customerSearchRepository() {
    return null; // TODO
  }

  private final PaymentDetailsRepository paymentDetailsRepository = new PaymentDetailsRepositoryInMemory();

  @Bean
  @Primary
  public <T extends PaymentDetailsRepository> T paymentDetailsRepository() {
    return (T) paymentDetailsRepository;
  }

  private final ShippingDetailsRepository shippingDetailsRepository = new ShippingDetailsRepositoryInMemory();

  @Bean
  @Primary
  public <T extends ShippingDetailsRepository> T shippingDetailsRepository() {
    return (T) shippingDetailsRepository;
  }

  private final CustomerOrderRepository customerOrderRepository = new CustomerOrderRepositoryInMemory();

  @Bean
  @Primary
  public <T extends CustomerOrderRepository> T customerOrderRepository() {
    return (T) customerOrderRepository;
  }

}
