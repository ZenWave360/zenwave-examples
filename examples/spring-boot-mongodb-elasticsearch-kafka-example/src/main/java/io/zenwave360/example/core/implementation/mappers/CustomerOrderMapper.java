package io.zenwave360.example.core.implementation.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {

  CustomerOrder asEntity(CustomerOrderInput input);

  CustomerOrder update(@MappingTarget CustomerOrder entity, CustomerOrderInput input);
}
