import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICalculator extends JFrame implements ActionListener {

    JTextField display;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    double num1 = 0, num2 = 0;
    char operator;

    GUICalculator() {
        // Frame setup
        this.setTitle("GUI Calculator");
        this.setSize(400, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // Display setup
        display = new JTextField();
        display.setBounds(50, 40, 300, 50);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(display);

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        JButton[] opButtons = {addButton, subButton, mulButton, divButton, eqButton, clrButton};
        for (JButton b : opButtons) {
            b.addActionListener(this);
        }

        // Button layout
        JPanel panel = new JPanel();
        panel.setBounds(50, 120, 300, 350);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': display.setText(String.valueOf(num1 + num2)); break;
                case '-': display.setText(String.valueOf(num1 - num2)); break;
                case '*': display.setText(String.valueOf(num1 * num2)); break;
                case '/':
                    if (num2 != 0)
                        display.setText(String.valueOf(num1 / num2));
                    else
                        display.setText("Error");
                    break;
            }
            num1 = 0;
            num2 = 0;
        }
        if (e.getSource() == clrButton) {
            display.setText("");
            num1 = 0;
            num2 = 0;
        }
    }

    public static void main(String[] args) {
        new GUICalculator();
    }
}
