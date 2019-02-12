import java.awt.*;

public class Ball {
    private int x, y, r, dx = 0, dy = 0;
    private Color color;
    public Ball(int r, Color color){
        this.r = r;
        this.color = color;
    }
    public void move(){
        x+=dx;
        y+=dy;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,r*2,r*2);
    }
    public int getR() {
        return r;
    }
    public int getX() {
        return x+r;
    }
    public int getY() {
        return y+r;
    }
    public void setPosition(int x, int y){
        this.x = x+r;
        this.y = y+r;
    }
}
