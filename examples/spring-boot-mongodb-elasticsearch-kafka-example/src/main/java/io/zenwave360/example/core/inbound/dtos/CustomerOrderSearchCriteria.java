package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/** */
public class CustomerOrderSearchCriteria extends PageRequest implements Serializable, Pageable {

    public CustomerOrderSearchCriteria() {
        this(0, 10, Sort.unsorted());
    }

    public CustomerOrderSearchCriteria(int page, int size, Sort sort) {
        super(page, size, sort);
    }

    private Instant dateTo;

    private Instant dateFrom;

    private OrderStatus status;

    public CustomerOrderSearchCriteria withDateTo(Instant dateTo) {
        this.dateTo = dateTo;
        return this;
    }

    public CustomerOrderSearchCriteria withDateFrom(Instant dateFrom) {
        this.dateFrom = dateFrom;
        return this;
    }

    public CustomerOrderSearchCriteria withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public Instant getDateTo() {
        return dateTo;
    }

    public void setDateTo(Instant dateTo) {
        this.dateTo = dateTo;
    }

    public Instant getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Instant dateFrom) {
        this.dateFrom = dateFrom;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
