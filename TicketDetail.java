/**
 * 
 */
package com.src.MovieTicketBooking;

/**
 * @author milan.gadoya
 *
 */
public class TicketDetail {

	private User user;
	private int totalTicketsPrice;
	private int totalTickets;
	private String seatNames;
	private ShowDetail showDetail;
	
	/**
	 * @return the totalTicketsPrice
	 */
	public int getTotalTicketsPrice() {
		return totalTicketsPrice;
	}
	/**
	 * @param totalTicketsPrice the totalTicketsPrice to set
	 */
	public void setTotalTicketsPrice(int totalTicketsPrice) {
		this.totalTicketsPrice = totalTicketsPrice;
	}
	/**
	 * @return the totalTickets
	 */
	public int getTotalTickets() {
		return totalTickets;
	}
	/**
	 * @param totalTickets the totalTickets to set
	 */
	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}
	/**
	 * @return the seatNames
	 */
	public String getSeatNames() {
		return seatNames;
	}
	/**
	 * @param seatNames the seatNames to set
	 */
	public void setSeatNames(String seatNames) {
		this.seatNames = seatNames;
	}
	/**
	 * @return the showDetail
	 */
	public ShowDetail getShowDetail() {
		return showDetail;
	}
	/**
	 * @param showDetail the showDetail to set
	 */
	public void setShowDetail(ShowDetail showDetail) {
		this.showDetail = showDetail;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
