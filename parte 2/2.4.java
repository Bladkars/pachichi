package ejercicio2_4swing;

import javax.swing.*;

public class Ejercicio2_4Swing extends JFrame {

    public Ejercicio2_4Swing() {
        setTitle("Ejercicio 2.4 - Número mayor (incluye igualdad)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField1 = new JTextField(10);
        JTextField inputField2 = new JTextField(10);
        JButton checkButton = new JButton("Determinar Mayor");
        JLabel resultLabel = new JLabel("Introduce dos números");

        checkButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());

                if (num1 > num2) {
                    resultLabel.setText("El número mayor es: " + num1);
                } else if (num2 > num1) {
                    resultLabel.setText("El número mayor es: " + num2);
                } else {
                    resultLabel.setText("Los números son IGUALES: " + num1);
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
            Ejercicio2_4Swing app = new Ejercicio2_4Swing();
            app.setVisible(true);
        });
    }
}