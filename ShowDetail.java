/**
 * 
 */
package com.src.MovieTicketBooking;

import java.util.Date;

/**
 * @author milan.gadoya
 *
 */
public class ShowDetail {

	private String movieName;
	private String showDateTime;
	private int ticketPrice;
	
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	/**
	 * @return the showDateTime
	 */
	public String getShowDateTime() {
		return showDateTime;
	}
	/**
	 * @param showDateTime the showDateTime to set
	 */
	public void setShowDateTime(String showDateTime) {
		this.showDateTime = showDateTime;
	}
	/**
	 * @return the ticketPrice
	 */
	public int getTicketPrice() {
		return ticketPrice;
	}
	/**
	 * @param ticketPrice the ticketPrice to set
	 */
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
