


import javax.swing.*;

public class p3_8 extends JFrame {

    public p3_8() {
        setTitle("Ejercicio 3.8 - Calcular Factorial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Ingrese un número entero no negativo:");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());

                // Validamos que el número no sea negativo
                if (num < 0) {
                    resultLabel.setText("Por favor, ingrese un número mayor o igual a 0.");
                    return;
                }

                long factorial = 1;
                // El factorial de 0 y 1 es 1. Para números mayores, calculamos el producto
                for (int i = num; i > 1; i--) {
                    factorial *= i;
                }

                resultLabel.setText("El factorial de " + num + " (" + num + "!) es: " + factorial);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número:"));
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