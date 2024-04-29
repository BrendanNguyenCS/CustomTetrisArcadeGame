import java.awt.Color;

/**
 * A domino object to be used in Tetris. Composed of 4 blocks.
 *
 * @author Brendan N
 * @version 2.00 2023/09/10
 */
public class Domino extends Polyomino {
	/** Final ints representing names of dominoes */
	public final int domino = 0;

	/**
	 * Constructs a new random domino.<br />
	 * Sets color and starting orientation randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.
	 */
	public Domino(int x, int y) {
		this(x, y, (int)(Math.random() * 4));
	}

	/**
	 * Constructs a new domino, based on the type.<br />
	 * Sets color randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.<br />
	 * <b>Starts in whichever orientation is stated in the parameter. If out of range 0-3, defaults to {@link #UP}.</b>
	 */
	public Domino(int x, int y, int orientation) {
		// set x and y for the shape
		setX(x);
		setY(y);

		// set color for the shape
		setRandomColor();
		
		// set domino type & orientations
		setType(domino);
		setOrientations(new Block[][] {
			{new Block(0, 0), new Block(1, 0)},
			{new Block(0, 0), new Block(0, 1)},
			{new Block(0, 1), new Block(1, 1)},
			{new Block(1, 0), new Block(1, 1)}
		});
		
		// set starting orientation
		setStartingOrientation(orientation);
	}

	/**
	 * Returns the name of the domino.
	 */
	public String getName() {
		return getPolyomino();
	}

	/**
	 * Returns the name of the domino.
	 */
	public String getPolyomino() {
		return "domino";
	}
}
