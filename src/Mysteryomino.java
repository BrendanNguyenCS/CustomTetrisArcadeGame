import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A mysteromino object to be used in Tetris. Composed of 1 block.
 *
 * @author Brendan N
 * @version 2.00 2023/09/10
 */
public class Mysteryomino extends Polyomino implements ActionListener {
	/**
	 * Final ints representing names of mysteromino
	 */
	public final int smiley = 0;

	/**
	 * Constructs a new random mysteromino.<br />
	 * Sets color and starting orientation randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.
	 */
	public Mysteryomino(int x, int y) {
		this(x, y,(int)(Math.random() * 4));
	}

	/**
	 * Constructs a new mysteromino, based on the type.<br />
	 * Sets color randomly, and creates an array of orientations, each composed of 4 {@link Block Blocks}.<br />
	 * <b>Starts in whichever orientation is stated in the parameter. If out of range 0-3, defaults to {@link #UP}.</b>
	 */
	public Mysteryomino(int x, int y, int orientation) {
		Timer timer = new Timer(1000, this);
		timer.start();

		// set x and y for the shape
		setCoordinates(x, y);

		// set color for the shape
		setRandomColor();

		// set mysteromino type & orientations
		setType(smiley);

		setOrientations(new Block[][] {
				{new Block(1, 1), new Block(3, 1), new Block(1, 3), new Block(3, 3),
						new Block(1, 4), new Block(2, 4), new Block(3, 4)},
				{new Block(1, 3), new Block(1, 1), new Block(3, 3), new Block(3, 1),
						new Block(4, 3), new Block(4, 2), new Block(4, 1)},
				{new Block(3, 3), new Block(1, 3), new Block(3, 1), new Block(1, 1),
						new Block(3, 0), new Block(2, 0), new Block(1, 0)},
				{new Block(3, 1), new Block(3, 3), new Block(1, 1), new Block(1, 3),
						new Block(0, 1), new Block(0, 2), new Block(0, 3)}
		});

		// set starting orientation
		setStartingOrientation(orientation);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return getPolyomino() + " smiley";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPolyomino() {
		return "mysteryomino";
	}

	public void actionPerformed(ActionEvent e) {
		setColor(new Color(
				(int)(Math.random() * 256),
				(int)(Math.random() * 256),
				(int)(Math.random() * 256)
		));
	}
}
