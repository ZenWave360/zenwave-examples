package io.zenwave360.example.core.implementation.mappers;

import io.zenwave360.example.core.domain.events.Customer;
import io.zenwave360.example.core.domain.events.CustomerOrder;
import io.zenwave360.example.core.domain.events.OrderShippingDetails;
import io.zenwave360.example.core.domain.events.OrderedItem;
import io.zenwave360.example.core.domain.events.PaymentDetails;
import io.zenwave360.example.core.domain.events.ShippingDetails;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.TimeZone;

@Mapper(componentModel = "spring")
public interface EventsMapper {

    public static final EventsMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EventsMapper.class);

    default Instant asInstant(OffsetDateTime date) {
        return date != null ? date.toInstant() : null;
    }

    default OffsetDateTime asOffsetDateTime(Instant date) {
        return date != null ? OffsetDateTime.ofInstant(date, TimeZone.getTimeZone("UTC").toZoneId()) : null;
    }

    Customer asCustomer(io.zenwave360.example.core.domain.Customer customer);
    ShippingDetails asShippingDetails(io.zenwave360.example.core.domain.ShippingDetails shippingDetails);
    PaymentDetails asPaymentDetails(io.zenwave360.example.core.domain.PaymentDetails paymentDetails);

    CustomerOrder asCustomerOrder(io.zenwave360.example.core.domain.CustomerOrder customerOrder);

    OrderedItem asOrderedItem(io.zenwave360.example.core.domain.OrderedItem orderedItem);
    OrderShippingDetails asOrderShippingDetails(io.zenwave360.example.core.domain.OrderShippingDetails shippingDetails);
}
