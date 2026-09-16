package com.videorental;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {
    @Test
    public void returnNewCustomer() {
        Customer customer = new Customer("Name_Not_Important");
        assertThat(customer).isNotNull();
    }
    
    @Test
    public void statementForNoRental() {
        Customer customer = new Customer("NAME_NOT_IMPORTANT");

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "Amount owed is 0.0\n"
                        + "You earned 0 frequent renter pointers"
        );
    }
}
