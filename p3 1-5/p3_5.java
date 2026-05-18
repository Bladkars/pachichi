

import javax.swing.*;

public class p3_5 extends JFrame {

    // Variables para almacenar los límites del rango
    private int minimo;
    private int maximo;
    private boolean rangoConfigurado = false;

    public p3_5() {
        setTitle("Ejercicio 3.5 - Validación de Rango");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField minField = new JTextField(4);
        JTextField maxField = new JTextField(4);
        JTextField numField = new JTextField(4);
        
        JButton configurarButton = new JButton("Fijar Rango");
        JButton validarButton = new JButton("Validar Número");
        
        JLabel resultLabel = new JLabel("Defina los valores mínimo y máximo primero.");

        // El campo numérico y su botón empiezan desactivados hasta tener el rango
        numField.setEnabled(false);
        validarButton.setEnabled(false);

        // Acción 1: Configurar los límites del rango
        configurarButton.addActionListener(e -> {
            try {
                minimo = Integer.parseInt(minField.getText());
                maximo = Integer.parseInt(maxField.getText());

                if (minimo > maximo) {
                    resultLabel.setText("Error: El mínimo no puede ser mayor que el máximo.");
                    return;
                }

                rangoConfigurado = true;
                resultLabel.setText("Rango fijado [" + minimo + " a " + maximo + "]. Ingrese un número dentro del rango:");
                
                // Bloqueamos el rango y habilitamos la entrada del número a evaluar
                minField.setEnabled(false);
                maxField.setEnabled(false);
                configurarButton.setEnabled(false);
                
                numField.setEnabled(true);
                validarButton.setEnabled(true);
                numField.requestFocus();

            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Ingrese números enteros válidos para el rango.");
            }
        });

        // Acción 2: Validar reiteradamente el número introducido
        validarButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(numField.getText());

                // Verificamos si pertenece al rango
                if (num >= minimo && num <= maximo) {
                    resultLabel.setText("¡Correcto! El número " + num + " pertenece al rango [" + minimo + " a " + maximo + "].");
                    // Finalizamos el proceso desactivando las entradas
                    numField.setEnabled(false);
                    validarButton.setEnabled(false);
                } else {
                    resultLabel.setText("El número " + num + " NO está en el rango. Intente con otro valor:");
                    numField.setText("");
                    numField.requestFocus();
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca un número entero.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Mín:"));
        panel.add(minField);
        panel.add(new JLabel("Máx:"));
        panel.add(maxField);
        panel.add(configurarButton);
        panel.add(new java.awt.Component() {}); // Separador visual implícito
        panel.add(new JLabel("Número:"));
        panel.add(numField);
        panel.add(validarButton);
        panel.add(resultLabel);

        add(panel);
        setSize(750, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_5 ejercicio = new p3_5();
            ejercicio.setVisible(true);
        });
    }
}