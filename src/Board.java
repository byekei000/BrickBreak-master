import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private BrickBreaker brickBreaker;
    private Ball ball;
    private Paddle paddle;
    private Brick[][] bricks = new Brick[3][9];

    public Board(BrickBreaker brickBreaker, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        paddle = new Paddle(150, 25, Color.cyan, this, brickBreaker);
        ball = new Ball(25, Color.cyan, this);
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                bricks[i][j] = new Brick(50, 30, Color.BLUE);
            }
        }
    }

    public void init() {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                bricks[i][j].setPosition(j * 51 + 150, i * 31 + 50);
            }
        }
        paddle.setPosition(getWidth() / 2, getHeight() - 50);
        ball.setPosition(getWidth() / 2, getHeight() / 2);
        timer = new Timer(1000 / 60, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        //paddle
        paddle.paint(g);
        //ball
        ball.paint(g);
        //bricks
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if(bricks[i][j].isAlive())
                    bricks[i][j].paint(g);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        paddle.move();
        ball.move();
//        ball.setPosition(getMousePosition().x, getMousePosition().y);
        ball.checkCollisions(paddle);
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                ball.checkCollisions(bricks[i][j]);
            }
        }
        repaint();
    }
}
