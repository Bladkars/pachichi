

import java.util.Random;
import javax.swing.*;

public class p3_8 extends JFrame {

    // Variables de control del juego
    private int numeroSecreto;
    private int intentos = 0;

    public p3_8() {
        setTitle("Ejercicio 3.3 - El Número Secreto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Generar número aleatorio entre 1 y 100 al iniciar
        Random random = new Random();
        numeroSecreto = random.nextInt(100) + 1;

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Arriesgar");
        JLabel resultLabel = new JLabel("Adivina el número del 1 al 100 (-1 para rendirte):");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());

                // Condición de rendición
                if (num == -1) {
                    resultLabel.setText("Te has rendido. El número secreto era el: " + numeroSecreto);
                    inputField.setEnabled(false);
                    submitButton.setEnabled(false);
                    return;
                }

                // Validar que esté en el rango si no se está rindiendo
                if (num < 1 || num > 100) {
                    resultLabel.setText("Por favor, introduce un número entre 1 y 100.");
                    return;
                }

                intentos++;

                // Lógica de comparación
                if (num == numeroSecreto) {
                    resultLabel.setText("¡Felicidades! Acertaste en " + intentos + " intentos. Era el " + numeroSecreto + ".");
                    inputField.setEnabled(false);
                    submitButton.setEnabled(false);
                } else if (num < numeroSecreto) {
                    resultLabel.setText("El número secreto es MAYOR que " + num + ". ¡Seguí intentando!");
                } else {
                    resultLabel.setText("El número secreto es MENOR que " + num + ". ¡Seguí intentando!");
                }

                // Limpiar y enfocar el campo para el siguiente intento
                inputField.setText("");
                inputField.requestFocus();

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Tu número:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_8 ejercicio = new p3_8();
            ejercicio.setVisible(true);
        });
    }
}