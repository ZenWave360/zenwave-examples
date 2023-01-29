package io.zenwave360.example.adapters.commands;

import io.zenwave360.example.core.domain.events.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.TimeZone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdapterEventsMapper {
  CustomerInput asCustomerInput(Customer dto);

  ShippingDetailsInput asShippingDetailsInput(ShippingDetails dto);

  CustomerOrderInput asCustomerOrderInput(CustomerOrder dto);

  PaymentDetailsInput asPaymentDetailsInput(PaymentDetails dto);

  OrderedItemInput asOrderedItemInput(OrderedItem dto);

  OrderShippingDetailsInput asOrderShippingDetailsInput(OrderShippingDetails dto);

  default Instant asInstant(OffsetDateTime date) {
    return date != null ? date.toInstant() : null;
  }

  default OffsetDateTime asOffsetDateTime(Instant date) {
    return date != null ? OffsetDateTime.ofInstant(date, TimeZone.getTimeZone("UTC").toZoneId()) : null;
  }
}
