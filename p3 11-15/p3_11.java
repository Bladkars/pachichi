

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class p3_11 extends JFrame {

    public p3_11() {
        setTitle("Ejercicio 3.11 - Tablas del 1 al 10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLocationRelativeTo(null);

        // Componente de texto para mostrar las tablas con fuente monoespaciada para que quede alineado
        JTextArea txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        // Agregamos barra de desplazamiento para poder navegar el texto
        JScrollPane scrollPane = new JScrollPane(txtResultado);

        JButton btnCalcular = new JButton("Generar Todas las Tablas");

        btnCalcular.addActionListener(e -> {
            StringBuilder contenedor = new StringBuilder();

            // Bucle externo: recorre cada tabla del 1 al 10
            for (int tabla = 1; tabla <= 10; tabla++) {
                contenedor.append("=== TABLA DEL ").append(tabla).append(" ===\n");
                
                // Bucle interno: calcula las multiplicaciones de la tabla actual
                for (int i = 1; i <= 10; i++) {
                    int resultado = tabla * i;
                    contenedor.append(String.format("%2d x %2d = %3d\n", tabla, i, resultado));
                }
                
                contenedor.append("\n"); // Espacio de separación entre tablas
            }

            txtResultado.setText(contenedor.toString());
            txtResultado.setCaretPosition(0); // Regresa el scroll arriba de todo al terminar
        });

        // Organizamos el diseño de la ventana
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(btnCalcular);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_11 ejercicio = new p3_11();
            ejercicio.setVisible(true);
        });
    }
}