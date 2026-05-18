

import javax.swing.*;

public class p3_7 extends JFrame {

    public p3_7() {
        setTitle("Ejercicio 3.7 - Producto de Impares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton submitButton = new JButton("Calcular Producto");
        JLabel resultLabel = new JLabel("Presione el botón para calcular el producto de los 10 primeros impares.");

        submitButton.addActionListener(e -> {
            long producto = 1;
            int contadorImpares = 0;
            int numeroActual = 1;

            // Buscamos y multiplicamos los primeros 10 números impares
            while (contadorImpares < 10) {
                if (numeroActual % 2 != 0) {
                    producto *= numeroActual;
                    contadorImpares++;
                }
                numeroActual++;
            }

            resultLabel.setText("El producto de los 10 primeros números impares es: " + producto);
        });

        JPanel panel = new JPanel();
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_7 ejercicio = new p3_7();
            ejercicio.setVisible(true);
        });
    }
}