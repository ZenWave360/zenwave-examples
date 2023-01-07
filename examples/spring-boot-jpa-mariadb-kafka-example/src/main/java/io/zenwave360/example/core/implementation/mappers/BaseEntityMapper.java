package io.zenwave360.example.core.implementation.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BaseEntityMapper {

  BaseEntity asEntity(BaseEntityInput input);

  BaseEntity update(@MappingTarget BaseEntity entity, BaseEntityInput input);
}
