package io.zenwave360.example.core.implementation.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderedItemMapper {

  OrderedItem asEntity(OrderedItemInput input);

  @Mapping(target = "id", ignore = true)
  OrderedItem update(@MappingTarget OrderedItem entity, OrderedItemInput input);
}
