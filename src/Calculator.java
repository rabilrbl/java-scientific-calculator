import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    final JTextField tfield;
    double temp, temp1, result;
    int x = 0, y = 0, z = 0;
    char ch;
    final Container cont;
    final JPanel buttonPanel;

    void registerBottons(String[] buttons) {
        for(String text: buttons){
            JButton btn = new JButton(text);
            buttonPanel.add(btn);
            btn.addActionListener(this);   
        }
    }

    void handleNumber(String num) {
        if (z == 0) {
            tfield.setText(tfield.getText() + num);
        } else {
            tfield.setText("");
            tfield.setText(tfield.getText() + num);
            z = 0;
        }
    }

    void handleFraction(double a) {
        if (tfield.getText().equals("")) {
            tfield.setText("");
        } else {
            tfield.setText("");
            tfield.setText(tfield.getText() + a);
        }
    }

    void handleOp(char op, double ans){
        if (tfield.getText().equals("")) {
            tfield.setText("");
            temp = (op == '/' || op == '*') ? 1 : 0;
        } else {
            temp = ans;
            tfield.setText("");
            y = 0;
            x = 0;
        }
        ch = op;
        tfield.requestFocus();
    }

    double fact(double x) {
        if (x == 1 || x == 0) {
            return 1;
        }
        return x * fact(x - 1);
    }

    Calculator() {
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        JPanel textPanel = new JPanel();
        tfield = new JTextField(25);
        tfield.setHorizontalAlignment(SwingConstants.RIGHT);
        tfield.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent keyevent) {
                char c = keyevent.getKeyChar();
                if (!(c >= '0' && c <= '9')) {
                    keyevent.consume();
                }
            }
        });
        textPanel.add(tfield);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 4, 5, 5));

        String[] buttons = {"sin","cos","tan","x²","x³","ℯ","n!","AC",
                "1","2","3","4","5","6","7","8","9","0",
                "+","-","×","÷",
                "+/-",".","=",
                "1/x","√","log"};
        registerBottons(buttons);
        cont.add("Center", buttonPanel);
        cont.add("North", textPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                handleNumber(s);
                break;
            case "AC":
                tfield.setText("");
                x = 0;
                y = 0;
                z = 0;
                break;
            case "log":
                temp = Math.log(Double.parseDouble(tfield.getText()));
                handleFraction(temp);
                break;
            case "1/x":
                temp = 1 / Double.parseDouble(tfield.getText());
                handleFraction(temp);
                break;
            case "ℯ":
                temp = Math.exp(Double.parseDouble(tfield.getText()));
                handleFraction(temp);
                break;
            case "x²":
                temp = Math.pow(Double.parseDouble(tfield.getText()), 2);
                handleFraction(temp);
                break;
            case "x³":
                temp = Math.pow(Double.parseDouble(tfield.getText()), 3);
                handleFraction(temp);
                break;
            case "+/-":
                if (x == 0) {
                    tfield.setText("-" + tfield.getText());
                    x = 1;
                } else {
                    tfield.setText(tfield.getText());
                }
                break;
            case ".":
                if (y == 0) {
                    tfield.setText(tfield.getText() + ".");
                    y = 1;
                } else {
                    tfield.setText(tfield.getText());
                }
                break;
            case "+":
            case "-":
            case "÷":
            case "×":
                temp = Double.parseDouble(tfield.getText());
                handleOp(s.charAt(0), temp);
                break;
            case "√":
                temp = Math.sqrt(Double.parseDouble(tfield.getText()));
                handleFraction(temp);
                break;
            case "sin":
                temp = Math.sin(Double.parseDouble(tfield.getText()));
                handleFraction(temp);
                break;
            case "cos":
                temp = Math.cos(Double.parseDouble(tfield.getText()));
                handleFraction(temp);
                break;
            case "tan":
                temp = Math.tan(Double.parseDouble(tfield.getText()));
                handleFraction(temp);
                break;
            case "=":
                if (tfield.getText().equals("")) {
                    tfield.setText("");
                } else {
                    temp1 = Double.parseDouble(tfield.getText());
                    switch (ch) {
                        case '+' -> result = temp + temp1;
                        case '-' -> result = temp - temp1;
                        case '÷' -> result = temp / temp1;
                        case '×' -> result = temp * temp1;
                    }
                    tfield.setText("");
                    tfield.setText(tfield.getText() + result);
                    z = 1;
                }
                break;
            case "n!":
                temp = fact(Double.parseDouble(tfield.getText()));
                handleFraction(temp);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }
        tfield.requestFocus();
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setTitle("Scientific Calculator"); // Window title
        calc.pack();
        calc.setVisible(true); // Make window visible
    }
}
