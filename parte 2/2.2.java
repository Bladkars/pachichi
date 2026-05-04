package ejercicio2_2swing;

import javax.swing.*;

public class Ejercicio2_2Swing extends JFrame {

    public Ejercicio2_2Swing() {
        setTitle("Ejercicio 2.2 - Comparar números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton checkButton = new JButton("Comparar");
        JLabel resultLabel = new JLabel("Introduce dos números y presiona Comparar");

        checkButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());

                if (num1 == num2) {
                    resultLabel.setText("Los números son IGUALES.");
                } else {
                    resultLabel.setText("Los números son DIFERENTES.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número 1: "));
        panel.add(inputField1);
        panel.add(new JLabel("Número 2: "));
        panel.add(inputField2);
        panel.add(checkButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 130);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_2Swing app = new Ejercicio2_2Swing();
            app.setVisible(true);
        });
    }
}