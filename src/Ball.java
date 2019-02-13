import java.awt.*;

public class Ball {
    private int x, y, r, dx = 3, dy = -3;
    private Color color;
    private Board board;

    public Ball(int r, Color color, Board board) {
        this.r = r;
        this.color = color;
        this.board = board;
    }

    public void move() {
        if (y < 0 || y + r*2 > board.getHeight()) {
            dy *= -1;
        }
        if (x < 0 || x + r*2 > board.getWidth()) {
            dx *= -1;
        }
        x += dx;
        y += dy;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, r * 2, r * 2);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, r*2, r*2);
    }

    public void checkCollisions(Paddle paddle) {
        if (getBounds().intersects(paddle.getBounds())) {
            dy *= -1;
        }
    }

    public void checkCollisions(Brick brick) {
        if(brick.isAlive() && getBounds().intersects(brick.getBounds())){
            if(x-r >= brick.getX() && x+r <= brick.getX()+brick.getWidth() && y <= brick.getY()+brick.getHeight() && y >= brick.getY()+brick.getHeight()+dy){
                dy = -dy;
            } else if(x-r >= brick.getX() && x+r <= brick.getX()+brick.getWidth() && y+r*2 >= brick.getY() && y+r*2 <= brick.getY()-dy){
                dy = -dy;
            } else if(x >= brick.getX() && x <= brick.getX()+brick.getWidth() && y <= brick.getY()+brick.getHeight() && y >= brick.getY()+brick.getHeight()+dy){
                dy = -dy;
            }
            brick.setAlive(false);
        }
    }

    public int getR() {
        return r;
    }

    public int getX() {
        return x + r;
    }

    public int getY() {
        return y + r;
    }

    public void setPosition(int x, int y) {
        this.x = x - r;
        this.y = y - r;
    }
}
