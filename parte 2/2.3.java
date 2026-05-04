package ejercicio2_3swing;

import javax.swing.*;

public class Ejercicio2_3Swing extends JFrame {

    public Ejercicio2_3Swing() {
        setTitle("Ejercicio 2.3 - Número mayor (distintos)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton checkButton = new JButton("Determinar Mayor");
        JLabel resultLabel = new JLabel("Introduce dos números distintos");

        checkButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());

                if (num1 == num2) {
                    resultLabel.setText("Error: Los números deben ser distintos.");
                } else if (num1 > num2) {
                    resultLabel.setText("El número mayor es: " + num1);
                } else {
                    resultLabel.setText("El número mayor es: " + num2);
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
        setSize(600, 140);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_3Swing app = new Ejercicio2_3Swing();
            app.setVisible(true);
        });
    }
}