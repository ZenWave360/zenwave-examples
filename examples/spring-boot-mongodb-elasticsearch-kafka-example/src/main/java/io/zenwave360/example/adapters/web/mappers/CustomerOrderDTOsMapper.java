package io.zenwave360.example.adapters.web.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = BaseMapper.class)
public interface CustomerOrderDTOsMapper {

  io.zenwave360.example.adapters.web.model.CustomerOrderDTO asCustomerOrderDTO(CustomerOrder customerOrder);

  CustomerOrder asCustomerOrder(io.zenwave360.example.adapters.web.model.CustomerOrderDTO dto);

  CustomerOrderInput asCustomerOrderInput(io.zenwave360.example.adapters.web.model.CustomerOrderDTO dto);

  CustomerOrderSearchCriteria asCustomerOrderSearchCriteria(io.zenwave360.example.adapters.web.model.CustomerOrderDTO dto);

  CustomerOrder update(@MappingTarget CustomerOrder customerOrder, io.zenwave360.example.adapters.web.model.CustomerOrderDTO dto);

  List<io.zenwave360.example.adapters.web.model.CustomerOrderDTO> asCustomerOrderDTOList(List<CustomerOrder> customerOrders);

  List<CustomerOrder> asCustomerOrderList(List<io.zenwave360.example.adapters.web.model.CustomerOrderDTO> dtos);

  io.zenwave360.example.adapters.web.model.CustomerOrderSearchCriteriaDTO asCustomerOrderSearchCriteriaDTO(
      CustomerOrderSearchCriteria customerOrderSearchCriteria);

  CustomerOrderSearchCriteria asCustomerOrderSearchCriteria(io.zenwave360.example.adapters.web.model.CustomerOrderSearchCriteriaDTO dto);

  CustomerOrderSearchCriteria update(
      @MappingTarget CustomerOrderSearchCriteria customerOrderSearchCriteria,
      io.zenwave360.example.adapters.web.model.CustomerOrderSearchCriteriaDTO dto);

  List<io.zenwave360.example.adapters.web.model.CustomerOrderSearchCriteriaDTO> asCustomerOrderSearchCriteriaDTOList(
      List<CustomerOrderSearchCriteria> customerOrderSearchCriteria);

  List<CustomerOrderSearchCriteria> asCustomerOrderSearchCriteriaList(
      List<io.zenwave360.example.adapters.web.model.CustomerOrderSearchCriteriaDTO> dtos);

  io.zenwave360.example.adapters.web.model.CustomerOrderPaginatedDTO asCustomerOrderPaginatedDTO(Page<CustomerOrder> page);
}
