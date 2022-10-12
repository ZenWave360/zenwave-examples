package io.zenwave360.example.adapters.events;

import io.zenwave360.example.adapters.web.mappers.BaseMapper;
import io.zenwave360.example.core.events.model.Customer;
import io.zenwave360.example.core.events.model.CustomerOrder;
import io.zenwave360.example.core.inbound.dtos.CustomerInput;
import io.zenwave360.example.core.inbound.dtos.CustomerOrderInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BaseMapper.class)
public interface EventsMapper {

    CustomerInput asCustomerInput(Customer payload);

    CustomerOrderInput asCustomerOrderInput(CustomerOrder payload);
}
