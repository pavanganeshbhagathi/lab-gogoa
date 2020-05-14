package services;


public class Booking
{
	public double booking(int noOfPersons,int rates) {
		double totalrate=(double)noOfPersons*rates;
		
		return totalrate;
	}
}

