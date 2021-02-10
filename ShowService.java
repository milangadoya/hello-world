/**
 * 
 */
package com.src.MovieTicketBooking;

import java.util.List;

/**
 * @author milan.gadoya
 *
 */
public interface ShowService {

	public void printAllShows(List<ShowDetail> showsList);
	
	public void addNewShow(ShowDetail showDetail);
	
	public void removeShow(ShowDetail showDetail);
	
}
