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
    JPanel buttonpanel;

    void registerButton(String text){
        JButton btn = new JButton(text);
        buttonpanel.add(btn);
        btn.addActionListener(this);
    }

    Calculator() {
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        JPanel textpanel = new JPanel();
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
        textpanel.add(tfield);
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new GridLayout(8, 4, 10, 10));
        registerButton("MR");
        registerButton("MC");
        registerButton("M+");
        registerButton("M-");

        registerButton("1");
        registerButton("2");
        registerButton("3");
        registerButton("4");
        registerButton("5");
        registerButton("6");
        registerButton("7");
        registerButton("8");
        registerButton("9");
        registerButton("0");

        registerButton("+");
        registerButton("-");
        registerButton("×");
        registerButton("÷");
        registerButton("+/-");
        registerButton(".");
        registerButton("=");
        registerButton("1/x");
        registerButton("√");
        registerButton("log");
        registerButton("sin");
        registerButton("cos");
        registerButton("tan");
        registerButton("x²");
        registerButton("x³");
        registerButton("ℯ");
        registerButton("n!");
        registerButton("AC");

        cont.add("Center", buttonpanel);
        cont.add("North", textpanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch(s) {
            case "1":
                if (z == 0) {
                    tfield.setText(tfield.getText() + "1");
                } else {
                    tfield.setText("");
                    tfield.setText(tfield.getText() + "1");
                    z = 0;
                }

            case "2":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "2");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "2");
                        z = 0;
                    }

            case "3":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "3");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "3");
                        z = 0;
                    }

            case "4":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "4");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "4");
                        z = 0;
                    }

            case "5":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "5");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "5");
                        z = 0;
                    }

            case "6":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "6");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "6");
                        z = 0;
                    }

            case "7":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "7");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "7");
                        z = 0;
                    }

            case "8":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "8");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "8");
                        z = 0;
                    }

            case "9":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "9");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "9");
                        z = 0;
                    }

            case "0":
                    if (z == 0) {
                        tfield.setText(tfield.getText() + "0");
                    } else {
                        tfield.setText("");
                        tfield.setText(tfield.getText() + "0");
                        z = 0;
                    }

            case "AC":
                    tfield.setText("");
                    x = 0;
                    y = 0;
                    z = 0;

            case "log":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.log(Double.parseDouble(tfield.getText()));
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "1/x":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = 1 / Double.parseDouble(tfield.getText());
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "e":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.exp(Double.parseDouble(tfield.getText()));
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "x²":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.pow(Double.parseDouble(tfield.getText()), 2);
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "x³":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.pow(Double.parseDouble(tfield.getText()), 3);
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "+/-":
                    if (x == 0) {
                        tfield.setText("-" + tfield.getText());
                        x = 1;
                    } else {
                        tfield.setText(tfield.getText());
                    }

            case ".":
                    if (y == 0) {
                        tfield.setText(tfield.getText() + ".");
                        y = 1;
                    } else {
                        tfield.setText(tfield.getText());
                    }

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

            case "MC":
                    m1 = 0;
                    tfield.setText("");

            case "MR":
                    tfield.setText("");
                    tfield.setText(tfield.getText() + m1);

            case "M+":
                    if (k == 1) {
                        m1 = Double.parseDouble(tfield.getText());
                        k++;
                    } else {
                        m1 += Double.parseDouble(tfield.getText());
                        tfield.setText("" + m1);
                    }

            case "M-":
                    if (k == 1) {
                        m1 = Double.parseDouble(tfield.getText());
                        k++;
                    } else {
                        m1 -= Double.parseDouble(tfield.getText());
                        tfield.setText("" + m1);
                    }

            case "√":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.sqrt(Double.parseDouble(tfield.getText()));
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "√z":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.sin(Double.parseDouble(tfield.getText()));
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "cos":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.cos(Double.parseDouble(tfield.getText()));
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

            case "tan":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = Math.tan(Double.parseDouble(tfield.getText()));
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

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

            case "n!":
                    if (tfield.getText().equals("")) {
                        tfield.setText("");
                    } else {
                        a = fact(Double.parseDouble(tfield.getText()));
                        tfield.setText("");
                        tfield.setText(tfield.getText() + a);
                    }

        }
        tfield.requestFocus();
    }

    double fact(double x) {
        if ( x == 1 || x == 0 ) {
            return 1;
        }
        return x * fact(x-1);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Calculator f = new Calculator();
        f.setTitle("Scientific Calculator");
        f.pack();
        f.setVisible(true);
    }
}
