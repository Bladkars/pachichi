

import javax.swing.*;

public class p3_4 extends JFrame {

    public p3_4() {
        setTitle("Ejercicio 3.4 - Aprender a Contar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Contar");
        JLabel resultLabel = new JLabel("Ingrese un número n para empezar a contar.");

        submitButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(inputField.getText());

                if (n >= 1) {
                    // Usamos StringBuilder para armar la cadena de texto eficientemente
                    StringBuilder resultado = new StringBuilder("Secuencia: ");
                    
                    for (int i = 1; i <= n; i++) {
                        resultado.append(i);
                        // Añadimos una coma si no es el último número
                        if (i < n) {
                            resultado.append(", ");
                        }
                    }

                    resultLabel.setText(resultado.toString());
                } else {
                    resultLabel.setText("Por favor, ingrese un número mayor o igual a 1.");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número n:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(650, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_4 ejercicio = new p3_4();
            ejercicio.setVisible(true);
        });
    }
}