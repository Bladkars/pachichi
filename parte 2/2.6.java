package ejercicio2_6swing;

import javax.swing.*;

public class Ejercicio2_6Swing extends JFrame {

    public Ejercicio2_6Swing() {
        setTitle("Ejercicio 2.6 - Orden decreciente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton orderButton = new JButton("Ordenar");
        JLabel resultLabel = new JLabel("Introduce dos números");

        orderButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());

                if (num1 > num2) {
                    resultLabel.setText("Orden decreciente: " + num1 + " , " + num2);
                } else if (num2 > num1) {
                    resultLabel.setText("Orden decreciente: " + num2 + " , " + num1);
                } else {
                    resultLabel.setText("Los números son iguales: " + num1 + " , " + num2);
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
        panel.add(orderButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 140);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_6Swing app = new Ejercicio2_6Swing();
            app.setVisible(true);
        });
    }
}