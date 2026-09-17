package com.videorental;

// [71p]
// "REGULAR이라는 숫자 값" 대신
// "RegularMovie라는 객체 타입"으로 영화 종류를 표현하기 시작한다.
public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        // RegularMovie는 항상 REGULAR 타입이다.
        super(title, Movie.REGULAR);
    }

    // [71p]
    // Movie의 가격 계산 중 REGULAR 부분만 이 클래스로 이동
    @Override
    double getChargeFor(int daysRented) {
        double thisAmount = 2;

        if (daysRented > 2) {
            thisAmount += (daysRented - 2) * 1.5;
        }

        return thisAmount;
    }
}