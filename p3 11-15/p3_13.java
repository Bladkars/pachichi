

import javax.swing.*;

public class p3_13 extends JFrame {

    // Variables globales para llevar el conteo
    private int contadorNotas = 0;
    private int aprobados = 0;
    private int condicionados = 0;
    private int desaprobados = 0;
    private final int MAX_NOTAS = 6;

    public p3_13() {
        setTitle("Ejercicio 3.13 - Estadísticas de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Registrar Nota");
        JLabel resultLabel = new JLabel("Ingrese la nota del Alumno 1 (0 a 10):");

        submitButton.addActionListener(e -> {
            try {
                double nota = Double.parseDouble(inputField.getText());

                // Validación de rango de la nota
                if (nota < 0 || nota > 10) {
                    resultLabel.setText("Nota inválida (0-10). Ingrese nota del Alumno " + (contadorNotas + 1) + ":");
                    return;
                }

                contadorNotas++;

                // Clasificación de la nota ingresada
                if (nota > 4) {
                    aprobados++;
                } else if (nota == 4) {
                    condicionados++;
                } else {
                    desaprobados++;
                }

                // Verificar si faltan cargar más notas
                if (contadorNotas < MAX_NOTAS) {
                    resultLabel.setText("Nota guardada. Ingrese nota del Alumno " + (contadorNotas + 1) + ":");
                    inputField.setText("");
                    inputField.requestFocus();
                } else {
                    // Carga completa: mostramos los resultados resumidos en HTML
                    String resultadoFinal = "<html>"
                            + "<b>--- RESULTADOS FINALES (6 Alumnos) ---</b><br>"
                            + "Aprobados (&gt; 4): " + aprobados + "<br>"
                            + "Condicionados (= 4): " + condicionados + "<br>"
                            + "Desaprobados (&lt; 4): " + desaprobados
                            + "</html>";
                    
                    resultLabel.setText(resultadoFinal);
                    inputField.setEnabled(false);
                    submitButton.setEnabled(false);
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Ingrese un número para el Alumno " + (contadorNotas + 1) + ".");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nota:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(550, 150); // Un poco más alta para que la estadística final se lea bien
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_13 ejercicio = new p3_13();
            ejercicio.setVisible(true);
        });
    }
}