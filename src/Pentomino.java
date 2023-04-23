import java.awt.Color;

/**
 * A pentomino object to be used in Tetris. Composed of 5 blocks.
 *
 * @author Sebastian H
 * @version 1.00 2018/03/20
 */
public class Pentomino extends Polyomino {
	/** Final ints representing names of pentominoes */
	public final int F = 0, _7 = 1, I = 2, L = 3, J = 4, N = 5, S = 6, P = 7, Q = 8,
			T = 9, U = 10, V = 11, W = 12, X = 13, Y = 14, _L = 15, Z = 16, _S = 17;

	/**
	 * Constructs a new random pentomino.<br />
	 * Sets color and starting orientation randomly, and creates an array of orientations, each composed of 4 {@link Block}s.
	 */
	public Pentomino(int x, int y) { this(x, y, (int)(Math.random() * 18), (int)(Math.random() * 4)); }

	/**
	 * Constructs a new pentomino, based on the type.<br />
	 * Sets color randomly, and creates an array of orientations, each composed of 4 {@link Block}s.<br />
	 * <b>Starts in whichever orientation is stated in the parameter. If out of range 0-3, defaults to 0 (UP).</b>
	 */
	public Pentomino(int x, int y, int type, int orientation) {
		// set x and y for the shape
		setX(x);
		setY(y);

		// set color for the shape
		setColor(new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256)));
		
		// set pentomino type & orientations
		setType(type);
		switch (type) {
			case F -> setOrientations(new Block[][]{
				{new Block(2, 1), new Block(3, 1), new Block(1, 2), new Block(2, 2), new Block(2, 3)},
				{new Block(1, 2), new Block(1, 1), new Block(2, 3), new Block(2, 2), new Block(3, 2)},
				{new Block(2, 3), new Block(1, 3), new Block(3, 2), new Block(2, 2), new Block(2, 1)},
				{new Block(3, 2), new Block(3, 3), new Block(2, 1), new Block(2, 2), new Block(1, 2)}
			});
			case _7 -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(2, 1), new Block(2, 2), new Block(3, 2), new Block(2, 3)},
				{new Block(1, 3), new Block(1, 2), new Block(2, 2), new Block(2, 1), new Block(3, 2)},
				{new Block(3, 3), new Block(2, 3), new Block(2, 2), new Block(1, 2), new Block(2, 1)},
				{new Block(3, 1), new Block(3, 2), new Block(2, 2), new Block(2, 3), new Block(1, 2)}
			});
			case I -> setOrientations(new Block[][]{
				{new Block(0, 2), new Block(1, 2), new Block(2, 2), new Block(3, 2), new Block(4, 2)},
				{new Block(2, 0), new Block(2, 1), new Block(2, 2), new Block(2, 3), new Block(2, 4)},
				{new Block(0, 2), new Block(1, 2), new Block(2, 2), new Block(3, 2), new Block(4, 2)},
				{new Block(2, 0), new Block(2, 1), new Block(2, 2), new Block(2, 3), new Block(2, 4)}
			});
			case L -> setOrientations(new Block[][]{
				{new Block(2, 0), new Block(2, 1), new Block(2, 2), new Block(2, 3), new Block(3, 3)},
				{new Block(0, 2), new Block(1, 2), new Block(2, 2), new Block(3, 2), new Block(3, 1)},
				{new Block(2, 4), new Block(2, 3), new Block(2, 2), new Block(2, 1), new Block(1, 1)},
				{new Block(4, 2), new Block(3, 2), new Block(2, 2), new Block(1, 2), new Block(1, 3)}
			});
			case J -> setOrientations(new Block[][]{
				{new Block(2, 0), new Block(2, 1), new Block(2, 2), new Block(1, 3), new Block(2, 3)},
				{new Block(0, 2), new Block(1, 2), new Block(2, 2), new Block(3, 3), new Block(3, 2)},
				{new Block(2, 4), new Block(2, 3), new Block(2, 2), new Block(3, 1), new Block(2, 1)},
				{new Block(4, 2), new Block(3, 2), new Block(2, 2), new Block(1, 1), new Block(1, 2)}
			});
			case N -> setOrientations(new Block[][]{
				{new Block(2, 0), new Block(2, 1), new Block(1, 2), new Block(2, 2), new Block(1, 3)},
				{new Block(0, 2), new Block(1, 2), new Block(2, 3), new Block(2, 2), new Block(3, 3)},
				{new Block(2, 4), new Block(2, 3), new Block(3, 2), new Block(2, 2), new Block(3, 1)},
				{new Block(4, 2), new Block(3, 2), new Block(2, 1), new Block(2, 2), new Block(1, 1)}
			});
			case S -> setOrientations(new Block[][]{
				{new Block(2, 0), new Block(2, 1), new Block(2, 2), new Block(3, 2), new Block(3, 3)},
				{new Block(0, 2), new Block(1, 2), new Block(2, 2), new Block(2, 1), new Block(3, 1)},
				{new Block(2, 4), new Block(2, 3), new Block(2, 2), new Block(1, 2), new Block(1, 1)},
				{new Block(4, 2), new Block(3, 2), new Block(2, 2), new Block(2, 3), new Block(1, 3)}
			});
			case P -> setOrientations(new Block[][]{
				{new Block(2, 1), new Block(3, 1), new Block(2, 2), new Block(3, 2), new Block(2, 3)},
				{new Block(1, 2), new Block(1, 1), new Block(2, 2), new Block(2, 1), new Block(3, 2)},
				{new Block(2, 3), new Block(1, 3), new Block(2, 2), new Block(1, 2), new Block(2, 1)},
				{new Block(3, 2), new Block(3, 3), new Block(2, 2), new Block(2, 3), new Block(1, 2)}
			});
			case Q -> setOrientations(new Block[][]{
				{new Block(2, 1), new Block(1, 1), new Block(2, 2), new Block(1, 2), new Block(2, 3)},
				{new Block(1, 2), new Block(1, 3), new Block(2, 2), new Block(2, 3), new Block(3, 2)},
				{new Block(2, 3), new Block(3, 3), new Block(2, 2), new Block(3, 2), new Block(2, 1)},
				{new Block(3, 2), new Block(3, 1), new Block(2, 2), new Block(2, 1), new Block(1, 2)}
			});
			case T -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(2, 1), new Block(3, 1), new Block(2, 2), new Block(2, 3)},
				{new Block(1, 3), new Block(1, 2), new Block(1, 1), new Block(2, 2), new Block(3, 2)},
				{new Block(3, 3), new Block(2, 3), new Block(1, 3), new Block(2, 2), new Block(2, 1)},
				{new Block(3, 1), new Block(3, 2), new Block(3, 3), new Block(2, 2), new Block(1, 2)}
			});
			case U -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(3, 1), new Block(1, 2), new Block(2, 2), new Block(3, 2)},
				{new Block(1, 3), new Block(1, 1), new Block(2, 3), new Block(2, 2), new Block(2, 1)},
				{new Block(3, 3), new Block(1, 3), new Block(3, 2), new Block(2, 2), new Block(1, 2)},
				{new Block(3, 1), new Block(3, 3), new Block(2, 1), new Block(2, 2), new Block(2, 3)}
			});
			case V -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(1, 2), new Block(1, 3), new Block(2, 3), new Block(3, 3)},
				{new Block(1, 3), new Block(2, 3), new Block(3, 3), new Block(3, 2), new Block(3, 1)},
				{new Block(3, 3), new Block(3, 2), new Block(3, 1), new Block(2, 1), new Block(1, 1)},
				{new Block(3, 1), new Block(2, 1), new Block(1, 1), new Block(1, 2), new Block(1, 3)}
			});
			case W -> setOrientations(new Block[][]{
				{new Block(3, 1), new Block(2, 2), new Block(3, 2), new Block(1, 3), new Block(2, 3)},
				{new Block(1, 1), new Block(2, 2), new Block(2, 1), new Block(3, 3), new Block(3, 2)},
				{new Block(1, 3), new Block(2, 2), new Block(1, 2), new Block(3, 1), new Block(2, 1)},
				{new Block(3, 3), new Block(2, 2), new Block(2, 3), new Block(1, 1), new Block(1, 2)}
			});
			case X -> {
				// all orientations are the same (symmetry all around)
				Block[] orientation_X = new Block[]{
						new Block(2, 1),
						new Block(1, 2),
						new Block(2, 2),
						new Block(3, 2),
						new Block(2, 3)
				};
				setOrientations(new Block[][]{orientation_X, orientation_X, orientation_X, orientation_X});
			}
			case Y -> setOrientations(new Block[][]{
				{new Block(2, 1), new Block(0, 2), new Block(1, 2), new Block(2, 2), new Block(3, 2)},
				{new Block(1, 2), new Block(2, 4), new Block(2, 3), new Block(2, 2), new Block(2, 1)},
				{new Block(2, 3), new Block(4, 2), new Block(3, 2), new Block(2, 2), new Block(1, 2)},
				{new Block(3, 2), new Block(2, 0), new Block(2, 1), new Block(2, 2), new Block(2, 3)}
			});
			case _L -> setOrientations(new Block[][]{
				{new Block(2, 1), new Block(4, 2), new Block(1, 2), new Block(2, 2), new Block(3, 2)},
				{new Block(1, 2), new Block(2, 0), new Block(2, 3), new Block(2, 2), new Block(2, 1)},
				{new Block(2, 3), new Block(0, 2), new Block(3, 2), new Block(2, 2), new Block(1, 2)},
				{new Block(3, 2), new Block(2, 4), new Block(2, 1), new Block(2, 2), new Block(2, 3)}
			});
			case Z -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(2, 1), new Block(2, 2), new Block(2, 3), new Block(3, 3)},
				{new Block(1, 3), new Block(1, 2), new Block(2, 2), new Block(3, 2), new Block(3, 1)},
				{new Block(3, 3), new Block(2, 3), new Block(2, 2), new Block(2, 1), new Block(1, 1)},
				{new Block(3, 1), new Block(3, 2), new Block(2, 2), new Block(1, 2), new Block(1, 3)}
			});
			case _S -> setOrientations(new Block[][]{
				{new Block(3, 1), new Block(2, 1), new Block(2, 2), new Block(2, 3), new Block(1, 3)},
				{new Block(1, 1), new Block(1, 2), new Block(2, 2), new Block(3, 2), new Block(3, 3)},
				{new Block(1, 3), new Block(2, 3), new Block(2, 2), new Block(2, 1), new Block(3, 1)},
				{new Block(3, 3), new Block(3, 2), new Block(2, 2), new Block(1, 2), new Block(1, 1)}
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
			case F -> name = "F";
			case _7 -> name = "7";
			case I -> name = "I";
			case L -> name = "L";
			case J -> name = "J";
			case N -> name = "N";
			case S -> name = "S";
			case P -> name = "P";
			case Q -> name = "Q";
			case T -> name = "T";
			case U -> name = "U";
			case V -> name = "V";
			case W -> name = "W";
			case X -> name = "X";
			case Y -> name = "Y";
			case _L -> name = "lambda";
			case Z -> name = "Z";
			case _S -> name = "integral";
			default -> name = "none";
		}
		return name;
	}
	
	public String getPolyomino() { return "pentomino"; }
	
	public String toString() {
		StringBuilder ret = new StringBuilder("Block coordinates of \"");
		ret.append(getName());
		ret.append("\" pentomino (currently oriented ");
		switch (getOrientation()) {
			case UP -> ret.append("upright");
			case LEFT -> ret.append("on its left");
			case DOWN -> ret.append("upside down");
			case RIGHT -> ret.append("on its right");
		}
		ret.append("):\n");
		Block[] pentomino = getShape();
		for (int i = 0; i < pentomino.length; i++) {
			ret.append("(").append(getX() + pentomino[i].getX()).append(", ").append(getY() + pentomino[i].getY()).append(")");
			if (i < pentomino.length - 1)
				ret.append(", ");
		}
		return ret.toString();
	}
}
