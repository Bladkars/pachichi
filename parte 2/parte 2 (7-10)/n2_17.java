

import javax.swing.*;

public class n2_17 extends JFrame {

    public n2_17() {
        setTitle("Ejercicio 2.17 - Control de Alimento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField comidaField = new JTextField(5);
        JTextField animalesField = new JTextField(5);
        JTextField kilosField = new JTextField(5);
        
        JButton submitButton = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Ingrese los datos de la granja.");

        submitButton.addActionListener(e -> {
            try {
                double comidaDiaria = Double.parseDouble(comidaField.getText());
                int numAnimales = Integer.parseInt(animalesField.getText());
                double kilosPorAnimal = Double.parseDouble(kilosField.getText());

                // Validación para evitar división por cero o datos incoherentes
                if (numAnimales <= 0) {
                    resultLabel.setText("Error: El número de animales debe ser mayor a 0.");
                    return;
                }
                
                if (comidaDiaria < 0 || kilosPorAnimal < 0) {
                    resultLabel.setText("Error: Las cantidades no pueden ser negativas.");
                    return;
                }

                // Calculamos cuánta comida se necesita en total
                double comidaNecesaria = numAnimales * kilosPorAnimal;

                if (comidaDiaria >= comidaNecesaria) {
                    resultLabel.setText("¡Suficiente! Hay alimento para todos los animales.");
                } else {
                    // Calculamos la ración real que le corresponde a cada uno
                    double racionReal = comidaDiaria / numAnimales;
                    resultLabel.setText(String.format("Alimento insuficiente. Ración ajustada por animal: %.2f kg.", racionReal));
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Comida Diaria (kg):"));
        panel.add(comidaField);
        panel.add(new JLabel("Nº Animales:"));
        panel.add(animalesField);
        panel.add(new JLabel("Kg por Animal:"));
        panel.add(kilosField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(750, 110);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            n2_17 ejercicio = new n2_17();
            ejercicio.setVisible(true);
        });
    }
}