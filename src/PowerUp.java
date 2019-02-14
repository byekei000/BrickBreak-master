import java.awt.*;

public class PowerUp {
    private int width = 20, height = 100;
    private int x, y;
    private int type;
    private Color color;

    public PowerUp(Brick brick) {
        x = brick.getX()+brick.getWidth();
        y = brick.getY()+brick.getHeight();
        this.width = 10;
        this.height = 10;
        int rand = (int)(Math.random()*4);
        switch(rand){
            case 0: this.color = Color.green; type = 1; break;
            case 1: this.color = Color.red; type = 2; break;
            case 2: this.color = Color.blue; type = 3; break;
            case 3: this.color = Color.yellow; type = 4; break;
        }
    }

    public void move() {
        y+=3;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getType() {
        return type;
    }

    public int getY() {
        return y;
    }
}
