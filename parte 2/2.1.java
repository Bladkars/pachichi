package ejercicio2_1swing;

import javax.swing.*;

public class Ejercicio2_1Swing extends JFrame {

    public Ejercicio2_1Swing() {
        setTitle("Ejercicio 2.1 - Par o Impar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton checkButton = new JButton("Verificar");
        JLabel resultLabel = new JLabel("Introduce un número y presiona Verificar");

        checkButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                if (num % 2 == 0) {
                    resultLabel.setText("El número " + num + " es PAR.");
                } else {
                    resultLabel.setText("El número " + num + " es IMPAR.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un número: "));
        panel.add(inputField);
        panel.add(checkButton);
        panel.add(resultLabel);

        add(panel);
        setSize(500, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_1Swing app = new Ejercicio2_1Swing();
            app.setVisible(true);
        });
    }
}