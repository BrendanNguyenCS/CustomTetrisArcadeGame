import java.awt.Color;

/**
 * A polyomino object to be used in Tetris+. Concrete children are composed of n blocks.
 *
 * @author Sebastian H and Brendan N
 * @version 1.00 2018/03/20
 */
public abstract class Polyomino {
	/**
	 * Position of the top left corner of the {@link Polyomino} canvas on the {@link TetrisBoard}<br />
	 * (in {@link TetrisBoard#L} units, not pixels)
	 */
	private int x, y;
	/**
	 * Integers representing current orientation of the polyomino<br/>
	 * (UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3)
	 */
	private int currentOrientation;
	public final int UP = 0;
	public final int LEFT = 1;
	public final int DOWN = 2;
	public final int RIGHT = 3;
	/**
	 * 2D {@link Block} array (4*n) that holds the 4 orientations ({@link #UP}, {@link #LEFT}, {@link #DOWN},
	 * {@link #RIGHT}) for this polyomino. "Orientations" themselves are the polyomino {@link Block Blocks} put together.
	 */
	private Block[][] allOrientations;
	/**
	 * Integer representing the type of polyomino
	 */
	private int type;
	/**
	 * The color of this Polyomino
	 */
	private Color color;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void moveLeft() {
		x--;
	}

	public void moveRight() {
		x++;
	}

	public void moveUp() {
		y--;
	}

	public void moveDown() {
		y++;
	}

	/**
	 * Rotates the polyomino counterclockwise (left).<br />Changes {@link #currentOrientation} accordingly.
	 * If orientation increases past {@link #RIGHT}, reset to {@link #UP}.
	 */
	public void rotateCCW() {
		currentOrientation = currentOrientation >= 3 ? UP : --currentOrientation;
	}

	/**
	 * Rotates the polyomino clockwise (right).<br />Changes {@link #currentOrientation} accordingly.
	 * If orientation decreases past {@link #UP}, reset to {@link #RIGHT}.
	 */
	public void rotateCW() {
		currentOrientation = currentOrientation <= 0 ? RIGHT : --currentOrientation;
	}

	/**
	 * X coordinate of the top left corner of the {@link Tetromino} canvas on the {@link TetrisBoard}
	 */
	public int getX() {
		return x;
	}

	/**
	 * Y coordinate of the top left corner of the {@link Tetromino} canvas on the {@link TetrisBoard}
	 */
	public int getY() {
		return y;
	}

	/**
	 * Integer representing current orientation of the polyomino<br/>
	 */
	public int getOrientation() {
		return currentOrientation;
	}

	public void setOrientation(int n) {
		currentOrientation = n;
	}

	/**
	 * Array of {@link Block Blocks}
	 * in the current orientation of this {@link Tetromino}.<br />
	 * (4 items in the array)
	 */
	public Block[] getShape() {
		return allOrientations[currentOrientation];
	}

	/**
	 * 2D {@link Block} array (4x4) that holds the 4 orientations for this polyomino.
	 * "Orientations" themselves are 4 polyomino {@link Block Blocks} put together.
	 */
	public Block[][] getOrientations() {
		return allOrientations;
	}

	public void setOrientations(Block[][] o) {
		allOrientations = o;
	}

	/**
	 * String w/ the name of the specific polyomino shape
	 */
	public abstract String getName();

	/**
	 * String w/ the type of polyomino (domino, pentomino, etc)
	 */
	public abstract String getPolyomino();

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setType(int n) {
		type = n;
	}

	public int getType() {
		return type;
	}

	/**
	 * The string representation of this object.
	 * @return the name and type of the object, its coordinates, its orientation, and the coordinates of all
	 * {@link Block Blocks} that make up the object.
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder("Block coordinates of ");
		ret.append(getName());
		ret.append(" (currently oriented ");
		switch (getOrientation()) {
			case UP -> ret.append("upright");
			case LEFT -> ret.append("on its left");
			case DOWN -> ret.append("upside down");
			case RIGHT -> ret.append("on its right");
		}
		ret.append("):\n");
		Block[] blocks = getShape();
		for (int i = 0; i < blocks.length; i++) {
			ret.append("(")
					.append(getX() + blocks[i].getX())
					.append(", ")
					.append(getY() + blocks[i].getY())
					.append(")");
			if (i < blocks.length - 1) {
				ret.append(", ");
			}
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		Polyomino[] minos = new Polyomino[] {
			new Monomino(4, 9),
			new Domino(7, 8),
			new Triomino(2, 0),
			new Tetromino(1, 5),
			new Pentomino(3, 6)
		};
		for (Polyomino p : minos) {
			System.out.println(p);
		}
	}
}