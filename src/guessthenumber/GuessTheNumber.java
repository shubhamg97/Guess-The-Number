package guessthenumber;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.Random;

public class GuessTheNumber extends JFrame {
    
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel higher;
    private final JLabel lower;
    private final JTextField textField;
    private final JButton button;
    private int number;
    private int guess;
    private int oldGuess;
    
    public GuessTheNumber() {
        super("Guess the Number");
        setLayout(new FlowLayout());
        
        label1 = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        label2 = new JLabel("Please enter your first guess.");
        add(label1);
        add(label2);
        
        higher = new JLabel("");
        lower = new JLabel("");
        add(higher);
        add(lower);
    
    textField = new JTextField(10);
    add(textField);
    
    TextFieldHandler handler = new TextFieldHandler();
    textField.addActionListener(handler);
   
    button = new JButton("Play Again");
    add(button);
    
    ButtonHandler handler2 = new ButtonHandler();
    button.addActionListener(handler2);
    
    Random rand = new Random();
    number = rand.nextInt(1000) + 1;
    System.out.println(number); // Shows the current random number. Only there to help me while writing the code.
    }
    
    private class TextFieldHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            oldGuess = guess;
            guess = Integer.parseInt(textField.getText());
            
            if(guess == number) {
                label1.setText("Correct!");
                label2.setVisible(false);
                getContentPane().setBackground(null);
                textField.setEditable(false);
                
            }
            if (guess > number) {
                label1.setText("Too high");
                label2.setVisible(false);
            }
            else if (guess < number) {
                label1.setText("Too low");
                label2.setVisible(false);
              }
            
            if ((guess > number) && (oldGuess < guess)) {
                getContentPane().setBackground(Color.CYAN);
                textField.setEditable(true);
            }
            if ((guess > number) && (oldGuess > guess)) {
                getContentPane().setBackground(Color.RED);
                textField.setEditable(true);
            }
            if ((guess < number) && (oldGuess > guess)) {
                getContentPane().setBackground(Color.CYAN);
                textField.setEditable(true);
            }
            if ((guess < number) && (oldGuess < guess)) {
                getContentPane().setBackground(Color.RED);
                textField.setEditable(true);
            }
        }
    }
    
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            
            Random rn = new Random();
            number = rn.nextInt(1000) + 1;
            label1.setText("I have a number between 1 and 1000. Can you guess my number?");
            label2.setVisible(true);
            textField.setEditable(true);
            getContentPane().setBackground(null);
            System.out.println(number); // Shows the current random number. Only there to help me while writing the code.
            }
    }
}
    
