

import javax.swing.*;

public class p3_2 extends JFrame {

    // Variables acumuladoras (atributos de clase para mantener el estado)
    private int sumaEdades = 0;
    private int contadorAlumnos = 0;
    private int mayoresDeEdad = 0;

    public p3_2() {
        setTitle("Ejercicio 3.2 - Estadísticas de Edades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Registrar Edad");
        JLabel resultLabel = new JLabel("Ingrese la edad del primer alumno (negativo para terminar):");

        submitButton.addActionListener(e -> {
            try {
                int edad = Integer.parseInt(inputField.getText());

                // Condición de parada: si la edad es negativa, calculamos y mostramos el final
                if (edad < 0) {
                    if (contadorAlumnos == 0) {
                        resultLabel.setText("No se introdujeron edades válidas.");
                    } else {
                        double media = (double) sumaEdades / contadorAlumnos;
                        
                        // Armamos un texto con saltos de línea usando HTML para que quede prolijo en el JLabel
                        String estadisticas = "<html>"
                                + "<b>--- ESTADÍSTICAS FINALES ---</b><br>"
                                + "Suma total de edades: " + sumaEdades + "<br>"
                                + "Media de edad: " + String.format("%.2f", media) + "<br>"
                                + "Total de alumnos: " + contadorAlumnos + "<br>"
                                + "Mayores de edad (≥ 18): " + mayoresDeEdad
                                + "</html>";
                        
                        resultLabel.setText(estadisticas);
                    }
                    
                    // Deshabilitamos la entrada de datos al finalizar
                    inputField.setEnabled(false);
                    submitButton.setEnabled(false);
                    return;
                }

                // Si la edad es válida (cero o positiva), acumulamos los datos
                sumaEdades += edad;
                contadorAlumnos++;
                
                if (edad >= 18) {
                    mayoresDeEdad++;
                }

                // Feedback rápido para saber que se cargó bien el alumno actual
                resultLabel.setText("Edad registrada (" + edad + "). Alumnos acumulados: " + contadorAlumnos + ". Ingrese otra:");
                
                // Limpiamos y enfocamos el campo de texto para la siguiente edad
                inputField.setText("");
                inputField.requestFocus();

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca un número entero.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Edad:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 160); // Un poco más alto para que entren bien las estadísticas finales
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_2 ejercicio = new p3_2();
            ejercicio.setVisible(true);
        });
    }
}