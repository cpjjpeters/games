package be.ipeters.games.datamodel;




public class DifficultGame {
	private String game;
	private String difficulty;
	private String editor;
	
	public DifficultGame() {
		super();
	}

	public DifficultGame(String game, String difficulty, String editor) {
		super();
		this.game = game;
		this.difficulty = difficulty;
		this.editor = editor;
	}

	@Override
	public String toString() {
		return " [ " + game + ", with difficulty=" + difficulty + ", from " + editor + "]\n";
	}
	
	
}
