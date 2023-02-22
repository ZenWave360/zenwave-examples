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
* Integration tests for the {@link CustomerOrderApi} REST controller.
*/
public class CustomerOrderApiIT extends BaseWebTestClientTest {



    /**
    * Test:  for CustomerOrders.
    */
    @Test
    public void testSearchCustomerOrders_200() {
        CustomerOrderSearchCriteriaDTO requestBody = new CustomerOrderSearchCriteriaDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setDateTo(null);
        requestBody.setDateFrom(null);
        requestBody.setStatus(null);
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(POST).uri(uriBuilder -> uriBuilder.path("/api/customer-orders/search").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
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
            .jsonPath("$.content[0].date").isNotEmpty()
            .jsonPath("$.content[0].shippingDetails").isNotEmpty()
            .jsonPath("$.content[0].status").isNotEmpty()
            .jsonPath("$.content[0].orderedItems").isNotEmpty()
            .jsonPath("$.content[0].customerId").isNotEmpty()
            .jsonPath("$.content[0].customer").isNotEmpty()
            .jsonPath("$.content[0].paymentDetailsId").isNotEmpty()
            .jsonPath("$.content[0].paymentDetails").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrders.
    */
    @Test
    public void testListCustomerOrders_200() {
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(GET).uri(uriBuilder -> uriBuilder.path("/api/customer-orders").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
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
            .jsonPath("$.content[0].date").isNotEmpty()
            .jsonPath("$.content[0].shippingDetails").isNotEmpty()
            .jsonPath("$.content[0].status").isNotEmpty()
            .jsonPath("$.content[0].orderedItems").isNotEmpty()
            .jsonPath("$.content[0].customerId").isNotEmpty()
            .jsonPath("$.content[0].customer").isNotEmpty()
            .jsonPath("$.content[0].paymentDetailsId").isNotEmpty()
            .jsonPath("$.content[0].paymentDetails").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder.
    */
    @Test
    public void testCreateCustomerOrder_201() {
        CustomerOrderDTO requestBody = new CustomerOrderDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setDate(null);
        requestBody.setShippingDetails(new OrderShippingDetailsDTO());
        requestBody.getShippingDetails().setAddress(null);
        requestBody.getShippingDetails().setPhone(null);
        requestBody.setStatus(null);
        requestBody.setOrderedItems(new java.util.ArrayList<>());
        requestBody.getOrderedItems().get(0).setId(null);
        requestBody.getOrderedItems().get(0).setVersion(null);
        requestBody.getOrderedItems().get(0).setCatalogItemId(null);
        requestBody.getOrderedItems().get(0).setName(null);
        requestBody.getOrderedItems().get(0).setQuantity(null);
        requestBody.getOrderedItems().get(0).setPrice(null);
        requestBody.setCustomerId(null);
        requestBody.setCustomer(new CustomerDTO());
        requestBody.getCustomer().setId(null);
        requestBody.getCustomer().setVersion(null);
        requestBody.getCustomer().setFirstName(null);
        requestBody.getCustomer().setLastName(null);
        requestBody.getCustomer().setPassword(null);
        requestBody.getCustomer().setEmail(null);
        requestBody.getCustomer().setUsername(null);
        requestBody.setPaymentDetailsId(null);
        requestBody.setPaymentDetails(new PaymentDetailsDTO());
        requestBody.getPaymentDetails().setId(null);
        requestBody.getPaymentDetails().setVersion(null);
        requestBody.getPaymentDetails().setCardHolderName(null);
        requestBody.getPaymentDetails().setCreditCardNumber(null);
        requestBody.getPaymentDetails().setCustomerId(null);
        requestBody.getPaymentDetails().setCustomer(null);

        webTestClient.method(POST).uri("/api/customer-orders")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.shippingDetails.address").isNotEmpty()
            .jsonPath("$.shippingDetails.phone").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.orderedItems").isArray()
            .jsonPath("$.orderedItems[0].id").isNotEmpty()
            .jsonPath("$.orderedItems[0].version").isNotEmpty()
            .jsonPath("$.orderedItems[0].catalogItemId").isNotEmpty()
            .jsonPath("$.orderedItems[0].name").isNotEmpty()
            .jsonPath("$.orderedItems[0].quantity").isNotEmpty()
            .jsonPath("$.orderedItems[0].price").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.paymentDetailsId").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.paymentDetails.id").isNotEmpty()
            .jsonPath("$.paymentDetails.version").isNotEmpty()
            .jsonPath("$.paymentDetails.cardHolderName").isNotEmpty()
            .jsonPath("$.paymentDetails.creditCardNumber").isNotEmpty()
            .jsonPath("$.paymentDetails.customerId").isNotEmpty()
            .jsonPath("$.paymentDetails.customer").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder.
    */
    @Test
    public void testGetCustomerOrder_200() {
        var id = "1";

        webTestClient.method(GET).uri("/api/customer-orders/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.shippingDetails.address").isNotEmpty()
            .jsonPath("$.shippingDetails.phone").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.orderedItems").isArray()
            .jsonPath("$.orderedItems[0].id").isNotEmpty()
            .jsonPath("$.orderedItems[0].version").isNotEmpty()
            .jsonPath("$.orderedItems[0].catalogItemId").isNotEmpty()
            .jsonPath("$.orderedItems[0].name").isNotEmpty()
            .jsonPath("$.orderedItems[0].quantity").isNotEmpty()
            .jsonPath("$.orderedItems[0].price").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.paymentDetailsId").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.paymentDetails.id").isNotEmpty()
            .jsonPath("$.paymentDetails.version").isNotEmpty()
            .jsonPath("$.paymentDetails.cardHolderName").isNotEmpty()
            .jsonPath("$.paymentDetails.creditCardNumber").isNotEmpty()
            .jsonPath("$.paymentDetails.customerId").isNotEmpty()
            .jsonPath("$.paymentDetails.customer").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder.
    */
    @Test
    public void testUpdateCustomerOrder_200() {
        CustomerOrderDTO requestBody = new CustomerOrderDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setDate(null);
        requestBody.setShippingDetails(new OrderShippingDetailsDTO());
        requestBody.getShippingDetails().setAddress(null);
        requestBody.getShippingDetails().setPhone(null);
        requestBody.setStatus(null);
        requestBody.setOrderedItems(new java.util.ArrayList<>());
        requestBody.getOrderedItems().get(0).setId(null);
        requestBody.getOrderedItems().get(0).setVersion(null);
        requestBody.getOrderedItems().get(0).setCatalogItemId(null);
        requestBody.getOrderedItems().get(0).setName(null);
        requestBody.getOrderedItems().get(0).setQuantity(null);
        requestBody.getOrderedItems().get(0).setPrice(null);
        requestBody.setCustomerId(null);
        requestBody.setCustomer(new CustomerDTO());
        requestBody.getCustomer().setId(null);
        requestBody.getCustomer().setVersion(null);
        requestBody.getCustomer().setFirstName(null);
        requestBody.getCustomer().setLastName(null);
        requestBody.getCustomer().setPassword(null);
        requestBody.getCustomer().setEmail(null);
        requestBody.getCustomer().setUsername(null);
        requestBody.setPaymentDetailsId(null);
        requestBody.setPaymentDetails(new PaymentDetailsDTO());
        requestBody.getPaymentDetails().setId(null);
        requestBody.getPaymentDetails().setVersion(null);
        requestBody.getPaymentDetails().setCardHolderName(null);
        requestBody.getPaymentDetails().setCreditCardNumber(null);
        requestBody.getPaymentDetails().setCustomerId(null);
        requestBody.getPaymentDetails().setCustomer(null);
        var id = "1";

        webTestClient.method(PUT).uri("/api/customer-orders/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.shippingDetails.address").isNotEmpty()
            .jsonPath("$.shippingDetails.phone").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.orderedItems").isArray()
            .jsonPath("$.orderedItems[0].id").isNotEmpty()
            .jsonPath("$.orderedItems[0].version").isNotEmpty()
            .jsonPath("$.orderedItems[0].catalogItemId").isNotEmpty()
            .jsonPath("$.orderedItems[0].name").isNotEmpty()
            .jsonPath("$.orderedItems[0].quantity").isNotEmpty()
            .jsonPath("$.orderedItems[0].price").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.paymentDetailsId").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.paymentDetails.id").isNotEmpty()
            .jsonPath("$.paymentDetails.version").isNotEmpty()
            .jsonPath("$.paymentDetails.cardHolderName").isNotEmpty()
            .jsonPath("$.paymentDetails.creditCardNumber").isNotEmpty()
            .jsonPath("$.paymentDetails.customerId").isNotEmpty()
            .jsonPath("$.paymentDetails.customer").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder deleted.
    */
    @Test
    public void testDeleteCustomerOrder_204() {
        var id = "1";

        webTestClient.method(DELETE).uri("/api/customer-orders/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);
    }

}
