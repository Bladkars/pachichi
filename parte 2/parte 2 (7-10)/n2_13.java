

import javax.swing.*;

public class n2_13 extends JFrame {

    public n2_13() {
        setTitle("Ejercicio 2.13");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField horaField = new JTextField(3);
        JTextField minField = new JTextField(3);
        JTextField segField = new JTextField(3);
        
        JButton submitButton = new JButton("Calcular +1 Seg");
        JLabel resultLabel = new JLabel("Ingrese la hora actual.");

        submitButton.addActionListener(e -> {
            try {
                int hora = Integer.parseInt(horaField.getText());
                int min = Integer.parseInt(minField.getText());
                int seg = Integer.parseInt(segField.getText());

                // Validamos primero que la hora ingresada sea real
                if (hora >= 0 && hora < 24 && min >= 0 && min < 60 && seg >= 0 && seg < 60) {
                    
                    // Incrementamos un segundo
                    seg++;

                    // Controlamos los desbordamientos de tiempo
                    if (seg == 60) {
                        seg = 0;
                        min++;
                        
                        if (min == 60) {
                            min = 0;
                            hora++;
                            
                            if (hora == 24) {
                                hora = 0;
                            }
                        }
                    }

                    // Formateamos la salida para que siempre muestre dos dígitos (ej: 09:05:00)
                    String horaFormateada = String.format("%02d:%02d:%02d", hora, min, seg);
                    resultLabel.setText("Hora actual +1 segundo: [" + horaFormateada + "]");
                
                } else {
                    resultLabel.setText("Hora incorrecta. Use rangos válidos (0-23, 0-59, 0-59).");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Hora:"));
        panel.add(horaField);
        panel.add(new JLabel("Min:"));
        panel.add(minField);
        panel.add(new JLabel("Seg:"));
        panel.add(segField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            n2_13 ejercicio = new n2_13();
            ejercicio.setVisible(true);
        });
    }
}