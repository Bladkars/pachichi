package ejercicio2_9swing;

import javax.swing.*;

public class Ejercicio2_9Swing extends JFrame {

    public Ejercicio2_9Swing() {
        setTitle("Ejercicio 2.9 - Contar cifras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton countButton = new JButton("Contar cifras");
        JLabel resultLabel = new JLabel("Introduce un número entre 0 y 99.999");

        countButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());

                if (num < 0 || num > 99999) {
                    resultLabel.setText("Número fuera de rango (0-99.999).");
                    return;
                }

                int cifras;

                if (num < 10) {
                    cifras = 1;
                } else if (num < 100) {
                    cifras = 2;
                } else if (num < 1000) {
                    cifras = 3;
                } else if (num < 10000) {
                    cifras = 4;
                } else {
                    cifras = 5;
                }

                resultLabel.setText("El número " + num + " tiene " + cifras + " cifra(s).");

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número: "));
        panel.add(inputField);
        panel.add(countButton);
        panel.add(resultLabel);

        add(panel);
        setSize(550, 130);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_9Swing app = new Ejercicio2_9Swing();
            app.setVisible(true);
        });
    }
}