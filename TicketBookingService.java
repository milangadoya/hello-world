/**
 * 
 */
package com.src.MovieTicketBooking;

/**
 * @author milan.gadoya
 *
 */
public interface TicketBookingService {
	
	public void bookTicket(TicketDetail ticketDetail);
	
	public void cancelTicket(TicketDetail ticketDetail);
	
	public void printAllTickets();

}
