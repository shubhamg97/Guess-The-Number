package guessthenumber;

import javax.swing.JFrame;

public class GTNTest {
    public static void main(String[] args) {
        GuessTheNumber labelFrame = new GuessTheNumber();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(500, 200);
        labelFrame.setVisible(true);
    }
    
}
