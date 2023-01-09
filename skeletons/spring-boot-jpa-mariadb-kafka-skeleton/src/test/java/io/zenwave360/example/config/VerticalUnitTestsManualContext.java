package io.zenwave360.example.config;

import io.zenwave360.example.core.implementation.CustomerOrderUseCasesImpl;
import io.zenwave360.example.core.implementation.CustomerUseCasesImpl;
import io.zenwave360.example.core.inbound.CustomerOrderUseCases;
import io.zenwave360.example.core.inbound.CustomerUseCases;

public class VerticalUnitTestsManualContext extends VerticalUnitTestsConfig {

    public CustomerUseCases customerUseCases() {
        return new CustomerUseCasesImpl(
                customerRepository(),
                customerSearchRepository(),
                paymentDetailsRepository(),
                shippingDetailsRepository()
        );
    }

    public CustomerOrderUseCases customerOrderUseCases() {
        return new CustomerOrderUseCasesImpl(
                customerOrderRepository()
        );
    }
}
