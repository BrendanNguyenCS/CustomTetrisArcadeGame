/**
 * Simple coordinates (unaffliated w/ GUI positioning), used for positions on a 4x4 grid.
 * x is horizontal, y is vertical (downward +y for consistency w/GUI use)
 *
 * @author Sebastian H
 * @version 1.00 2018/03/10
 */
public class Block {
	/**
	 * Position of the top left corner of the {@link Block} on the {@link Polyomino} canvas
	 */
	private int x, y;

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * X coordinate of the top left corner of the {@link Block} on the {@link Polyomino} canvas
	 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Y coordinate of the top left corner of the {@link Block} on the {@link Polyomino} canvas
	 */
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Shift the X coordinate of the top left corner
	 *
	 * @param deltaX the amount to shift the X coordinate by
	 */
	public void changeX(int deltaX) {
		x += deltaX;
	}

	/**
	 * Shift the Y coordinate of the top left corner
	 *
	 * @param deltaY the amount to shift the Y coordinate by
	 */
	public void changeY(int deltaY) {
		y += deltaY;
	}

	/**
	 * @return the position of the top left corner of this {@link Block} in the form of (x, y)
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
