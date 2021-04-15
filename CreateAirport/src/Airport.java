public class Airport {
	private Integer id;
	private String iataAirportCode;
	private String name;
	private String city;
	private String country;

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airport(Integer id, String iataAirportCode, String name, String city, String country) {
		super();
		this.id = id;
		this.iataAirportCode = iataAirportCode;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	public Airport(String iataAirportCode, String name, String city, String country) {
		super();
		this.iataAirportCode = iataAirportCode;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
