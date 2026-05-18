

import javax.swing.*;

public class n2_16 extends JFrame {

    public n2_16() {
        setTitle("Ejercicio 2.16 - Números a Letras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Convertir");
        JLabel resultLabel = new JLabel("Resultado: ");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());

                if (num >= 1 && num <= 99) {
                    String texto = "";

                    // Casos especiales del 11 al 15
                    if (num >= 11 && num <= 15) {
                        switch (num) {
                            case 11: texto = "once"; break;
                            case 12: texto = "doce"; break;
                            case 13: texto = "trece"; break;
                            case 14: texto = "catorce"; break;
                            case 15: texto = "quince"; break;
                        }
                    } else {
                        // Separamos las decenas y las unidades
                        int decenas = num / 10;
                        int unidades = num % 10;

                        // Determinar el texto de la decena
                        switch (decenas) {
                            case 1: texto = "diez"; break; // El 10 puro (los 11-15 ya se filtraron arriba)
                            case 2: texto = (unidades == 0) ? "veinte" : "veinti"; break;
                            case 3: texto = "treinta"; break;
                            case 4: texto = "cuarenta"; break;
                            case 5: texto = "cincuenta"; break;
                            case 6: texto = "sesenta"; break;
                            case 7: texto = "setenta"; break;
                            case 8: texto = "ochenta"; break;
                            case 9: texto = "noventa"; break;
                        }

                        // Si tiene unidades y no es de la familia del 10 o 20, agregamos el " y "
                        if (unidades > 0 && decenas > 2) {
                            texto += " y ";
                        }

                        // Determinar el texto de la unidad
                        if (unidades > 0) {
                            switch (unidades) {
                                case 1: texto += "uno"; break;
                                case 2: texto += "dos"; break;
                                case 3: texto += "tres"; break;
                                case 4: texto += "cuatro"; break;
                                case 5: texto += "cinco"; break;
                                case 6: texto += "seis"; break;
                                case 7: texto += "siete"; break;
                                case 8: texto += "ocho"; break;
                                case 9: texto += "nueve"; break;
                            }
                        }
                        
                        // Corrección ortográfica para la familia del 10 (16 al 19)
                        if (decenas == 1 && unidades > 5) {
                            switch (unidades) {
                                case 6: texto = "dieciséis"; break;
                                case 7: texto = "diecisiete"; break;
                                case 8: texto = "dieciocho"; break;
                                case 9: texto = "diecinueve"; break;
                            }
                        }
                    }

                    resultLabel.setText("Resultado: «" + texto + "»");

                } else {
                    resultLabel.setText("Por favor, ingrese un número entre 1 y 99.");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número (1-99): "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            n2_16 ejercicio = new n2_16();
            ejercicio.setVisible(true);
        });
    }
}