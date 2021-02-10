/**
 * 
 */
package com.src.MovieTicketBooking;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author milan.gadoya
 *
 */
public class MovieTicketBooking implements TicketBookingService, ShowService {
	
	public static List<ShowDetail> showsList = new ArrayList<ShowDetail>();
	public static List<TicketDetail> ticketsList = new ArrayList<TicketDetail>();
	public static Scanner input = new Scanner(System.in);
	
	static {

		ShowDetail showDetail1 = new ShowDetail();
		showDetail1.setMovieName("3 Idiots");
		showDetail1.setTicketPrice(200);
		String strDate = "11-02-2021 09:00 AM";
		showDetail1.setShowDateTime(strDate);

		showsList.add(showDetail1);

		ShowDetail showDetail2 = new ShowDetail();
		showDetail2.setMovieName("Kabir Singh");
		showDetail2.setTicketPrice(300);
		strDate = "11-02-2021 12:00 PM";
		showDetail2.setShowDateTime(strDate);

		showsList.add(showDetail2);

		ShowDetail showDetail3 = new ShowDetail();
		showDetail3.setMovieName("Bajrangi Bhaijaan");
		showDetail3.setTicketPrice(400);
		strDate = "12-02-2021 04:00 PM";
		showDetail3.setShowDateTime(strDate);

		showsList.add(showDetail3);
		
		ShowDetail showDetail4 = new ShowDetail();
		showDetail4.setMovieName("Bajrangi Bhaijaan");
		showDetail4.setTicketPrice(400);
		strDate = "15-02-2021 09:00 PM";
		showDetail4.setShowDateTime(strDate);

		showsList.add(showDetail4);
		
		ShowDetail showDetail5 = new ShowDetail();
		showDetail5.setMovieName("Kabir Singh");
		showDetail5.setTicketPrice(300);
		strDate = "14-02-2021 05:00 PM";
		showDetail5.setShowDateTime(strDate);

		showsList.add(showDetail5);

	}
	
	public static void main(String[] args) throws ParseException {
		
		MovieTicketBooking mvtb = new MovieTicketBooking();
		
		System.out.println("\n1. Guest Login");
		System.out.println("2. Admin Login");
		System.out.println("3. Exit");
		
		System.out.println("Enter number based on your user type");

		int no = input.nextInt();
		
		if(no == 1) {
			
			System.out.println("Enter your name:");
			String name = input.nextLine();
			name += input.nextLine();
			System.out.println("Hi " + name);
			
			guestUser(mvtb, args);
			
						
		} else if (no == 2) {
			
			System.out.println("Enter your username (milan) :");
			String username = input.nextLine();
			username += input.nextLine();
			System.out.println("Enter your password (milan) :");
			String password = input.nextLine();
			password += input.nextLine();
			
			if(username.equalsIgnoreCase("milan") && password.equalsIgnoreCase("milan")) {
				System.out.println("you are logged in successfully");
				
				adminUser(mvtb, args);
				
			}
		} else if (no == 3) {
			System.out.println("Good bye");
			System.exit(0);
		}

	}
	
	public static void guestUser(MovieTicketBooking mvtb, String[] args) throws ParseException {
		
		System.out.println("\n1. Book Ticket");
		System.out.println("2. Cancel Ticket");
		System.out.println("3. Find Movie Shows by Date");
		System.out.println("4. Find Movie Shows by Name");
		System.out.println("5. Print All Shows");
		System.out.println("6. Back");
		System.out.println("7. Exit");
		
		System.out.println("Enter number that you want to perform:");
		
		int no1 = input.nextInt();
		

		if(no1 == 1) {
			mvtb.getAllDetailsToBookTicket();
			guestUser(mvtb, args);
		} else if (no1 == 2) {
			mvtb.getAllDetailsToCancelTicket();
			guestUser(mvtb, args);
		} else if (no1 == 3) {
			mvtb.findMovieShowsByDate();
			guestUser(mvtb, args);
		} else if (no1 == 4) {
			mvtb.findMovieShowsByName();
			guestUser(mvtb, args);
		} else if (no1 == 5) {
			mvtb.printAllShows(showsList);
			guestUser(mvtb, args);
		} else if (no1 == 6) {
			main(args);
		} else if (no1 == 7) {
			System.out.println("Good bye");
			System.exit(0);
		}

		
	}
	
	public static void adminUser(MovieTicketBooking mvtb, String[] args) throws ParseException {
		
		System.out.println("\n1. Print All Tickets");
		System.out.println("2. Find Movie Shows by Date");
		System.out.println("3. Find Movie Shows by Name");
		System.out.println("4. Add New Show");
		System.out.println("5. Remove Show");
		System.out.println("6. Print All Shows");
		System.out.println("7. Back");
		System.out.println("8. Exit");
		
		System.out.println("Enter number that you want to perform:");
		
		int no2 = input.nextInt();
		
		if (no2 == 1) {
			mvtb.printAllTickets();
			adminUser(mvtb, args);
		} else if (no2 == 2) {
			mvtb.findMovieShowsByDate();
			adminUser(mvtb, args);
		} else if (no2 == 3) {
			mvtb.findMovieShowsByName();
			adminUser(mvtb, args);
		} else if (no2 == 4) {
			mvtb.getAllDetailsToAddShow();
			adminUser(mvtb, args);
		} else if (no2 == 5) {
			mvtb.getAllDetailsToRemoveShow();
			adminUser(mvtb, args);
		} else if (no2 == 6) {
			mvtb.printAllShows(showsList);
			adminUser(mvtb, args);
		} else if (no2 == 7) {
			main(args);
		} else if (no2 == 8) {
			System.out.println("Good bye");
			System.exit(0);
		} 

		
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	
	public void getAllDetailsToBookTicket() {
		
		List<ShowDetail> sdList1 = showsList.stream().filter(distinctByKey(p -> p.getMovieName()))
				.collect(Collectors.toList());
		
		for(int i = 0; i < sdList1.size(); i++) {
			
			ShowDetail showDetail1 = sdList1.get(i);
			System.out.println((i + 1) + ". " + showDetail1.getMovieName());
		}
		
		System.out.println("Enter movie number that you want to watch:");
		
		String no = input.next();
		ShowDetail showDetail = sdList1.get(Integer.valueOf(no) - 1);
		String mvName = showDetail.getMovieName();
		
		List<ShowDetail> sdList2 = showsList.stream()
				.filter(map -> map.getMovieName().equalsIgnoreCase(mvName))
				.collect(Collectors.toList());
		
		for (int i = 0; i < sdList2.size(); i++) {

			ShowDetail showDetail2 = sdList2.get(i);
			System.out.println((i + 1) + ". " + showDetail2.getMovieName() + "\t" + showDetail2.getShowDateTime() + "\t" + showDetail2.getTicketPrice());
		}
		
		System.out.println("Enter movie show number that you want to watch:");
		no = input.next();
		showDetail = sdList2.get(Integer.valueOf(no) - 1);
		
		TicketDetail ticketDetail = new TicketDetail();
		ticketDetail.setShowDetail(showDetail);
		
		User user = new User();
		
		System.out.println("Enter your name:");
		String name = input.nextLine();
		name += input.nextLine();
		user.setPersonName(name);
		
		System.out.println("Enter your mobile no.:");
		String mobileNo = input.next();
		user.setMobileNo(mobileNo);
		
		System.out.println("Enter your email id:");
		String emailId = input.next();
		user.setEmailId(emailId);
		
		ticketDetail.setUser(user);
		
		System.out.println("Enter total no. of tickets:");
		int totalTickets = input.nextInt();
		ticketDetail.setTotalTickets(totalTickets);
		
		ticketDetail.setTotalTicketsPrice(showDetail.getTicketPrice() * totalTickets);
		
		bookTicket(ticketDetail);
		
	}
	
	public void getAllDetailsToCancelTicket() {
		System.out.println("Enter your reference number:");
		String refno = input.next();
		TicketDetail ticketDetail = ticketsList.get(Integer.valueOf(refno));
		cancelTicket(ticketDetail);
	}
	
	public void getAllDetailsToRemoveShow() {
		System.out.println("Enter your reference number:");
		String refno = input.next();
		ShowDetail showDetail = showsList.get(Integer.valueOf(refno));
		removeShow(showDetail);
	}
	
	public void findMovieShowsByDate() {
		System.out.println("Enter movie date (format shoud be dd-MM-yyyy) :");
		String movieTicketStrDate = input.nextLine();
		movieTicketStrDate += input.nextLine();
		final String mvDate = movieTicketStrDate;
		List<ShowDetail> sdList = showsList.stream().filter(map -> map.getShowDateTime().startsWith(mvDate))
				.collect(Collectors.toList());
		printAllShows(sdList);
	}
	
	public void findMovieShowsByName() {
		System.out.println("Enter movie name:");
		String movieName = input.nextLine();
		movieName += input.nextLine();
		final String mvName = movieName;
		List<ShowDetail> sdList = showsList.stream().filter(map -> map.getMovieName().equalsIgnoreCase(mvName))
				.collect(Collectors.toList());
		printAllShows(sdList);
	}
	
	public void getAllDetailsToAddShow() throws ParseException {
		System.out.println("Enter movie name:");
		String movieName = input.nextLine();
		movieName += input.nextLine();
		System.out.println("Enter movie ticket date (format shoud be dd-MM-yyyy hh:mm a):");
		String movieTicketStrDate = input.nextLine();
		movieTicketStrDate += input.nextLine();
		System.out.println("Enter movie ticket price:");
		int movieTikcetPrice = input.nextInt();
		ShowDetail showDetail = new ShowDetail();
		showDetail.setMovieName(movieName);
		showDetail.setShowDateTime(movieTicketStrDate);
		showDetail.setTicketPrice(movieTikcetPrice);
		addNewShow(showDetail);
	}

	@Override
	public void bookTicket(TicketDetail ticketDetail) {
		ticketsList.add(ticketDetail);
		System.out.println("Ticket booked successfully");
		System.out.println("Please note your reference number for future purpose: " + ticketsList.indexOf(ticketDetail));
		printAllTickets();
	}

	@Override
	public void cancelTicket(TicketDetail ticketDetail) {
		ticketsList.remove(ticketDetail);
		System.out.println("Ticket cancelled successfully");
		printAllTickets();
	}

	@Override
	public void printAllTickets() {
		int i = 1;
		for(TicketDetail td : ticketsList) {
			System.out.println(i + ". " + td.getUser().getPersonName() + "\t" + td.getUser().getMobileNo() + "\t" + td.getUser().getEmailId() + "\t" + td.getTotalTickets() + "\t" + td.getTotalTicketsPrice());
			System.out.println(i + ". " + td.getShowDetail().getMovieName() + "\t" + td.getShowDetail().getShowDateTime() + "\t" + td.getShowDetail().getTicketPrice());
			i++;
		}
	}

	@Override
	public void printAllShows(List<ShowDetail> showsList) {
		int i = 1;
		for(ShowDetail sd : showsList) {
			System.out.println(i + ". " + sd.getMovieName() + "\t" + sd.getShowDateTime() + "\t" + sd.getTicketPrice());
			i++;
		}
	}

	@Override
	public void addNewShow(ShowDetail showDetail) {
		showsList.add(showDetail);
		System.out.println("Show added successfully");
		System.out.println("Please note your reference number for future purpose: " + showsList.indexOf(showDetail));
		printAllShows(showsList);
	}

	@Override
	public void removeShow(ShowDetail showDetail) {
		showsList.remove(showDetail);
		System.out.println("Show removed successfully");
		printAllShows(showsList);
	}

}
