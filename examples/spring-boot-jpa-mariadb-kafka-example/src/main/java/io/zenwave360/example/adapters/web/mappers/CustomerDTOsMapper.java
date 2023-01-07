package io.zenwave360.example.adapters.web.mappers;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.inbound.dtos.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = BaseMapper.class)
public interface CustomerDTOsMapper {

  io.zenwave360.example.adapters.web.model.ShippingDetailsPaginatedDTO asShippingDetailsPaginatedDTO(Page<ShippingDetails> page);

  io.zenwave360.example.adapters.web.model.CustomerDTO asCustomerDTO(Customer customer);

  Customer asCustomer(io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  CustomerInput asCustomerInput(io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  CustomerCriteria asCustomerCriteria(io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  Customer update(@MappingTarget Customer customer, io.zenwave360.example.adapters.web.model.CustomerDTO dto);

  List<io.zenwave360.example.adapters.web.model.CustomerDTO> asCustomerDTOList(List<Customer> customers);

  List<Customer> asCustomerList(List<io.zenwave360.example.adapters.web.model.CustomerDTO> dtos);

  io.zenwave360.example.adapters.web.model.ShippingDetailsDTO asShippingDetailsDTO(ShippingDetails shippingDetails);

  ShippingDetails asShippingDetails(io.zenwave360.example.adapters.web.model.ShippingDetailsDTO dto);

  ShippingDetailsInput asShippingDetailsInput(io.zenwave360.example.adapters.web.model.ShippingDetailsDTO dto);

  ShippingDetails update(@MappingTarget ShippingDetails shippingDetails, io.zenwave360.example.adapters.web.model.ShippingDetailsDTO dto);

  List<io.zenwave360.example.adapters.web.model.ShippingDetailsDTO> asShippingDetailsDTOList(List<ShippingDetails> shippingDetails);

  List<ShippingDetails> asShippingDetailsList(List<io.zenwave360.example.adapters.web.model.ShippingDetailsDTO> dtos);

  io.zenwave360.example.adapters.web.model.PaymentDetailsDTO asPaymentDetailsDTO(PaymentDetails paymentDetails);

  PaymentDetails asPaymentDetails(io.zenwave360.example.adapters.web.model.PaymentDetailsDTO dto);

  PaymentDetailsInput asPaymentDetailsInput(io.zenwave360.example.adapters.web.model.PaymentDetailsDTO dto);

  PaymentDetails update(@MappingTarget PaymentDetails paymentDetails, io.zenwave360.example.adapters.web.model.PaymentDetailsDTO dto);

  List<io.zenwave360.example.adapters.web.model.PaymentDetailsDTO> asPaymentDetailsDTOList(List<PaymentDetails> paymentDetails);

  List<PaymentDetails> asPaymentDetailsList(List<io.zenwave360.example.adapters.web.model.PaymentDetailsDTO> dtos);

  io.zenwave360.example.adapters.web.model.PaymentDetailsPaginatedDTO asPaymentDetailsPaginatedDTO(Page<PaymentDetails> page);

  io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO asCustomerCriteriaDTO(CustomerCriteria customerCriteria);

  CustomerCriteria asCustomerCriteria(io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO dto);

  CustomerCriteria update(@MappingTarget CustomerCriteria customerCriteria, io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO dto);

  List<io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO> asCustomerCriteriaDTOList(List<CustomerCriteria> customersCriteria);

  List<CustomerCriteria> asCustomerCriteriaList(List<io.zenwave360.example.adapters.web.model.CustomerCriteriaDTO> dtos);

  io.zenwave360.example.adapters.web.model.CustomerPaginatedDTO asCustomerPaginatedDTO(Page<Customer> page);
}
