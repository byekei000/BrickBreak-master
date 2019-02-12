import javax.swing.*;

public class BrickBreaker extends JFrame{
    public BrickBreaker(){
        setTitle("Brick Breaker");
        Game game = new Game(800, 600);
        add(game);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.init();
    }
    public static void main(String[] args){
        new BrickBreaker();
    }
}
