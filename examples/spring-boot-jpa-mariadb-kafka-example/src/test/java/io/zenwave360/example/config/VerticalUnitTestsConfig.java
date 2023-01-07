package io.zenwave360.example.config;

import io.zenwave360.example.core.implementation.mappers.CustomerMapper;
import io.zenwave360.example.core.implementation.mappers.CustomerOrderMapper;
import io.zenwave360.example.core.implementation.mappers.PaymentDetailsMapper;
import io.zenwave360.example.core.implementation.mappers.ShippingDetailsMapper;
import io.zenwave360.example.core.outbound.jpa.CustomerOrderRepository;
import io.zenwave360.example.core.outbound.jpa.CustomerRepository;
import io.zenwave360.example.core.outbound.jpa.PaymentDetailsRepository;
import io.zenwave360.example.core.outbound.jpa.ShippingDetailsRepository;
import io.zenwave360.example.core.outbound.search.CustomerSearchRepository;
import io.zenwave360.example.infrastructure.jpa.inmemory.CustomerOrderRepositoryInMemory;
import io.zenwave360.example.infrastructure.jpa.inmemory.CustomerRepositoryInMemory;
import io.zenwave360.example.infrastructure.jpa.inmemory.PaymentDetailsRepositoryInMemory;
import io.zenwave360.example.infrastructure.jpa.inmemory.ShippingDetailsRepositoryInMemory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
public class VerticalUnitTestsConfig {


    private final CustomerRepository customerRepository = new CustomerRepositoryInMemory();
    private final CustomerOrderRepository customerOrderRepository = new CustomerOrderRepositoryInMemory();
    private final PaymentDetailsRepository paymentDetailsRepository = new PaymentDetailsRepositoryInMemory();
    private final ShippingDetailsRepository shippingDetailsRepository = new ShippingDetailsRepositoryInMemory();


    @Bean
    @Primary
    public <T extends CustomerRepository> T customerRepository() {
        return (T) customerRepository;
    }

    @Bean
    @Primary
    public CustomerOrderRepository customerOrderRepository() {
        return customerOrderRepository;
    }

    @Bean
    @Primary
    public <T extends PaymentDetailsRepository> T paymentDetailsRepository() {
        return (T) paymentDetailsRepository;
    }

    @Bean
    @Primary
    public <T extends ShippingDetailsRepository> T shippingDetailsRepository() {
        return (T) shippingDetailsRepository;
    }

    @Bean
    @Primary
    public CustomerSearchRepository customerSearchRepository() {
        return null;
    }

}
