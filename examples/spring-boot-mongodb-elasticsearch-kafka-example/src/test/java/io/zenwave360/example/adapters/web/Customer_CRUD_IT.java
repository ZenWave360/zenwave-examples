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
* Business Flow Test for: createCustomer, getCustomer, updateCustomer, deleteCustomer.
*/
public class Customer_CRUD_IT extends BaseWebTestClientTest {

    /**
    * Business Flow Test for: createCustomer, getCustomer, updateCustomer, deleteCustomer.
    */
    @Test
    public void testCustomer_CRUD_IT() {
        // createCustomer: 
        CustomerDTO customerRequestBody0 = new CustomerDTO();
        customerRequestBody0.setId(null);
        customerRequestBody0.setVersion(null);
        customerRequestBody0.setFirstName(null);
        customerRequestBody0.setLastName(null);
        customerRequestBody0.setPassword(null);
        customerRequestBody0.setEmail(null);
        customerRequestBody0.setUsername(null);

        var createCustomerResponse0 = webTestClient.method(POST).uri("/api/customers")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(customerRequestBody0)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerDTO.class);

    
        // getCustomer: 
        var id1 = "";

        var getCustomerResponse1 = webTestClient.method(GET).uri("/api/customers/{id}", id1)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerDTO.class);

    
        // updateCustomer: 
        CustomerDTO customerRequestBody2 = new CustomerDTO();
        customerRequestBody2.setId(null);
        customerRequestBody2.setVersion(null);
        customerRequestBody2.setFirstName(null);
        customerRequestBody2.setLastName(null);
        customerRequestBody2.setPassword(null);
        customerRequestBody2.setEmail(null);
        customerRequestBody2.setUsername(null);
        var id2 = "";

        var updateCustomerResponse2 = webTestClient.method(PUT).uri("/api/customers/{id}", id2)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(customerRequestBody2)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerDTO.class);

    
        // deleteCustomer: 
        var id3 = "";

        webTestClient.method(DELETE).uri("/api/customers/{id}", id3)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);

    
    }


}
