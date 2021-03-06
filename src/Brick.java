import java.awt.*;

public class Brick {
    private int x, y, width, height;
    private boolean alive = true;
    private Color color;

    public Brick(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle(x, y, 1, height);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle(x + width-2, y, 1, height);
    }

    public Rectangle getBoundsBottom() {
        return new Rectangle(x, y + height-2, width, 1);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle(x, y-2, width, 1);
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Color getColor() {
        return color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
