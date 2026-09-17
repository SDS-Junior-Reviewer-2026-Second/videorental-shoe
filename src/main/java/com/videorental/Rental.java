package com.videorental;

class Rental {

	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public double getCharge() {

		// [65~68p 변경]
		// Rental이 직접 영화 종류별 가격 계산을 하지 않는다.
		// "이 Movie를 며칠 빌렸을 때 얼마냐?"를 Movie에게 물어본다.
		return getMovie().getChargeFor(getDaysRented());
	}

	public int getFrequentRenterPointsFor() {

		// [69p 변경]
		// 포인트 정책도 Movie 종류에 따라 결정되므로
		// Movie에게 daysRented를 넘겨 계산을 맡긴다.
		return getMovie().getFrequentRenterPointsFor(getDaysRented());
	}
}