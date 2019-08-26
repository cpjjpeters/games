package be.ipeters.games.datamodel;

import java.time.LocalDate;
import java.util.Date;

public class BorrowListObject {
	private Integer id;
	private String game;
	private String borrower;
	private Date borrowDate;
	private Date returnDate;

	public BorrowListObject(Integer id, String game, String borrower, Date borrowDate, Date returnDate) {
		super();
		this.id = id;
		this.game = game;
		this.borrower = borrower;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "[ game=" + game + ", \t\tis borrowed by " + borrower + ", \tfrom " + borrowDate + ", \treturnDate="
				+ returnDate + "]";
	}

}
