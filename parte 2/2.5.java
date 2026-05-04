package ejercicio2_5swing;

import javax.swing.*;

public class Ejercicio2_5Swing extends JFrame {

    public Ejercicio2_5Swing() {
        setTitle("Ejercicio 2.5 - Número casi-cero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton checkButton = new JButton("Verificar");
        JLabel resultLabel = new JLabel("Introduce un número decimal");

        checkButton.addActionListener(e -> {
            try {
                double num = Double.parseDouble(inputField.getText());

                if (num != 0 && Math.abs(num) < 1) {
                    resultLabel.setText("El número " + num + " es CASI-CERO.");
                } else {
                    resultLabel.setText("El número " + num + " NO es casi-cero.");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número: "));
        panel.add(inputField);
        panel.add(checkButton);
        panel.add(resultLabel);

        add(panel);
        setSize(500, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_5Swing app = new Ejercicio2_5Swing();
            app.setVisible(true);
        });
    }
}