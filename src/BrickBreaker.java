import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BrickBreaker extends JFrame implements KeyListener {
    private Board board;
    private boolean leftPressed, rightPressed;
    public BrickBreaker() {
        setResizable(false);
        setVisible(true);
        setFocusable(true);
        setTitle("Pong");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board = new Board(this, 800, 600);
        add(board);
        addKeyListener(this);
        pack();
        setLocationRelativeTo(null);
        board.init();
    }

    public static void main(String[] args) {
        new BrickBreaker();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
