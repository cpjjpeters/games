package be.ipeters.games.datamodel;

public class Borrower {
	private Integer id;
	private String borrowerName;
	private String city;
	
	public Borrower(Integer id, String borrowerName) {
		super();
		this.id = id;
		this.borrowerName = borrowerName;
	}
	
	public Borrower(Integer id, String borrowerName, String city) {
		super();
		this.id = id;
		this.borrowerName = borrowerName;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Borrower [borrowerName=" + borrowerName + ", city=" + city + "]";
	}
	
	
	
}
