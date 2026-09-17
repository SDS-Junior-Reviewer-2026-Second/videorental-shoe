package com.videorental;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    // [65~68p]
    // 영화 종류별 가격 정책을 Rental에서 Movie로 이동
    double getChargeFor(int daysRented) {
        double thisAmount = 0;

        switch (getPriceCode()) {

            case REGULAR:
                thisAmount += 2;

                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;

            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;

            case CHILDRENS:
                thisAmount += 1.5;

                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
        }

        return thisAmount;
    }

    // [69p]
    // 영화 종류에 따라 달라지는 포인트 정책도 Movie로 이동
    int getFrequentRenterPointsFor(int daysRented) {
        if (getPriceCode() == NEW_RELEASE
                && daysRented > 1) {
            return 2;
        }

        return 1;
    }
}