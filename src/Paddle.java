import java.awt.*;

public class Paddle {
    private int width = 20, height = 100;
    private int x, y;
    private Color color;
    private Board board;
    private BrickBreaker brickBreaker;

    public Paddle(int width, int height, Color color, Board board, BrickBreaker brickBreaker) {
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
        this.color = color;
        this.board = board;
        this.brickBreaker = brickBreaker;
    }

    public void move() {
        if(brickBreaker.isLeftPressed() && x > 0){
            x-=5;
        }
        if(brickBreaker.isRightPressed() && x+width < board.getWidth()){
            x+=5;
        }
    }


    public void setPosition(int x, int y) {
        this.x = x - width / 2;
        this.y = y - height / 2;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
