package io.zenwave360.example.core.implementation.mappers;

import io.zenwave360.example.core.domain.events.Customer;
import io.zenwave360.example.core.domain.events.CustomerOrder;
import io.zenwave360.example.core.domain.events.PaymentDetails;
import io.zenwave360.example.core.domain.events.ShippingDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventsMapper {

    public static final EventsMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EventsMapper.class);

    Customer asCustomer(io.zenwave360.example.core.domain.Customer customer);
    ShippingDetails asShippingDetails(io.zenwave360.example.core.domain.ShippingDetails shippingDetails);
    PaymentDetails asPaymentDetails(io.zenwave360.example.core.domain.PaymentDetails paymentDetails);
}
