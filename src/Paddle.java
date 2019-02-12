import java.awt.*;

public class Paddle {
    private final int WIDTH = 20, HEIGHT = 100;
    private int x,y;
    public Paddle(){
        x = 0;
        y = 0;
    }

    public void move(){
        y-=5;
    }


    public void setPosition(int x, int y){
        this.x = x - WIDTH/2;
        this.y = y - HEIGHT/2;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,WIDTH,HEIGHT);
    }
}
