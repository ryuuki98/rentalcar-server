package rentalcarServer.reservations.model;

import java.sql.Timestamp;

public class ReservationsResponseDto {
	private int reservationNum;
	private String userId;
	private int carCode;
	private int carPrice;
	private Timestamp borrowDate;
	private Timestamp returnDate;
	private String status;
	public ReservationsResponseDto(int reservationNum, String userId, int carCode, int carPrice, Timestamp borrowDate,
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
	public int getReservationNum() {
		return reservationNum;
	}
	public String getUserId() {
		return userId;
	}
	public int getCarCode() {
		return carCode;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public Timestamp getBorrowDate() {
		return borrowDate;
	}
	public Timestamp getReturnDate() {
		return returnDate;
	}
	public String getStatus() {
		return status;
	}
	public void setReservationNum(int reservationNum) {
		this.reservationNum = reservationNum;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}
	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
