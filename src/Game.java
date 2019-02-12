import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener, ActionListener {
    private Timer timer;
    private Ball ball;
    private Paddle paddle;
    private Brick[] bricks;
    private boolean leftDown = false;
    private boolean rightDown = false;

    public Game(int width, int height) {
        setPreferredSize(new Dimension(width,height));
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(10, this);
        timer.start();
    }

    public void init(){
//        for(int i = 0; i < 3; i++){
//            for(int j = 0; j < 9; j++) {
//                bricks[i*j] = new Brick(25,15,Color.BLUE);
//                bricks[i*j].setPosition(j*10,i*10);
//            }
//        }
        paddle = new Paddle();
        paddle.setPosition(getWidth()/2,getHeight()-50);
        ball = new Ball(10, Color.cyan);
        ball.setPosition(getWidth()/2,getHeight()/2);
    }

    public void paintComponent(Graphics g) {
        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        //paddle
        paddle.paint(g);
        //ball
        ball.paint(g);
        //bricks
//        for(int i = 0; i < bricks.length; i++){
//            bricks[i].paint(g);
//        }
    }

    public void actionPerformed(ActionEvent e) {
        paddle.move();
//        ball.move();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftDown = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightDown = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftDown = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightDown = false;
        }
    }

    public void keyTyped(KeyEvent e) { }
}
