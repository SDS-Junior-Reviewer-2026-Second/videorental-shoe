package com.videorental;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title, Movie.CHILDRENS);
    }

    @Override
    double getChargeFor(int daysRented) {
        double thisAmount = 1.5;

        if (daysRented > 3) {
            thisAmount += (daysRented - 3) * 1.5;
        }

        return thisAmount;
    }

    // [75p]
    // 유아 영화는 항상 1점
    @Override
    int getFrequentRenterPointsFor(int daysRented) {
        return 1;
    }
}