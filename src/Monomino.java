import java.awt.Color;

/**
 * A monomino object to be used in Tetris. Composed of 1 block.
 *
 * @author Brendan N
 * @version 2.00 2023/09/10
 */
public class Monomino extends Polyomino {
	/** Final ints representing names of monominoes */
	public final int dot = 0;

	/**
	 * Constructs a new random monomino.<br />
	 * Sets color and starting orientation randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.
	 */
	public Monomino(int x, int y) {
		this(x, y, (int)(Math.random() * 4));
	}

	/**
	 * Constructs a new monomino, based on the type.<br />
	 * Sets color randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.<br />
	 * <b>Starts in whichever orientation is stated in the parameter. If out of range 0-3, defaults to {@link #UP}.</b>
	 */
	public Monomino(int x, int y, int orientation) {
		// set x and y for the shape
		setX(x);
		setY(y);

		// set color for the shape
		setColor(new Color(
				(int)(Math.random() * 256),
				(int)(Math.random() * 256),
				(int)(Math.random() * 256)
		));
		
		// set monomino type & orientations
		setType(dot);
		setOrientations(new Block[][] {
				{new Block(0, 1)},
				{new Block(0, 1)},
				{new Block(0, 1)},
				{new Block(0, 1)}
		});
		
		// set starting orientation
		if (orientation >= 0 && orientation < 4) {
			setOrientation(orientation);
		} else {
			setOrientation(UP);
		}
	}
	
	public String getName() {
		return getPolyomino() + " dot";
	}
	
	public String getPolyomino() {
		return "monomino";
	}
}
