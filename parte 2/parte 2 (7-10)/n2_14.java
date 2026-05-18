

import javax.swing.*;

public class n2_14 extends JFrame {

    public n2_14() {
        setTitle("Ejercicio 2.14 - Día Siguiente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField diaField = new JTextField(4);
        JTextField mesField = new JTextField(4);
        JTextField anioField = new JTextField(4);
        
        JButton submitButton = new JButton("Día Siguiente");
        JLabel resultLabel = new JLabel("Ingrese una fecha.");

        submitButton.addActionListener(e -> {
            try {
                int dia = Integer.parseInt(diaField.getText());
                int mes = Integer.parseInt(mesField.getText());
                int anio = Integer.parseInt(anioField.getText());

                // 1. Primero determinamos cuántos días tiene el mes ingresado
                int diasDelMes = 0;

                if (mes >= 1 && mes <= 12 && anio > 0) {
                    switch (mes) {
                        case 2:
                            diasDelMes = 28; // Asumimos año no bisiesto estándar
                            break;
                        case 4: case 6: case 9: case 11:
                            diasDelMes = 30;
                            break;
                        default:
                            diasDelMes = 31;
                            break;
                    }

                    // 2. Validamos si el día ingresado es correcto para ese mes
                    if (dia >= 1 && dia <= diasDelMes) {
                        
                        // Incrementamos el día
                        dia++;

                        // 3. Controlamos el desborde de días (cambio de mes)
                        if (dia > diasDelMes) {
                            dia = 1;
                            mes++;

                            // 4. Controlamos el desborde de meses (cambio de año)
                            if (mes > 12) {
                                mes = 1;
                                anio++;
                            }
                        }

                        resultLabel.setText("El día siguiente es: " + dia + "/" + mes + "/" + anio);
                    } else {
                        resultLabel.setText("Día inválido para el mes ingresado.");
                    }
                } else {
                    resultLabel.setText("Fecha inválida. Verifique los rangos.");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Día:"));
        panel.add(diaField);
        panel.add(new JLabel("Mes:"));
        panel.add(mesField);
        panel.add(new JLabel("Año:"));
        panel.add(anioField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            n2_14 ejercicio = new n2_14();
            ejercicio.setVisible(true);
        });
    }
}