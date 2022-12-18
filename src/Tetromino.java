import java.awt.Color;

/**
 * A tetromino object to be used in Tetris. Composed of 4 blocks.
 *
 * @author Sebastian H and Brendan N
 * @version 2.00 2018/03/20
 */
public class Tetromino extends Polyomino {
	/** Final ints representing names of tetrominoes */
	public final int I = 0,  J = 1, L = 2, O = 3, S = 4, T = 5, Z = 6;

	/**
	 * Constructs a new random tetromino.<br />
	 * Sets color and starting orientation randomly, and creates an array of orientations, each composed of 4 <code>Block</code>s.
	 */
	public Tetromino(int x, int y) { this(x, y, (int)(Math.random()*7), (int)(Math.random()*4)); }
	/**
	 * Constructs a new tetromino, based on the type.<br />
	 * Sets color randomly, and creates an array of orientations, each composed of 4 <code>Block</code>s.<br />
	 * <b>Starts in whichever orientation is stated in the parameter. If out of range 0-3, defaults to 0 (UP).</b> 
	 */
	public Tetromino(int x, int y, int type, int orientation) {
		// set x and y for the shape
		setX(x);
		setY(y);
		
		// set color for the shape
		setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
		
		// set tetromino type & orientations
		setType(type);
		if (type == I) {
			setOrientations(new Block[][] {
				{new Block(0,1), new Block(1,1), new Block(2,1), new Block(3,1)},
				{new Block(1,3), new Block(1,2), new Block(1,1), new Block(1,0)},
				{new Block(3,2), new Block(2,2), new Block(1,2), new Block(0,2)},
				{new Block(2,0), new Block(2,1), new Block(2,2), new Block(2,3)}
			});
		}
		else if (type == J) {
			setOrientations(new Block[][] {
				{new Block(2,1), new Block(0,2), new Block(1,2), new Block(2,2)},
				{new Block(1,1), new Block(2,3), new Block(2,2), new Block(2,1)},
				{new Block(1,2), new Block(3,1), new Block(2,1), new Block(1,1)},
				{new Block(2,2), new Block(1,0), new Block(1,1), new Block(1,2)}
			});
		}
		else if (type == L) {
			setOrientations(new Block[][] {
				{new Block(1,1), new Block(1,2), new Block(2,2), new Block(3,2)},
				{new Block(1,2), new Block(2,2), new Block(2,1), new Block(2,0)},
				{new Block(2,2), new Block(2,1), new Block(1,1), new Block(0,1)},
				{new Block(2,1), new Block(1,1), new Block(1,2), new Block(1,3)}
			});
		}
		else if (type == O) {
			// all orientations are the same (symmetry all around)
			Block[] orientation_O = new Block[] {
					new Block(1,1),
					new Block(2,1),
					new Block(1,2),
					new Block(2,2)
			};
			setOrientations(new Block[][] {orientation_O, orientation_O, orientation_O, orientation_O});
		}
		else if (type == S) {
			setOrientations(new Block[][] {
				{new Block(1,1), new Block(2,1), new Block(0,2), new Block(1,2)},
				{new Block(1,2), new Block(1,1), new Block(2,3), new Block(2,2)},
				{new Block(2,2), new Block(1,2), new Block(3,1), new Block(2,1)},
				{new Block(2,1), new Block(2,2), new Block(1,0), new Block(1,1)}
			});
		}
		else if (type == T) {
			setOrientations(new Block[][] {
				{new Block(1,1), new Block(0,2), new Block(1,2), new Block(2,2)},
				{new Block(1,2), new Block(2,3), new Block(2,2), new Block(2,1)},
				{new Block(2,2), new Block(3,1), new Block(2,1), new Block(1,1)},
				{new Block(2,1), new Block(1,0), new Block(1,1), new Block(1,2)}
			});
		}
		else if (type == Z) {
			setOrientations(new Block[][] {
				{new Block(0,1), new Block(1,1), new Block(1,2), new Block(2,2)},
				{new Block(1,3), new Block(1,2), new Block(2,2), new Block(2,1)},
				{new Block(3,2), new Block(2,2), new Block(2,1), new Block(1,1)},
				{new Block(2,0), new Block(2,1), new Block(1,1), new Block(1,2)}
			});
		}
		
		// set starting orientation
		if (orientation >= 0 && orientation < 4)
			setOrientation(orientation);
		else
			setOrientation(UP);
	}
	
	public String getName() {
		String name;
		switch (getType()) {
			case I -> name = "I";
			case J -> name = "J";
			case L -> name = "L";
			case O -> name = "O";
			case S -> name = "S";
			case T -> name = "T";
			case Z -> name = "Z";
			default -> name = "none";
		}
		return name;
	}
	
	public String getPolyomino() { return "tetromino"; }
	
	public String toString() {
		StringBuilder ret = new StringBuilder("Block coordinates of \"");
		ret.append(getName());
		ret.append("\" tetromino (currently oriented ");
		switch (getOrientation()) {
			case UP -> ret.append("upright");
			case LEFT -> ret.append("on its left");
			case DOWN -> ret.append("upside down");
			case RIGHT -> ret.append("on its right");
		}
		ret.append("):\n");
		Block[] tetromino = getShape();
		for (int i = 0; i < tetromino.length; i++) {
			ret.append("(").append(getX() + tetromino[i].getX()).append(", ").append(getY() + tetromino[i].getY()).append(")");
			if (i < tetromino.length - 1)
				ret.append(", ");
		}
		return ret.toString();
	}
}
