package com.revature.transport;

public class Kayak extends Boat {

	public Kayak(String color, double hullLengthInMeters, int numSeats, double paddleLengthInMeters) {
		super(color, hullLengthInMeters);
		this.numSeats = numSeats;
		this.paddleLengthInMeters = paddleLengthInMeters;
	}

	public Kayak() {
		super();
	}

	private int numSeats;
	private double paddleLengthInMeters;

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public double getPaddleLengthInMeters() {
		return paddleLengthInMeters;
	}

	public void setPaddleLengthInMeters(double paddleLengthInMeters) {
		this.paddleLengthInMeters = paddleLengthInMeters;
	}

	@Override
	public String toString() {
		return "Kayak [numSeats=" + numSeats + ", paddleLengthInMeters=" + paddleLengthInMeters + ", color=" + color
				+ ", hullLengthInMeters=" + hullLengthInMeters + "]";
	}

	

}
