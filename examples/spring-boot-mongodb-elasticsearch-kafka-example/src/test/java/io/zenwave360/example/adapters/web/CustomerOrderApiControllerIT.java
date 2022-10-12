package io.zenwave360.example.adapters.web;

import io.zenwave360.example.adapters.web.*;
import io.zenwave360.example.adapters.web.model.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpMethod.*;

/**
* Integration tests for the {@link CustomerOrderApiController} REST controller.
*/
@SpringBootTest
@AutoConfigureWebTestClient
@WithMockUser
class CustomerOrderApiControllerIT {

    @Autowired
    private WebTestClient webTestClient;



    /**
    * Test:  for CustomerOrders.
    */
    @Test
    public void testSearchCustomerOrders_200() {
        CustomerOrderSearchCriteriaDTO requestBody = new CustomerOrderSearchCriteriaDTO();
        requestBody.setId(null);
        requestBody.setDateTo(null);
        requestBody.setDateFrom(null);
        requestBody.setStatus(null);

        webTestClient.method(POST).uri("/customer-orders/search")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestBody), CustomerOrderSearchCriteriaDTO.class)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.number").isNotEmpty()
            .jsonPath("$.numberOfElements").isNotEmpty()
            .jsonPath("$.size").isNotEmpty()
            .jsonPath("$.totalElements").isNotEmpty()
            .jsonPath("$.totalPages").isNotEmpty()
            .jsonPath("$.content").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrders.
    */
    @Test
    public void testListCustomerOrders_200() {

        webTestClient.method(GET).uri("/customer-orders")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.number").isNotEmpty()
            .jsonPath("$.numberOfElements").isNotEmpty()
            .jsonPath("$.size").isNotEmpty()
            .jsonPath("$.totalElements").isNotEmpty()
            .jsonPath("$.totalPages").isNotEmpty()
            .jsonPath("$.content").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder.
    */
    @Test
    public void testCreateCustomerOrder_201() {
        CustomerOrderDTO requestBody = new CustomerOrderDTO();
        requestBody.setId(null);
        requestBody.setDate(null);
        requestBody.setShippingDetails(null);
        requestBody.setOrderedItems(null);
        requestBody.setPaymentDetails(null);
        requestBody.setStatus(null);
        requestBody.setCustomer(null);

        webTestClient.method(POST).uri("/customer-orders")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestBody), CustomerOrderDTO.class)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder.
    */
    @Test
    public void testGetCustomerOrder_200() {

        webTestClient.method(GET).uri("/customer-orders/{id}")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder.
    */
    @Test
    public void testUpdateCustomerOrder_200() {
        CustomerOrderDTO requestBody = new CustomerOrderDTO();
        requestBody.setId(null);
        requestBody.setDate(null);
        requestBody.setShippingDetails(null);
        requestBody.setOrderedItems(null);
        requestBody.setPaymentDetails(null);
        requestBody.setStatus(null);
        requestBody.setCustomer(null);

        webTestClient.method(PUT).uri("/customer-orders/{id}")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestBody), CustomerOrderDTO.class)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty();
    }

}
