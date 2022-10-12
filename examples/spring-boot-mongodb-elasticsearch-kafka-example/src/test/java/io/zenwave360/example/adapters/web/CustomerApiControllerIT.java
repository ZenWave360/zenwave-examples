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
* Integration tests for the {@link CustomerApiController} REST controller.
*/
@SpringBootTest
@AutoConfigureWebTestClient
@WithMockUser
class CustomerApiControllerIT {

    @Autowired
    private WebTestClient webTestClient;



    /**
    * Test:  for Customers.
    */
    @Test
    public void testSearchCustomers_200() {
        CustomerCriteriaDTO requestBody = new CustomerCriteriaDTO();
        requestBody.setId(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setUsername(null);

        webTestClient.method(POST).uri("/customers/search")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestBody), CustomerCriteriaDTO.class)
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
    * Test:  for Customers.
    */
    @Test
    public void testListCustomers_200() {

        webTestClient.method(GET).uri("/customers")
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
    * Test:  for Customer.
    */
    @Test
    public void testCreateCustomer_201() {
        CustomerDTO requestBody = new CustomerDTO();
        requestBody.setId(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setUsername(null);

        webTestClient.method(POST).uri("/customers")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestBody), CustomerDTO.class)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.firstName").isNotEmpty()
            .jsonPath("$.lastName").isNotEmpty()
            .jsonPath("$.password").isNotEmpty()
            .jsonPath("$.email").isNotEmpty()
            .jsonPath("$.username").isNotEmpty();
    }

    /**
    * Test:  for Customer.
    */
    @Test
    public void testGetCustomer_200() {

        webTestClient.method(GET).uri("/customers/{id}")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.firstName").isNotEmpty()
            .jsonPath("$.lastName").isNotEmpty()
            .jsonPath("$.password").isNotEmpty()
            .jsonPath("$.email").isNotEmpty()
            .jsonPath("$.username").isNotEmpty();
    }

    /**
    * Test:  for Customer.
    */
    @Test
    public void testUpdateCustomer_200() {
        CustomerDTO requestBody = new CustomerDTO();
        requestBody.setId(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setUsername(null);

        webTestClient.method(PUT).uri("/customers/{id}")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just(requestBody), CustomerDTO.class)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.firstName").isNotEmpty()
            .jsonPath("$.lastName").isNotEmpty()
            .jsonPath("$.password").isNotEmpty()
            .jsonPath("$.email").isNotEmpty()
            .jsonPath("$.username").isNotEmpty();
    }

}
