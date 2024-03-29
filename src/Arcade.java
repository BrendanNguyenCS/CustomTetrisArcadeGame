import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Arcade extends JFrame {
  public Arcade() {
    super("AP Java Arcade");

    JavaArcade game = new TetrisBoard(TetrisBoard.L * TetrisBoard.COLUMNS, 450);
    // Passing in a JavaArcade, therefore I know I can call getHighScore(), getScore()
    GameStats display = new GameStats(game);
    // Also passing in JavaArcade to ControlPanel, I know you will respond to buttons
    ControlPanel controls = new ControlPanel(game, display);

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBorder(new EmptyBorder(0, 5, 0, 5));
    panel.add(display, BorderLayout.NORTH);
    panel.add((JPanel)game, BorderLayout.CENTER);
    panel.add(controls, BorderLayout.SOUTH);

    Container c = getContentPane();
    c.add(panel, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    Arcade window = new Arcade();
    window.setBounds(100, 100,
                     TetrisBoard.L * TetrisBoard.COLUMNS + 30,
                     TetrisBoard.L * TetrisBoard.ROWS + 160
    );
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}
