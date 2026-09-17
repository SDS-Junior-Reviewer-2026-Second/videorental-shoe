package com.videorental;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private static final String NAME = "NAME_NOT_IMPORTANT";
    private static final String TITLE = "TITLE_NOT_IMPORTANT";

    Customer customer = new Customer(NAME);

    @Test
    public void returnNewCustomer() {
        assertThat(customer).isNotNull();
    }

    @Test
    public void statementForNoRental() {
        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "Amount owed is 0.0\n"
                        + "You earned 0 frequent renter pointers"
        );
    }

    @Test
    public void statementForRegularMovieRentalForLessThan3Days() {
        customer.addRental(createRentalFor(2, Movie.REGULAR));

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "\t2.0(TITLE_NOT_IMPORTANT)\n"
                        + "Amount owed is 2.0\n"
                        + "You earned 1 frequent renter pointers"
        );
    }

    @Test
    public void statementForRegularMovieRentalForMoreThan2Days() {
        customer.addRental(createRentalFor(3, Movie.REGULAR));

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "\t3.5(TITLE_NOT_IMPORTANT)\n"
                        + "Amount owed is 3.5\n"
                        + "You earned 1 frequent renter pointers"
        );
    }

    @Test
    public void statementForNewReleaseMovie() {
        customer.addRental(createRentalFor(1, Movie.NEW_RELEASE));

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "\t3.0(TITLE_NOT_IMPORTANT)\n"
                        + "Amount owed is 3.0\n"
                        + "You earned 1 frequent renter pointers"
        );
    }

    @Test
    public void statementForChildrensMovieRentalMoreThan3Days() {
        customer.addRental(createRentalFor(4, Movie.CHILDRENS));

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "\t3.0(TITLE_NOT_IMPORTANT)\n"
                        + "Amount owed is 3.0\n"
                        + "You earned 1 frequent renter pointers"
        );
    }

    @Test
    public void statementForChildrensMovieRentalLessThan4Days() {
        customer.addRental(createRentalFor(3, Movie.CHILDRENS));

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "\t1.5(TITLE_NOT_IMPORTANT)\n"
                        + "Amount owed is 1.5\n"
                        + "You earned 1 frequent renter pointers"
        );
    }
    @Test
    public void changeMoviePriceCode() {
        Movie movie = new Movie(TITLE, Movie.REGULAR);

        movie.setPriceCode(Movie.NEW_RELEASE);

        assertThat(movie.getPriceCode()).isEqualTo(Movie.NEW_RELEASE);
    }
    @Test
    public void statementForNewReleaseMovieRentalMoreThan1Day() {
        customer.addRental(createRentalFor(2, Movie.NEW_RELEASE));

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "\t6.0(TITLE_NOT_IMPORTANT)\n"
                        + "Amount owed is 6.0\n"
                        + "You earned 2 frequent renter pointers"
        );
    }

    @Test
    public void statementForFewMovieRental() {
        customer.addRental(createRentalFor(1, Movie.REGULAR));
        customer.addRental(createRentalFor(4, Movie.NEW_RELEASE));
        customer.addRental(createRentalFor(4, Movie.CHILDRENS));

        assertThat(customer.statement()).isEqualTo(
                "Rental Record for NAME_NOT_IMPORTANT\n"
                        + "\t2.0(TITLE_NOT_IMPORTANT)\n"
                        + "\t12.0(TITLE_NOT_IMPORTANT)\n"
                        + "\t3.0(TITLE_NOT_IMPORTANT)\n"
                        + "Amount owed is 17.0\n"
                        + "You earned 4 frequent renter pointers"
        );
    }

    private Rental createRentalFor(int daysRented, int priceCode) {
        Movie movie = new Movie(TITLE, priceCode);
        return new Rental(movie, daysRented);
    }
}