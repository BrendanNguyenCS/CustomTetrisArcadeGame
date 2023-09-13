import java.awt.Color;
import java.util.logging.Logger;
import java.util.logging.Level;

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
	 * Logging to replace existing error handling
	 */
	private Logger logger;

	/**
	 * Constructs a new random tetromino.<br />
	 * Sets color and starting orientation randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.
	 */
	public Tetromino(int x, int y) {
		this(x, y, (int)(Math.random() * 7), (int)(Math.random() * 4));
		logger = Logger.getLogger("Tetromino");
	}

	/**
	 * Constructs a new tetromino, based on the type.<br />
	 * Sets color randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.<br />
	 * <b>Starts in whichever orientation is stated in the parameter. If out of range 0-3, defaults to 0 (UP).</b> 
	 */
	public Tetromino(int x, int y, int type, int orientation) {
		logger = Logger.getLogger("Tetromino");

		// set x and y for the shape
		setX(x);
		setY(y);
		
		// set color for the shape
		setColor(new Color(
				(int)(Math.random() * 256),
				(int)(Math.random() * 256),
				(int)(Math.random() * 256)
		));
		
		// set tetromino type & orientations
		setType(type);
		switch (type) {
			case I -> setOrientations(new Block[][]{
				{new Block(0, 1), new Block(1, 1), new Block(2, 1), new Block(3, 1)},
				{new Block(1, 3), new Block(1, 2), new Block(1, 1), new Block(1, 0)},
				{new Block(3, 2), new Block(2, 2), new Block(1, 2), new Block(0, 2)},
				{new Block(2, 0), new Block(2, 1), new Block(2, 2), new Block(2, 3)}
			});
			case J -> setOrientations(new Block[][]{
				{new Block(2, 1), new Block(0, 2), new Block(1, 2), new Block(2, 2)},
				{new Block(1, 1), new Block(2, 3), new Block(2, 2), new Block(2, 1)},
				{new Block(1, 2), new Block(3, 1), new Block(2, 1), new Block(1, 1)},
				{new Block(2, 2), new Block(1, 0), new Block(1, 1), new Block(1, 2)}
			});
			case L -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(1, 2), new Block(2, 2), new Block(3, 2)},
				{new Block(1, 2), new Block(2, 2), new Block(2, 1), new Block(2, 0)},
				{new Block(2, 2), new Block(2, 1), new Block(1, 1), new Block(0, 1)},
				{new Block(2, 1), new Block(1, 1), new Block(1, 2), new Block(1, 3)}
			});
			case O -> {
				// all orientations are the same (symmetry all around)
				Block[] orientation_O = new Block[]{
						new Block(1, 1),
						new Block(2, 1),
						new Block(1, 2),
						new Block(2, 2)
				};
				setOrientations(new Block[][]{orientation_O, orientation_O, orientation_O, orientation_O});
			}
			case S -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(2, 1), new Block(0, 2), new Block(1, 2)},
				{new Block(1, 2), new Block(1, 1), new Block(2, 3), new Block(2, 2)},
				{new Block(2, 2), new Block(1, 2), new Block(3, 1), new Block(2, 1)},
				{new Block(2, 1), new Block(2, 2), new Block(1, 0), new Block(1, 1)}
			});
			case T -> setOrientations(new Block[][]{
				{new Block(1, 1), new Block(0, 2), new Block(1, 2), new Block(2, 2)},
				{new Block(1, 2), new Block(2, 3), new Block(2, 2), new Block(2, 1)},
				{new Block(2, 2), new Block(3, 1), new Block(2, 1), new Block(1, 1)},
				{new Block(2, 1), new Block(1, 0), new Block(1, 1), new Block(1, 2)}
			});
			case Z -> setOrientations(new Block[][]{
				{new Block(0, 1), new Block(1, 1), new Block(1, 2), new Block(2, 2)},
				{new Block(1, 3), new Block(1, 2), new Block(2, 2), new Block(2, 1)},
				{new Block(3, 2), new Block(2, 2), new Block(2, 1), new Block(1, 1)},
				{new Block(2, 0), new Block(2, 1), new Block(1, 1), new Block(1, 2)}
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
			case J -> name += " J";
			case L -> name += " L";
			case O -> name += " O";
			case S -> name += " S";
			case T -> name += " T";
			case Z -> name += " Z";
			default -> {
				// this should not happen but is covered
				logger.log(Level.WARNING, "A type couldn't be found for this tetromino");
				name = "unknown " + name;
			}
		}
		return name;
	}
	
	public String getPolyomino() {
		return "tetromino";
	}
}
