package io.zenwave360.example.adapters.events;

import io.zenwave360.example.core.events.model.CustomerRequestPayload;
import io.zenwave360.example.core.events.model.CustomerRequestPayload.RequestType;
import io.zenwave360.example.core.events.provider.IDoCustomerRequestConsumerService;
import io.zenwave360.example.core.inbound.CustomerUseCases;
import io.zenwave360.example.core.inbound.dtos.CustomerInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * { "requestType": "create", "customer": {  "id": "string",  "firstName": "string",  "lastName": "string",  "password": "string",  "email": "string",  "username": "string" } }
 */
@Component
public class DoCustomerRequestConsumerService implements IDoCustomerRequestConsumerService {

    @Autowired
    private EventsMapper eventsMapper;
    @Autowired
    private CustomerUseCases customerUseCases;


    @Override
    public void doCustomerRequest(CustomerRequestPayload payload, Map<String, Object> headers) {
        CustomerInput input = eventsMapper.asCustomerInput(payload.getCustomer());
        if(payload.getRequestType() == RequestType.CREATE) {
            customerUseCases.createCustomer(input);
        } else if(payload.getRequestType() == RequestType.UPDATE) {
            customerUseCases.updateCustomer(payload.getCustomerId(), input);
        } else if(payload.getRequestType() == RequestType.DELETE) {
            customerUseCases.deleteCustomer(payload.getCustomerId());
        }
    }
}
