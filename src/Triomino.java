import java.awt.Color;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * A triomino object to be used in Tetris. Composed of 3 blocks.
 *
 * @author Brendan N
 * @version 1.00 2018/03/20
 */
public class Triomino extends Polyomino {
	/** Final ints representing names of triominoes */
	public final int I = 0,  L= 1;
	/**
	 * Logging to replace existing error handling
	 */
	private Logger logger;

	/**
	 * Constructs a new random triomino.<br />
	 * Sets color and starting orientation randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.
	 */
	public Triomino(int x, int y) {
		this(x, y, (int)(Math.random() * 2), (int)(Math.random() * 4));
		logger = Logger.getLogger("Triomino");
	}

	/**
	 * Constructs a new triomino, based on the type.<br />
	 * Sets color randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.<br />
	 * <b>Starts in whichever orientation is stated in the parameter. If out of range 0-3, defaults to {@link #UP}.</b>
	 */
	public Triomino(int x, int y, int type, int orientation) {
		logger = Logger.getLogger("Triomino");

		// set x and y for the shape
		setX(x);
		setY(y);

		// set color for the shape
		setColor(new Color(
				(int)(Math.random() * 256),
				(int)(Math.random() * 256),
				(int)(Math.random() * 256)
		));
		
		// set triomino type & orientations
		setType(type);
		switch (type) {
			case I -> setOrientations(new Block[][]{
				{new Block(0, 1), new Block(1, 1), new Block(2, 1)},
				{new Block(1, 3), new Block(1, 2), new Block(1, 1)},
				{new Block(3, 2), new Block(2, 2), new Block(1, 2)},
				{new Block(2, 0), new Block(2, 1), new Block(2, 2)}
			});
			case L -> setOrientations(new Block[][]{
				{new Block(1, 0), new Block(1, 1), new Block(2, 1)},
				{new Block(1, 0), new Block(1, 1), new Block(0, 1)},
				{new Block(0, 1), new Block(1, 1), new Block(1, 2)},
				{new Block(1, 2), new Block(1, 1), new Block(2, 1)}
			});
		}

		// set starting orientation
		if (orientation >= 0 && orientation < 4) {
			setOrientation(orientation);
		} else {
			setOrientation(UP);
		}
	}
	
	public String getName() {
		String name = getPolyomino();
		switch (getType()) {
			case I -> name += " I";
			case L -> name += " L";
			default -> {
				// this should not happen but is covered
				logger.log(Level.WARNING, "A type couldn't be found for this triomino");
				name = "unknown " + name;
			}
		}
		return name;
	}
	
	public String getPolyomino() {
		return "triomino";
	}
}