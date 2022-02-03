import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Capstone extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel calculatorTab;
    private JPanel notepadTab;
    private JTextField textField;
    private JButton num2;
    private JButton num3;
    private JButton add;
    private JButton cle;
    private JButton mul;
    private JButton min;
    private JButton num6;
    private JButton num5;
    private JButton num9;
    private JButton del;
    private JButton num8;
    private JButton neg;
    private JButton num7;
    private JButton num4;
    private JButton div;
    private JTextField calculatorTextField;
    private JButton num1;
    private JButton dec;
    private JButton num0;
    private JButton equ;
    private JTextArea textArea1;

    double temp1, temp2, result;
    char operator;

    public Capstone(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        // makes it impossible to type in the textfield. maybe add the ability to use numpad??
        textField.setEditable(false);

        num1.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(1))));
        num2.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(2))));
        num3.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(3))));
        num4.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(4))));
        num5.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(5))));
        num6.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(6))));
        num7.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(7))));
        num8.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(8))));
        num9.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(9))));
        num0.addActionListener(e -> textField.setText(textField.getText().concat(Integer.toString(0))));
        dec.addActionListener(e -> textField.setText(textField.getText().concat(".")));
        add.addActionListener(e -> {
            temp1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        });
        min.addActionListener(e -> {
            temp1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        });
        mul.addActionListener(e -> {
            temp1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        });
        div.addActionListener(e -> {
            temp1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        });
        equ.addActionListener(e -> {
            temp2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = temp1 + temp2;
                case '-' -> result = temp1 - temp2;
                case '*' -> result = temp1 * temp2;
                case '/' -> result = temp1 / temp2;
            }
            textField.setText(Double.toString(result));
            temp1 = result;
        });
        cle.addActionListener(e -> textField.setText(""));
        del.addActionListener(e -> {
            String str = textField.getText();
            textField.setText("");
            for(int i = 0; i < str.length()-1; i++) {
                textField.setText(textField.getText()+str.charAt(i));
            }
        });
        neg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(Double.toString(temp));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Capstone("Captsone");
        frame.setVisible(true);
        frame.setSize(800,800);
    }
}
