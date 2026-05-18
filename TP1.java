import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TP1 extends JFrame {

    public TP1() {
        setTitle("Trabajo Práctico 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Campos de texto para la entrada de datos
        JTextField txtCampo1 = new JTextField(5);
        JTextField txtCampo2 = new JTextField(5);
        JTextField txtCampo3 = new JTextField(5);
        JTextField txtCampo4 = new JTextField(5);

        // Botones de ejecución para cada ejercicio
        JButton botonEj1 = new JButton("Ej 1: Redondear");
        JButton botonEj2 = new JButton("Ej 2: Ventas Fijas");
        JButton botonEj3 = new JButton("Ej 3: Ventas Var");
        JButton botonEj4 = new JButton("Ej 4: Círculo");
        JButton botonEj5 = new JButton("Ej 5: Celsius");
        JButton botonEj6 = new JButton("Ej 6: Velocidad");
        JButton botonEj7 = new JButton("Ej 7: Hipotenusa");
        JButton botonEj8 = new JButton("Ej 8: Herón");
        JButton botonEj9 = new JButton("Ej 9: Descomponer");
        JButton botonEj10 = new JButton("Ej 10: Suerte");

        // Etiqueta destinada a mostrar los resultados
        JLabel lblResultado = new JLabel("Resultado: a la espera de una acción...");

        // 1. Redondeo de número decimal
        botonEj1.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(txtCampo1.getText().trim());
                long aproximado = Math.round(valor); // Obtiene el entero más próximo
                lblResultado.setText("Número redondeado: " + aproximado);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Ingrese un valor decimal en la Caja 1.");
            }
        });

        // 2. Cálculo de ventas con precios fijos
        botonEj2.addActionListener(e -> {
            try {
                final double VALOR_MANZANA = 2.5; 
                final double VALOR_PERA = 3.0;
                
                double cantM1 = Double.parseDouble(txtCampo1.getText().trim());
                double cantM2 = Double.parseDouble(txtCampo2.getText().trim());
                double cantP1 = Double.parseDouble(txtCampo3.getText().trim());
                double cantP2 = Double.parseDouble(txtCampo4.getText().trim());

                // Cálculo del importe acumulado total
                double netoVentas = ((cantM1 + cantM2) * VALOR_MANZANA) + ((cantP1 + cantP2) * VALOR_PERA);
                lblResultado.setText("Total Ventas Fijas: $" + String.format("%.2f", netoVentas));
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Complete los 4 campos con números.");
            }
        });

        // 3. Cálculo de ventas con precios variables
        botonEj3.addActionListener(e -> {
            try {
                // Obtención de precios y kilogramos desde la interfaz
                double pM = Double.parseDouble(txtCampo1.getText().trim());
                double kM = Double.parseDouble(txtCampo2.getText().trim());
                double pP = Double.parseDouble(txtCampo3.getText().trim());
                double kP = Double.parseDouble(txtCampo4.getText().trim());

                double totalLiquidacion = (pM * kM) + (pP * kP);
                lblResultado.setText("Total Ventas Variables: $" + String.format("%.2f", totalLiquidacion));
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Asigne valores numéricos válidos a las 4 cajas.");
            }
        });

        // 4. Longitud y Área de una circunferencia
        botonEj4.addActionListener(e -> {
            try {
                double r = Double.parseDouble(txtCampo1.getText().trim());
                
                // Aplicación de fórmulas geométricas con Math.PI
                double perimetro = 2 * Math.PI * r;
                double superficie = Math.PI * Math.pow(r, 2); 
                
                lblResultado.setText("Longitud: " + String.format("%.2f", perimetro) + " | Área: " + String.format("%.2f", superficie));
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Requiere el radio en la Caja 1.");
            }
        });

        // 5. Conversión de Celsius a Fahrenheit
        botonEj5.addActionListener(e -> {
            try {
                double tempC = Double.parseDouble(txtCampo1.getText().trim());
                double tempF = 32 + (tempC * 9 / 5); // Fórmula matemática de conversión
                lblResultado.setText(tempC + " °C equivalen a " + tempF + " °F");
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Ingrese la temperatura en la Caja 1.");
            }
        });

        // 6. Conversión de Km/h a metros por segundo
        botonEj6.addActionListener(e -> {
            try {
                double velocidadKmh = Double.parseDouble(txtCampo1.getText().trim());
                double velocidadMs = velocidadKmh / 3.6; // Conversión métrica directa
                lblResultado.setText(velocidadKmh + " Km/h = " + String.format("%.2f", velocidadMs) + " m/s");
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Requiere la velocidad en la Caja 1.");
            }
        });

        // 7. Cálculo de la hipotenusa
        botonEj7.addActionListener(e -> {
            try {
                double ladoA = Double.parseDouble(txtCampo1.getText().trim());
                double ladoB = Double.parseDouble(txtCampo2.getText().trim());
                
                // Aplica teorema de Pitágoras directamente
                double valorHipotenusa = Math.hypot(ladoA, ladoB); 
                lblResultado.setText("La longitud de la hipotenusa es: " + String.format("%.2f", valorHipotenusa));
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Introduzca los catetos en las cajas 1 y 2.");
            }
        });

        // 8. Área de un triángulo mediante la Fórmula de Herón
        botonEj8.addActionListener(e -> {
            try {
                double x = Double.parseDouble(txtCampo1.getText().trim());
                double y = Double.parseDouble(txtCampo2.getText().trim());
                double z = Double.parseDouble(txtCampo3.getText().trim());
                
                double semiP = (x + y + z) / 2; // Semiperímetro del triángulo
                double areaHeron = Math.sqrt(semiP * (semiP - x) * (semiP - y) * (semiP - z)); 
                
                lblResultado.setText("Área calculada (Herón): " + String.format("%.2f", areaHeron));
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Ingrese las 3 longitudes en las cajas 1, 2 y 3.");
            }
        });

        // 9. Descomposición de un número de 3 cifras
        botonEj9.addActionListener(e -> {
            try {
                int numeroCompleto = Integer.parseInt(txtCampo1.getText().trim());
                
                // Desglose aritmético de las centenas, decenas y unidades
                int digito1 = numeroCompleto / 100;         
                int digito2 = (numeroCompleto / 10) % 10;   
                int digito3 = numeroCompleto % 10;           
                
                lblResultado.setText("Centena: " + digito1 + " | Decena: " + digito2 + " | Unidad: " + digito3);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Introduzca un entero de 3 dígitos en la Caja 1.");
            }
        });

        // 10. Número de la suerte mediante fecha de nacimiento
        botonEj10.addActionListener(e -> {
            try {
                int digitosFecha = Integer.parseInt(txtCampo1.getText().trim());
                
                // Extracción progresiva de las posiciones numéricas (formato DDMMAAAA)
                int n8 = digitosFecha % 10; digitosFecha /= 10;
                int n7 = digitosFecha % 10; digitosFecha /= 10;
                int n6 = digitosFecha % 10; digitosFecha /= 10;
                int n5 = digitosFecha % 10; digitosFecha /= 10;
                int n4 = digitosFecha % 10; digitosFecha /= 10;
                int n3 = digitosFecha % 10; digitosFecha /= 10;
                int n2 = digitosFecha % 10; digitosFecha /= 10;
                int n1 = digitosFecha; 

                int sumaCifras = n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8;
                
                // Reducción final a un solo dígito operativo
                int numSuerte = (sumaCifras / 10) + (sumaCifras % 10);
                
                lblResultado.setText("Tu Número de la Suerte es: " + numSuerte);
            } catch (NumberFormatException ex) {
                lblResultado.setText("Error: Use el formato DDMMAAAA en la Caja 1.");
            }
        });

        // --- CONSTRUCCIÓN DEL ENTORNO GRÁFICO ---
        JPanel panelPrincipal = new JPanel();
        
        panelPrincipal.add(new JLabel("Caja 1:")); panelPrincipal.add(txtCampo1);
        panelPrincipal.add(new JLabel("Caja 2:")); panelPrincipal.add(txtCampo2);
        panelPrincipal.add(new JLabel("Caja 3:")); panelPrincipal.add(txtCampo3);
        panelPrincipal.add(new JLabel("Caja 4:")); panelPrincipal.add(txtCampo4);
        
        // Elemento espaciador para mejorar la distribución visual
        panelPrincipal.add(Box.createHorizontalStrut(500)); 

        panelPrincipal.add(botonEj1); panelPrincipal.add(botonEj2); panelPrincipal.add(botonEj3); 
        panelPrincipal.add(botonEj4); panelPrincipal.add(botonEj5); panelPrincipal.add(botonEj6); 
        panelPrincipal.add(botonEj7); panelPrincipal.add(botonEj8); panelPrincipal.add(botonEj9); 
        panelPrincipal.add(botonEj10);

        panelPrincipal.add(Box.createHorizontalStrut(500)); 
        panelPrincipal.add(lblResultado);

        add(panelPrincipal);
        
        setSize(700, 200);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TP1().setVisible(true);
        });
    }
}