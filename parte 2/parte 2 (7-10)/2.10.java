package ejercicio2_10swing;

import javax.swing.*;

public class Ejercicio2_10Swing extends JFrame {

    public Ejercicio2_10Swing() {
        setTitle("Ejercicio 2.10 - Número Capicúa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton checkButton = new JButton("Verificar");
        JLabel resultLabel = new JLabel("Introduce un número entre 0 y 9.999");

        checkButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());

                if (num < 0 || num > 9999) {
                    resultLabel.setText("Número fuera de rango (0-9.999).");
                    return;
                }

                String str = String.valueOf(num);
                String invertido = new StringBuilder(str).reverse().toString();

                if (str.equals(invertido)) {
                    resultLabel.setText("El número " + num + " es CAPICÚA.");
                } else {
                    resultLabel.setText("El número " + num + " NO es capicúa.");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número: "));
        panel.add(inputField);
        panel.add(checkButton);
        panel.add(resultLabel);

        add(panel);
        setSize(550, 130);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_10Swing app = new Ejercicio2_10Swing();
            app.setVisible(true);
        });
    }
}