

import javax.swing.*;

public class n2_12 extends JFrame {

    public n2_12() {
        setTitle("Ejercicio 2.12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField diaField = new JTextField(4);
        JTextField mesField = new JTextField(4);
        JTextField anioField = new JTextField(4);
        
        JButton submitButton = new JButton("Validar");
        JLabel resultLabel = new JLabel("Ingrese la fecha.");

        submitButton.addActionListener(e -> {
            try {
                int dia = Integer.parseInt(diaField.getText());
                int mes = Integer.parseInt(mesField.getText());
                int anio = Integer.parseInt(anioField.getText());

                boolean fechaValida = false;

                if (anio > 0) {
                    if (mes >= 1 && mes <= 12) {
                        switch (mes) {
                            case 2:
                                if (dia >= 1 && dia <= 28) {
                                    fechaValida = true;
                                }
                                break;
                            case 4: case 6: case 9: case 11:
                                if (dia >= 1 && dia <= 30) {
                                    fechaValida = true;
                                }
                                break;
                            default:
                                if (dia >= 1 && dia <= 31) {
                                    fechaValida = true;
                                }
                                break;
                        }
                    }
                }

                if (fechaValida) {
                    resultLabel.setText("La fecha " + dia + "/" + mes + "/" + anio + " es correcta.");
                } else {
                    resultLabel.setText("La fecha introducida es incorrecta.");
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
            n2_12 ejercicio = new n2_12();
            ejercicio.setVisible(true);
        });
    }
}