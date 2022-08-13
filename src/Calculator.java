import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField tfield;
    double temp, temp1, result, a;
    static double m1;
    int k = 1, x = 0, y = 0, z = 0;
    char ch;
    Container cont;
    JPanel buttonPanel;

    void addBtn(String text){
        JButton btn = new JButton(text);
        buttonPanel.add(btn);
        btn.addActionListener(this);
    }

    void handleNumber(String num){
        if (z == 0) {
            tfield.setText(tfield.getText() + num);
        } else {
            tfield.setText("");
            tfield.setText(tfield.getText() + num);
            z = 0;
        }
    }

    void handleFraction(double a){
        if (tfield.getText().equals("")) {
            tfield.setText("");
        } else {
            tfield.setText("");
            tfield.setText(tfield.getText() + a);
        }
    }

    double fact(double x) {
        if ( x == 1 || x == 0 ) {
            return 1;
        }
        return x * fact(x-1);
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
                if (!(c >= '0' && c <= '9')){
                    keyevent.consume();
                }
            }
        });
        textPanel.add(tfield);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 4, 10, 10));
        addBtn("MR");
        addBtn("MC");
        addBtn("M+");
        addBtn("M-");

        addBtn("1");
        addBtn("2");
        addBtn("3");
        addBtn("4");
        addBtn("5");
        addBtn("6");
        addBtn("7");
        addBtn("8");
        addBtn("9");
        addBtn("0");

        addBtn("+");
        addBtn("-");
        addBtn("×");
        addBtn("÷");
        addBtn("+/-");
        addBtn(".");
        addBtn("=");
        addBtn("1/x");
        addBtn("√");
        addBtn("log");
        addBtn("sin");
        addBtn("cos");
        addBtn("tan");
        addBtn("x²");
        addBtn("x³");
        addBtn("ℯ");
        addBtn("n!");
        addBtn("AC");

        cont.add("Center", buttonPanel);
        cont.add("North", textPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch(s) {
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
                a = Math.log(Double.parseDouble(tfield.getText()));
                handleFraction(a);
                break;
            case "1/x":
                a = 1 / Double.parseDouble(tfield.getText());
                handleFraction(a);
                break;
            case "ℯ":
                a = Math.exp(Double.parseDouble(tfield.getText()));
                handleFraction(a);
                break;
            case "x²":
                a = Math.pow(Double.parseDouble(tfield.getText()), 2);
                handleFraction(a);
                break;
            case "x³":
                a = Math.pow(Double.parseDouble(tfield.getText()), 3);
                handleFraction(a);
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
                if (tfield.getText().equals("")) {
                    tfield.setText("");
                    temp = 0;
                    ch = '+';
                } else {
                    temp = Double.parseDouble(tfield.getText());
                    tfield.setText("");
                    ch = '+';
                    y = 0;
                    x = 0;
                }
                tfield.requestFocus();
                break;
            case "-":
                if (tfield.getText().equals("")) {
                    tfield.setText("");
                    temp = 0;
                    ch = '-';
                } else {
                    x = 0;
                    y = 0;
                    temp = Double.parseDouble(tfield.getText());
                    tfield.setText("");
                    ch = '-';
                }
                tfield.requestFocus();
                break;
            case "÷":
                if (tfield.getText().equals("")) {
                    tfield.setText("");
                    temp = 1;
                    ch = '/';
                } else {
                    x = 0;
                    y = 0;
                    temp = Double.parseDouble(tfield.getText());
                    ch = '/';
                    tfield.setText("");
                }
                tfield.requestFocus();
                break;
            case "×":
                if (tfield.getText().equals("")) {
                    tfield.setText("");
                    temp = 1;
                    ch = '*';
                } else {
                    x = 0;
                    y = 0;
                    temp = Double.parseDouble(tfield.getText());
                    ch = '*';
                    tfield.setText("");
                }
                tfield.requestFocus();
                break;
            case "MC":
                m1 = 0;
                tfield.setText("");
                break;
            case "MR":
                tfield.setText("");
                tfield.setText(tfield.getText() + m1);
                break;
            case "M+":
                if (k == 1) {
                    m1 = Double.parseDouble(tfield.getText());
                    k++;
                } else {
                    m1 += Double.parseDouble(tfield.getText());
                    tfield.setText("" + m1);
                }
                break;
            case "M-":
                if (k == 1) {
                    m1 = Double.parseDouble(tfield.getText());
                    k++;
                } else {
                    m1 -= Double.parseDouble(tfield.getText());
                    tfield.setText("" + m1);
                }
                break;
            case "√":
                a = Math.sqrt(Double.parseDouble(tfield.getText()));
                handleFraction(a);
                break;
            case "sin":
                a = Math.sin(Double.parseDouble(tfield.getText()));
                handleFraction(a);
                break;
            case "cos":
                a = Math.cos(Double.parseDouble(tfield.getText()));
                handleFraction(a);
                break;
            case "tan":
                a = Math.tan(Double.parseDouble(tfield.getText()));
                handleFraction(a);
                break;
            case "=":
                if (tfield.getText().equals("")) {
                    tfield.setText("");
                } else {
                    temp1 = Double.parseDouble(tfield.getText());
                    switch (ch) {
                        case '+' -> result = temp + temp1;
                        case '-' -> result = temp - temp1;
                        case '/' -> result = temp / temp1;
                        case '*' -> result = temp * temp1;
                    }
                    tfield.setText("");
                    tfield.setText(tfield.getText() + result);
                    z = 1;
                }
                break;
            case "n!":
                a = fact(Double.parseDouble(tfield.getText()));
                handleFraction(a);
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
