/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    private static final Random RANDOM = new Random();

    /**
     * Genera un DNI ficticio único (8 dígitos).
     *
     * @return DNI generado aleatoriamente.
     */
    public static String generarDniAleatorio() {
        int dni = 10000000 + RANDOM.nextInt(90000000); // Genera un número entre 10000000 y 99999999
        return String.valueOf(dni);
    }
    /**
     * Genera un nombre aleatorio a partir de una lista predefinida.
     *
     */
    public class NombreAleatorio {

        private static final Random RANDOM = new Random();
        private static final List<String> nombresDisponibles = new ArrayList<>(List.of(
                "Carlos", "Maria", "Giussepe", "Ana", "Luis", "Sofia", "Pedro", "Lucia",
                "Miguel", "Clara", "Javier", "Valeria", "Andres", "Camila", "Ricardo",
                "Daniela", "Felipe", "Mariana", "Diego", "Alejandra", "Aaron", "Bruno"
        ));
        private static final List<String> apellidosDisponibles = new ArrayList<>(List.of(
                "Garcia", "Martinez", "Rodriguez", "Lopez", "Gonzalez", "Perez",
                "Fernandez", "Chavez", "Vargas", "Rojas", "Torres", "Castro",
                "Flores", "Reyes", "Herrera", "Ramos", "Romero", "Cruz",
                "Morales", "Ortega", "Delgado", "Yovera"
        ));

        public static String generarNombreAleatorio() {
            String nombre = nombresDisponibles.get(RANDOM.nextInt(nombresDisponibles.size()));
            String apellido = apellidosDisponibles.get(RANDOM.nextInt(apellidosDisponibles.size()));
            return nombre + " " + apellido;
        }

        public static void main(String[] args) {
            System.out.println(generarNombreAleatorio());
        }
    }


    /**
     * Devuelve una edad aleatoria entre 18 y 60.
     *
     * @return Edad generada aleatoriamente.
     */
    public static int generarEdadAleatoria() {
        return 18 + RANDOM.nextInt(43); // Genera un número entre 18 y 60
    }

    /**
     * Devuelve un sueldo básico aleatorio entre 1000 y 3000.
     *
     * @return Sueldo básico generado aleatoriamente.
     */
    public static double generarSueldoBasicoAleatorio() {
        return formatearDouble(1000 + (2000 * RANDOM.nextDouble())); // Genera un número entre 1000 y 3000
    }

    /**
     * Devuelve aleatoriamente "AFP" o "SNP".
     *
     * @return Tipo de seguro generado aleatoriamente.
     */
    public static String generarSeguroAleatorio() {
        return RANDOM.nextBoolean() ? "AFP" : "SNP";
    }

    /**
     * Devuelve un número aleatorio entre 0 y 10 para horas extras.
     *
     * @return Número de horas extras generado aleatoriamente.
     */
    public static int generarHorasExtrasAleatorias() {
        return RANDOM.nextInt(11); // Genera un número entre 0 y 10
    }

    /**
     * Devuelve un número aleatorio entre 0 y 120 para minutos de tardanzas.
     *
     * @return Número de minutos de tardanza generado aleatoriamente.
     */
    public static int generarTardanzasAleatorias() {
        return RANDOM.nextInt(121); // Genera un número entre 0 y 120
    }

    /**
     * Redondea un número decimal a 2 decimales.
     *
     * @param valor Número a redondear.
     * @return Número redondeado a 2 decimales.
     */
    public static double formatearDouble(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
