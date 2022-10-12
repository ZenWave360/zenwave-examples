package io.zenwave360.example.adapters.events;

import io.zenwave360.example.core.events.model.CustomerOrderRequestPayload;
import io.zenwave360.example.core.events.model.CustomerOrderRequestPayload.RequestType;
import io.zenwave360.example.core.events.provider.IDoCustomerOrderRequestConsumerService;
import io.zenwave360.example.core.inbound.CustomerOrderUseCases;
import io.zenwave360.example.core.inbound.dtos.CustomerOrderInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DoCustomerOrderRequestConsumerService implements IDoCustomerOrderRequestConsumerService {

    @Autowired
    private EventsMapper eventsMapper;
    @Autowired
    private CustomerOrderUseCases customerOrderUseCases;
    @Override
    public void doCustomerOrderRequest(CustomerOrderRequestPayload payload, Map<String, Object> headers) {
        CustomerOrderInput input = eventsMapper.asCustomerOrderInput(payload.getCustomerOrder());
        if(payload.getRequestType() == RequestType.CREATE) {
            customerOrderUseCases.createCustomerOrder(input);
        } else if(payload.getRequestType() == RequestType.UPDATE) {
            customerOrderUseCases.updateCustomerOrder(payload.getCustomerOrderId(), input);
        } else if(payload.getRequestType() == RequestType.DELETE) {
            customerOrderUseCases.deleteCustomerOrder(payload.getCustomerOrderId());
        }
    }
}
