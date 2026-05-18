

import javax.swing.*;

public class p3_12 extends JFrame {

    // Variables globales para mantener el estado entre clics
    private int contadorNotas = 0;
    private boolean tieneDesaprobados = false;
    private final int MAX_NOTAS = 5;

    public p3_12() {
        setTitle("Ejercicio 3.12 - Control de Calificaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Registrar Nota");
        JLabel resultLabel = new JLabel("Ingrese la calificación del Alumno 1 (0 a 10):");

        submitButton.addActionListener(e -> {
            try {
                double nota = Double.parseDouble(inputField.getText());

                // Validamos que la nota ingresada sea coherente (rango común de 0 a 10)
                if (nota < 0 || nota > 10) {
                    resultLabel.setText("Nota inválida. Debe estar entre 0 y 10. Alumno " + (contadorNotas + 1) + ":");
                    return;
                }

                contadorNotas++;

                // Si la nota es menor a 4, encendemos la alarma de desaprobado
                if (nota < 4) {
                    tieneDesaprobados = true;
                }

                // Si todavía no llegamos a las 5 notas, pedimos la siguiente
                if (contadorNotas < MAX_NOTAS) {
                    resultLabel.setText("Nota registrada. Ingrese la calificación del Alumno " + (contadorNotas + 1) + ":");
                    inputField.setText("");
                    inputField.requestFocus();
                } else {
                    // Si ya se cargaron las 5, damos el veredicto y cerramos la entrada
                    if (tieneDesaprobados) {
                        resultLabel.setText("<html><b>Análisis terminado:</b> Sí, hay alumnos desaprobados (nota menor a 4).</html>");
                    } else {
                        resultLabel.setText("<html><b>Análisis terminado:</b> Todo en orden. No hay ningún alumno desaprobado.</html>");
                    }
                    inputField.setEnabled(false);
                    submitButton.setEnabled(false);
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Ingrese un número para el Alumno " + (contadorNotas + 1) + ".");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Calificación:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 110);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_12 ejercicio = new p3_12();
            ejercicio.setVisible(true);
        });
    }
}