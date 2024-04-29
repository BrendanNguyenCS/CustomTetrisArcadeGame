/**
 * ******** UNUSED ********
 * 
 * 
 * @author Sebastian H and Brendan N
 * @version 1.00 2018/03/12
 */

public class Player {
	/**
	 * The number of points accrued by this player
	 */
	private int points;
	/**
	 * This player's name
	 */
	private final String name;

	/**
	 * Constructor
	 */
	public Player() {
		name = "Unknown";
		points = 0;
	}

	/**
	 * Constructor
	 * @param n the player's name
	 */
	public Player(String n) {
		name = n;
		points = 0;
	}

	/**
	 * The player's score
	 */
    public int getScore() {
		return points;
	}

	public void setScore(int points) {
		this.points = points;
	}

	public void addScore(int amt) {
		points += amt;
	}

	public void resetScore() {
		points = 0;
	}
}
