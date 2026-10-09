
import java.awt.*;
import java.awt.event.*;

class q7 extends Frame implements ActionListener {

    TextField display;
    Button plus, minus, multiply, divide;
    Button b1, b2, b3, b4, b5, b6;
    Button b7, b8, b9, b0, dot, clear, equal;

    String expression = "";

    q7() {
        setTitle("Calculator");
        setSize(400, 465);
        setLayout(null);
        setBackground(Color.BLUE);

        display = new TextField();
        display.setBounds(55, 75, 290, 42);
        display.setFont(new Font("Arial", Font.PLAIN, 20));
        add(display);

        plus = new Button("+");
        minus = new Button("-");
        multiply = new Button("*");
        divide = new Button("/");

        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b0 = new Button("0");
        dot = new Button(".");
        clear = new Button("C");
        equal = new Button("=");

        Button[] buttons = {
                plus, b1, b2, b3,
                minus, b4, b5, b6,
                multiply, b7, b8, b9,
                divide, dot, b0, clear
        };

        int x = 15, y = 130;

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(x, y, 85, 48);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            buttons[i].addActionListener(this);
            add(buttons[i]);

            x += 95;

            if ((i + 1) % 4 == 0) {
                x = 15;
                y += 60;
            }
        }

        equal.setBounds(155, 370, 90, 48);
        equal.setFont(new Font("Arial", Font.BOLD, 20));
        equal.addActionListener(this);
        add(equal);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("C")) {
            expression = "";
            display.setText("");
        }
        else if (s.equals("=")) {
            try {
                double result = calculate(expression);
                display.setText(expression + "=" + result);
                expression = String.valueOf(result);
            }
            catch (Exception ex) {
                display.setText("Invalid Expression");
                expression = "";
            }
        }
        else {
            expression += s;
            display.setText(expression);
        }
    }

    double calculate(String exp) {
        String[] parts = exp.split("[+\\-*/]");

        if (parts.length != 2)
            throw new IllegalArgumentException();

        double a = Double.parseDouble(parts[0]);
        double b = Double.parseDouble(parts[1]);

        if (exp.contains("+"))
            return a + b;
        else if (exp.contains("-"))
            return a - b;
        else if (exp.contains("*"))
            return a * b;
        else if (exp.contains("/")) {
            if (b == 0)
                throw new ArithmeticException();
            return a / b;
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        new q7();
    }
}



