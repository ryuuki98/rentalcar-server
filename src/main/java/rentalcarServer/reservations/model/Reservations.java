package rentalcarServer.reservations.model;

import java.sql.Timestamp;

public class Reservations {
	private int reservationNum;
	private String userId;
	private int carCode;
	private int carPrice;
	private Timestamp borrowDate;
	private Timestamp returnDate;
	private String status;
	public Reservations(int reservationNum, String userId, int carCode, int carPrice, Timestamp borrowDate,
			Timestamp returnDate, String status) {
		super();
		this.reservationNum = reservationNum;
		this.userId = userId;
		this.carCode = carCode;
		this.carPrice = carPrice;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
	}
	
}
