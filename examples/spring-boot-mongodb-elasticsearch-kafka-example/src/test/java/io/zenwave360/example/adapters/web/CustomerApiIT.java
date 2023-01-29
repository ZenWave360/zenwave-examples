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
* Integration tests for the {@link CustomerApi} REST controller.
*/
public class CustomerApiIT extends BaseWebTestClientTest {



    /**
    * Test:  for Customers.
    */
    @Test
    public void testSearchCustomers_200() {
        CustomerCriteriaDTO requestBody = new CustomerCriteriaDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setUsername(null);
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(POST).uri(uriBuilder -> uriBuilder.path("/api/customers/search").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.number").isNotEmpty()
            .jsonPath("$.numberOfElements").isNotEmpty()
            .jsonPath("$.size").isNotEmpty()
            .jsonPath("$.totalElements").isNotEmpty()
            .jsonPath("$.totalPages").isNotEmpty()
            .jsonPath("$.content").isNotEmpty()
            .jsonPath("$.content").isArray()
            .jsonPath("$.content[0].id").isNotEmpty()
            .jsonPath("$.content[0].version").isNotEmpty()
            .jsonPath("$.content[0].firstName").isNotEmpty()
            .jsonPath("$.content[0].lastName").isNotEmpty()
            .jsonPath("$.content[0].password").isNotEmpty()
            .jsonPath("$.content[0].email").isNotEmpty()
            .jsonPath("$.content[0].username").isNotEmpty();
    }

    /**
    * Test:  for Customers.
    */
    @Test
    public void testListCustomers_200() {
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(GET).uri(uriBuilder -> uriBuilder.path("/api/customers").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
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
            .jsonPath("$.content").isNotEmpty()
            .jsonPath("$.content").isArray()
            .jsonPath("$.content[0].id").isNotEmpty()
            .jsonPath("$.content[0].version").isNotEmpty()
            .jsonPath("$.content[0].firstName").isNotEmpty()
            .jsonPath("$.content[0].lastName").isNotEmpty()
            .jsonPath("$.content[0].password").isNotEmpty()
            .jsonPath("$.content[0].email").isNotEmpty()
            .jsonPath("$.content[0].username").isNotEmpty();
    }

    /**
    * Test:  for Customer.
    */
    @Test
    public void testCreateCustomer_201() {
        CustomerDTO requestBody = new CustomerDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setUsername(null);

        webTestClient.method(POST).uri("/api/customers")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
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
        var id = "";

        webTestClient.method(GET).uri("/api/customers/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
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
        requestBody.setVersion(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setUsername(null);
        var id = "";

        webTestClient.method(PUT).uri("/api/customers/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.firstName").isNotEmpty()
            .jsonPath("$.lastName").isNotEmpty()
            .jsonPath("$.password").isNotEmpty()
            .jsonPath("$.email").isNotEmpty()
            .jsonPath("$.username").isNotEmpty();
    }

    /**
    * Test:  for Customer deleted.
    */
    @Test
    public void testDeleteCustomer_204() {
        var id = "";

        webTestClient.method(DELETE).uri("/api/customers/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);
    }

}
