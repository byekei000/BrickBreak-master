import java.awt.*;

public class Paddle {
    private int width = 20, height = 100;
    private int x, y;
    private Color color;
    private Board board;
    private Ball ball;
    private BrickBreaker brickBreaker;

    public Paddle(int width, int height, Color color, Board board, BrickBreaker brickBreaker, Ball ball) {
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
        this.color = color;
        this.board = board;
        this.ball = ball;
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

    public void checkCollisions(PowerUp powerUp) {
        if (getBounds().intersects(powerUp.getBounds())) {
            switch(powerUp.getType()){
                case 1:
                    if(width < board.getWidth()){
                        width += 25; break;
                    }
                case 2:
                    if(width > 50){
                        width -= 25; break;
                    }
                case 3: ball.lowerSpeed(); break;
                case 4: ball.raiseSpeed(); break;
            }
            powerUp = null;
        }
    }

    public boolean checkCollision(PowerUp powerUp) {
        return getBounds().intersects(powerUp.getBounds());
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
