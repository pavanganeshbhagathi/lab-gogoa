package services;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;
// Type your code
public class FareCalculator extends Booking
{
	Booking book = new Booking();
	public double book(Hotel hotel)
	{
		int persons = hotel.getNoOfPersons();
		//String roomType = hotel.getRoomType();
		int rates = hotel.getRates();
		//String occupancy = hotel.getOccupancy();
		LocalDate from = hotel.getFromdate();
		LocalDate to = hotel.getTodate();
		double data = 0.0;
		
		if(to.isAfter(from))
		{
			int noOfDaysBetween = (int) ChronoUnit.DAYS.between(from, to);
			int totalFare = (persons*rates) * noOfDaysBetween;
			data = book.booking(persons, totalFare);
		}
		
		return data;
	}
	public double book(Flight flight)
	{
		int persons = flight.getNoOfPersons();
		int rates = flight.getRates();
		LocalDate from = flight.getFrom();
		LocalDate to = flight.getTo();
		String triptype = flight.getClassType();
		double data = 0.0;
		
		if(triptype == "One-way")
		{
			data = book.booking(persons, rates);
		}
		if(to.isAfter(from))
		{
			rates = rates*2;
			data = book.booking(persons, rates);
		}
		
		return data;
	}
	public double book(Train train)
	{
		int persons = train.getNoOfPersons();
		int rates = train.getRates();
		double data = book.booking(persons, rates);
		return data;
	}
	public double book(Bus bus)
	{
		int persons = bus.getNoOfPersons();
		int rates = bus.getRates();
		double data = book.booking(persons, rates);
		return data;
	}
}