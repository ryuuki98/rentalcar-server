package rentalcarServer.cars.model;

public class CarsRequestDto {
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
	public CarsRequestDto() {
	}
	
	public CarsRequestDto(int carCode, String carNum, String carAbroad, String carBrand, String carName, String carType,
			String carSeat, String carOil, int carYear, int carPrice) {
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

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public void setCarAbroad(String carAbroad) {
		this.carAbroad = carAbroad;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public void setCarSeat(String carSeat) {
		this.carSeat = carSeat;
	}

	public void setCarOil(String carOil) {
		this.carOil = carOil;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	
}
