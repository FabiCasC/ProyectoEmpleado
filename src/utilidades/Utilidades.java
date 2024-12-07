/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Random;

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
     * @return Nombre generado aleatoriamente.
     */
    public static String generarNombreAleatorio() {
        String[] nombres = {"Marcelo", "Fabiana","Giussepe", "Marco", "Aaron", "Bruno", "Carlos", "Ana", "Luis", "Maria", "Jose", "Lucia", "Pedro", "Carmen"};
        return nombres[RANDOM.nextInt(nombres.length)];
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
