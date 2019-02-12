import java.awt.*;

public class Brick {
    private int x,y,width,height;
    private boolean alive = true;
    private Color color;
    public Brick(int width, int height, Color color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width, height);
    }
    public void setPosition(int x, int y){
        this.x = x+width/2;
        this.y = y+height/2;
    }
}
