import java.awt.*;

public class Ball {
    private int x, y, r, speed = 3, dx = speed, dy = -speed;
    private Color color;
    private Board board;

    public Ball(int r, Color color, Board board) {
        this.r = r;
        this.color = color;
        this.board = board;
    }

    public void move() {
        if (y < 0 || y + r * 2 > board.getHeight()) {
            dy *= -1;
        }
        if (x < 0 || x + r * 2 > board.getWidth()) {
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
        return new Rectangle(x, y, r * 2, r * 2);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle(x, y, speed, r * 2);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle(x + r * 2 - speed, y, speed, r * 2);
    }

    public Rectangle getBoundsBottom() {
        return new Rectangle(x, y + r * 2 - speed, r * 2, speed);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle(x, y, r * 2, speed);
    }

    public void checkCollisions(Paddle paddle) {
        if (getBounds().intersects(paddle.getBounds())) {
            dy *= -1;
        }
    }

    public boolean checkCollision(Brick brick) {
        if (brick.isAlive() && getBounds().intersects(brick.getBounds())) {
            if (getBoundsLeft().intersects(brick.getBoundsRight())) {
                return true;
            } else if (getBoundsRight().intersects(brick.getBoundsLeft())) {
                return true;
            } else if(getBoundsTop().intersects(brick.getBoundsBottom())){
                return true;
            } else return getBoundsBottom().intersects(brick.getBoundsTop());
        }
        return false;
    }

    public void checkCollisions(Brick brick) {
        if (brick.isAlive() && getBounds().intersects(brick.getBounds())) {
            if (getBoundsLeft().intersects(brick.getBoundsRight())) {
                dx = -dx;
                brick.setAlive(false);
            } else if (getBoundsRight().intersects(brick.getBoundsLeft())) {
                dx = -dx;
                brick.setAlive(false);
            } else if(getBoundsTop().intersects(brick.getBoundsBottom())){
                dy = -dy;
                brick.setAlive(false);
            } else if(getBoundsBottom().intersects(brick.getBoundsTop())){
                dy = -dy;
                brick.setAlive(false);
            }
        }
    }

    public void setPosition(int x, int y) {
        this.x = x - r;
        this.y = y - r;
    }

    public void lowerSpeed() {
        if(speed > 1){
            speed = speed-=1;
            if(dx >= 0){
                dx -=1;
            } else dx+=1;
            if(dy >= 0){
                dy-=1;
            }else dy+=1;
        }
    }

    public void raiseSpeed() {
        speed = speed+=1;
        if(dx <= 0){
            dx -=1;
        } else dx+=1;
        if(dy <= 0){
            dy-=1;
        }else dy+=1;
    }
}
