package rentalcarServer.cars.model;

import java.sql.Timestamp;

public class Cars {
	private int carCode;
	private String carNum;
	private String carAbroad;
	private String carBrand;
	private String carName;
	private String carType;
	private String carSeat;
	private String carOil;
	private int carYear;
	private int carPrice;
	private Timestamp regDate;
	private Timestamp modDate;
	
	public Cars(int carCode, String carNum, String carAbroad, String carBrand, String carName, String carType,
			String carSeat, String carOil, int carYear, int carPrice, Timestamp regDate, Timestamp modDate) {
		super();
		this.carCode = carCode;
		this.carNum = carNum;
		this.carAbroad = carAbroad;
		this.carBrand = carBrand;
		this.carName = carName;
		this.carType = carType;
		this.carSeat = carSeat;
		this.carOil = carOil;
		this.carYear = carYear;
		this.carPrice = carPrice;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getCarCode() {
		return carCode;
	}

	public String getCarNum() {
		return carNum;
	}

	public String getCarAbroad() {
		return carAbroad;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public String getCarName() {
		return carName;
	}

	public String getCarType() {
		return carType;
	}

	public String getCarSeat() {
		return carSeat;
	}

	public String getCarOil() {
		return carOil;
	}

	public int getCarYear() {
		return carYear;
	}

	public int getCarPrice() {
		return carPrice;
	}

	
	
	
}
