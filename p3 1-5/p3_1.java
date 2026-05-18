

import javax.swing.*;

public class p3_1 extends JFrame {

    public p3_1() {
        setTitle("Ejercicio 3.1 - Análisis de Números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Analizar");
        JLabel resultLabel = new JLabel("Introduzca un número (0 para terminar):");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());

                // Condición de parada: si es 0, termina el proceso
                if (num == 0) {
                    resultLabel.setText("Proceso finalizado. Se ha introducido el 0.");
                    inputField.setEnabled(false);   // Deshabilitamos la entrada
                    submitButton.setEnabled(false); // Deshabilitamos el botón
                    return;
                }

                // Determinar si es par o impar
                String paridad = (num % 2 == 0) ? "es PAR" : "es IMPAR";

                // Determinar si es positivo o negativo
                String signo;
                if (num > 0) {
                    signo = "es POSITIVO";
                } else {
                    signo = "es NEGATIVO";
                }

                // Calcular el cuadrado
                int cuadrado = num * num;

                // Mostrar el resultado combinado
                resultLabel.setText("El " + num + " " + paridad + ", " + signo + " y su cuadrado es: " + cuadrado);
                
                // Limpiamos el campo de texto para el próximo número
                inputField.setText("");
                inputField.requestFocus();

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(650, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_1 ejercicio = new p3_1();
            ejercicio.setVisible(true);
        });
    }
}