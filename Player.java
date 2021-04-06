/* *
 * ******** UNUSED ********
 * 
 * 
 * @author Sebastian H and Brendan N
 * @version 1.00 2018/03/12
 * /

public class Player
{
	
	private int points;
	private String name;
	
	public Player() {
		name = "Unknown";
		points = 0;
	}

	public Player(String n)
	{
		name = n;
		points = 0;
	}
	
	public void setScore(int points) {this.points = points;}
	
	public int getScore() {return points;}
	
	public void addScore(int amt) {points += amt;}
	
	public void resetScore() {points = 0;}
	
	

}
*/