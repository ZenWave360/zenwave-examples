package io.zenwave360.example.adapters.web.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = BaseMapper.class)
public interface CustomerDTOsMapper {

  io.zenwave360.example.adapters.web.model.CustomerDTO asCustomerDTO(Customer customer);

  Customer asCustomer(io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  CustomerInput asCustomerInput(io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  CustomerCriteria asCustomerCriteria(io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  Customer update(@MappingTarget Customer customer, io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  List<io.zenwave360.example.adapters.web.model.CustomerDTO> asCustomerDTOList(List<Customer> customers);

  List<Customer> asCustomerList(List<io.zenwave360.example.adapters.web.model.CustomerDTO> dtos);

  io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO asCustomerCriteriaDTO(CustomerCriteria customerCriteria);

  CustomerCriteria asCustomerCriteria(io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO dto);

  CustomerCriteria update(@MappingTarget CustomerCriteria customerCriteria, io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO dto);

  List<io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO> asCustomerCriteriaDTOList(List<CustomerCriteria> customersCriteria);

  List<CustomerCriteria> asCustomerCriteriaList(List<io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO> dtos);

  io.zenwave360.example.adapters.web.model.CustomerPaginatedDTO asCustomerPaginatedDTO(Page<Customer> page);
}
