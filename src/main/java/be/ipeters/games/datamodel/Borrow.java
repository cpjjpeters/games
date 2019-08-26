package be.ipeters.games.datamodel;

import java.time.LocalDate;

import lombok.Data;

public @Data class Borrow {
	private Integer id;
	private Integer gameId;
	private Integer borrowerId;
	private LocalDate borrowDate;
	private LocalDate returnDate;
	
}
