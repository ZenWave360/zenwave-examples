package io.zenwave360.example.adapters.web;

import io.zenwave360.example.adapters.web.*;
import io.zenwave360.example.adapters.web.model.*;
import io.zenwave360.example.adapters.web.BaseWebTestClientTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.HttpMethod.*;

/**
* Business Flow Test for:createCustomerOrder, getCustomerOrder, updateCustomerOrder, deleteCustomerOrder.
*/
public class CustomerOrder_CRUD_IT extends BaseWebTestClientTest {

    /**
    * Business Flow Test for: createCustomerOrder, getCustomerOrder, updateCustomerOrder, deleteCustomerOrder.
    */
    @Test
    public void testCustomerOrder_CRUD_IT() {
        // createCustomerOrder: 
        CustomerOrderDTO customerOrderRequestBody0 = new CustomerOrderDTO();
        customerOrderRequestBody0.setId(null);
        customerOrderRequestBody0.setVersion(null);
        customerOrderRequestBody0.setDate(null);
        customerOrderRequestBody0.setShippingDetails(new ShippingDetailsDTO());
        customerOrderRequestBody0.getShippingDetails().setAddress(null);
        customerOrderRequestBody0.setOrderedItems(new java.util.ArrayList<>());
        customerOrderRequestBody0.getOrderedItems().get(0).setCatalogItemId(null);
        customerOrderRequestBody0.getOrderedItems().get(0).setName(null);
        customerOrderRequestBody0.getOrderedItems().get(0).setQuantity(null);
        customerOrderRequestBody0.getOrderedItems().get(0).setPrice(null);
        customerOrderRequestBody0.setPaymentDetails(new java.util.ArrayList<>());
        customerOrderRequestBody0.getPaymentDetails().get(0).setCreditCardNumber(null);
        customerOrderRequestBody0.setStatus(null);
        customerOrderRequestBody0.setCustomer(new CustomerDTO());
        customerOrderRequestBody0.getCustomer().setId(null);
        customerOrderRequestBody0.getCustomer().setVersion(null);
        customerOrderRequestBody0.getCustomer().setFirstName(null);
        customerOrderRequestBody0.getCustomer().setLastName(null);
        customerOrderRequestBody0.getCustomer().setPassword(null);
        customerOrderRequestBody0.getCustomer().setEmail(null);
        customerOrderRequestBody0.getCustomer().setUsername(null);

        var createCustomerOrderResponse0 = webTestClient.method(POST).uri("/api/customer-orders")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(customerOrderRequestBody0)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerOrderDTO.class);

    
        // getCustomerOrder: 
        var id1 = "";

        var getCustomerOrderResponse1 = webTestClient.method(GET).uri("/api/customer-orders/{id}", id1)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerOrderDTO.class);

    
        // updateCustomerOrder: 
        CustomerOrderDTO customerOrderRequestBody2 = new CustomerOrderDTO();
        customerOrderRequestBody2.setId(null);
        customerOrderRequestBody2.setVersion(null);
        customerOrderRequestBody2.setDate(null);
        customerOrderRequestBody2.setShippingDetails(new ShippingDetailsDTO());
        customerOrderRequestBody2.getShippingDetails().setAddress(null);
        customerOrderRequestBody2.setOrderedItems(new java.util.ArrayList<>());
        customerOrderRequestBody2.getOrderedItems().get(0).setCatalogItemId(null);
        customerOrderRequestBody2.getOrderedItems().get(0).setName(null);
        customerOrderRequestBody2.getOrderedItems().get(0).setQuantity(null);
        customerOrderRequestBody2.getOrderedItems().get(0).setPrice(null);
        customerOrderRequestBody2.setPaymentDetails(new java.util.ArrayList<>());
        customerOrderRequestBody2.getPaymentDetails().get(0).setCreditCardNumber(null);
        customerOrderRequestBody2.setStatus(null);
        customerOrderRequestBody2.setCustomer(new CustomerDTO());
        customerOrderRequestBody2.getCustomer().setId(null);
        customerOrderRequestBody2.getCustomer().setVersion(null);
        customerOrderRequestBody2.getCustomer().setFirstName(null);
        customerOrderRequestBody2.getCustomer().setLastName(null);
        customerOrderRequestBody2.getCustomer().setPassword(null);
        customerOrderRequestBody2.getCustomer().setEmail(null);
        customerOrderRequestBody2.getCustomer().setUsername(null);
        var id2 = "";

        var updateCustomerOrderResponse2 = webTestClient.method(PUT).uri("/api/customer-orders/{id}", id2)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(customerOrderRequestBody2)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerOrderDTO.class);

    
        // deleteCustomerOrder: 
        var id3 = "";

        webTestClient.method(DELETE).uri("/api/customer-orders/{id}", id3)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);

    
    }


}
