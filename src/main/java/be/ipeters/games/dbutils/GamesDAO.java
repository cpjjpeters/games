package be.ipeters.games.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.ipeters.games.datamodel.*;
import com.mysql.cj.protocol.Resultset;


public class GamesDAO {
	private Connection con;
	private boolean found;

	public ArrayList<BorrowListObject> findAllBorrowedGames() {
		ArrayList<BorrowListObject> blos = new ArrayList<BorrowListObject>(); // ArrayList for all borrowed info
		BorrowListObject blo = null;
		Connection con = ConnectionsManager.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(DBQueries.FIND_ALL_BORROWED_GAMES);
			while (result.next()) {
				blo = new BorrowListObject(result.getInt("id"), result.getString("game_name"),
						result.getString("borrower_name"), result.getDate("borrow_date"),
						result.getDate("return_date"));
				blos.add(blo);
			}
			return blos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blos;
	}

	public ArrayList<BorrowListObject> findAllBorrowedGamesPerBorrower(int id) {
		ArrayList<BorrowListObject> blos = new ArrayList<BorrowListObject>(); // ArrayList for all borrowed info
		BorrowListObject blo = null;
		try {
			Connection con = ConnectionsManager.getConnection();
			PreparedStatement prepStat = con.prepareStatement(DBQueries.FIND_ALL_BORROWED_GAMES_PER_BORROWER);
			prepStat.setInt(1, id);
			System.out.println(prepStat);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				blo = new BorrowListObject(result.getInt("id"), result.getString("game_name"),
						result.getString("borrower_name"), result.getDate("borrow_date"),
						result.getDate("return_date"));
				blos.add(blo);
			}
			return blos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blos;
	}

	public ArrayList<BorrowListObject> findAllBorrowedGamesSortedOnGame() {
		ArrayList<BorrowListObject> blos = new ArrayList<BorrowListObject>(); // ArrayList for all borrowed info
		BorrowListObject blo = null;
		Connection con = ConnectionsManager.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(DBQueries.FIND_ALL_BORROWED_GAMES_SORTED_ON_GAME);
			while (result.next()) {
				blo = new BorrowListObject(result.getInt("id"), result.getString("game_name"),
						result.getString("borrower_name"), result.getDate("borrow_date"),
						result.getDate("return_date"));
				blos.add(blo);
			}
			return blos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blos;
	}

	public ArrayList<BorrowListObject> findAllBorrowedGamesSortedOnBorrower() {
		ArrayList<BorrowListObject> blos = new ArrayList<BorrowListObject>(); // ArrayList for all borrowed info
		BorrowListObject blo = null;
		Connection con = ConnectionsManager.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(DBQueries.FIND_ALL_BORROWED_GAMES_SORTED_ON_BORROWER);
			while (result.next()) {
				blo = new BorrowListObject(result.getInt("id"), result.getString("game_name"),
						result.getString("borrower_name"), result.getDate("borrow_date"),
						result.getDate("return_date"));
				blos.add(blo);
			}
			return blos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blos;
	}

	public ArrayList<Game> findAllGames() {
		Game game = null;
		Statement stmt = null;
		ArrayList<Game> games = new ArrayList<Game>(); // Create an ArrayList object to store all games
		try {
			Connection con = ConnectionsManager.getConnection();
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(DBQueries.FIND_ALL_GAMES);
			while (result.next()) {
				game = new Game(result.getString("game_name"), result.getString("author"), result.getDouble("price"));
				games.add(game);
			}
			return games;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return games;
	}

	public ArrayList<DifficultGame> selectDifficultyGames(Integer level) {
		ArrayList<DifficultGame> difgames = new ArrayList<DifficultGame>();
		DifficultGame dgm = null;
		try {
			Connection con = ConnectionsManager.getConnection();
			PreparedStatement prepStat;
			prepStat = con.prepareStatement(DBQueries.SELECT_DIFFICULTY_GAMES);
			prepStat.setInt(1, level);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				dgm = new DifficultGame(result.getString("game_name"), result.getString("difficulty_name"),
						result.getString("editor"));
				difgames.add(dgm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return difgames;
	}

	public Borrower findBorrowerById(Integer id) {
		Borrower borrower = null;
		try {
			Connection con = ConnectionsManager.getConnection();
			PreparedStatement prepStat = con.prepareStatement(DBQueries.FIND_BORROWER_BY_ID);
			prepStat.setInt(1, id);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				borrower = new Borrower(result.getInt("id"), result.getString("borrower_name"), result.getString("city") // description
				);
			}
			return borrower;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return borrower;

	}

	public Borrower findBorrowerByName(String borName) {
		Borrower borrower = null;
		try {
			Connection con = ConnectionsManager.getConnection();
			PreparedStatement prepStat = con.prepareStatement(DBQueries.LOOK_FOR_A_BORROWER);
			prepStat.setString(1, "%" + borName + "%");
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				borrower = new Borrower(result.getInt("id"), result.getString("borrower_name"), result.getString("city") // description
				);
			}
			if (borrower == null) {
				System.out.println("No borrower was found with parameter " + borName);
			} else {
				return borrower;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return borrower;

	}

	public Category findCategoryById(Integer id) {
		Category category = null;
		try {
			Connection con = ConnectionsManager.getConnection();
			PreparedStatement prepStat = con.prepareStatement(DBQueries.FIND_CATEGORY_BY_ID);
			prepStat.setInt(1, id);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				category = new Category(result.getInt("id"), result.getString("category_name") // description
				);
			}
			return category;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return category;
	}

	public Game findGameById(Integer id) {
		Game game = null;
		try {
			Connection con = ConnectionsManager.getConnection();
			PreparedStatement prepStat = con.prepareStatement(DBQueries.FIND_GAME_BY_ID);
			prepStat.setInt(1, id);
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				game = new Game(result.getInt("id"), result.getString("game_name") // description
				);
			}
			return game;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return game;
	}

	public Game lookForAGame(String lookForAGame) {
		Game game = null;
		Connection con = ConnectionsManager.getConnection();

		try {
			PreparedStatement prepStat = con.prepareStatement(DBQueries.LOOK_FOR_A_GAME);
			prepStat.setString(1, "%" + lookForAGame + "%");
			ResultSet result = prepStat.executeQuery();
			while (result.next()) {
				game = new Game(result.getInt("id"), result.getString("game_name"), result.getString("editor"),
						result.getString("author"), result.getInt("year_edition"), result.getString("age"),
						result.getInt("min_players"), result.getInt("max_players"), "category_name",
						result.getString("play_duration"), "difficulty_name", result.getDouble("price") // description
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}

	public Game lookForASpecificGameForItem6(String lookForAGame) {
		Game game = null;
		String lookForASpecificGame = DBQueries.LOOK_FOR_A_SPECIFIC_GAME;
		Connection con = ConnectionsManager.getConnection();

		try {
			PreparedStatement prepStat = con.prepareStatement(lookForASpecificGame);
			prepStat.setString(1, lookForAGame + "%");
			System.out.println(prepStat);
			ResultSet result = prepStat.executeQuery();
			found = false;
			while (result.next()) {
				found = true;
				game = new Game(result.getInt("id"), result.getString("game_name"));
				System.out.println(game.toSmallString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (found) {
			findAllDetailsGameById(game.getId());
		}
		return game;
	}

	public Game findAllDetailsGameById(Integer id) {
		Game game = null;
		try {
			Connection con = ConnectionsManager.getConnection();
			PreparedStatement ps = con.prepareStatement(DBQueries.FIND_ALL_DETAILS_GAME_BY_ID);

			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				game = new Game(result.getInt("id"), result.getString("game_name"), result.getString("editor"),
						result.getString("author"), result.getInt("year_edition"), result.getString("age"),
						result.getInt("min_players"), result.getInt("max_players"), result.getString("category_name"),
						result.getString("play_duration"), result.getString("difficulty_name"),
						result.getDouble("price") // description
				);
			}
			return game;
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			this.closeConnection();
		}
		return game;
	}

	public void closeConnection() {

		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
