package io.zenwave360.example.core.implementation.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentDetailsMapper {

  PaymentDetails asEntity(PaymentDetailsInput input);

  @Mapping(target = "id", ignore = true)
  PaymentDetails update(@MappingTarget PaymentDetails entity, PaymentDetailsInput input);
}
