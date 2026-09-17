package com.videorental;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    double getChargeFor(int daysRented) {
        return daysRented * 3;
    }

    // [75p]
    // 신작만 2일 이상이면 포인트 2점
    @Override
    int getFrequentRenterPointsFor(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }

        return 1;
    }
}