/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import utilidades.Utilidades;

public final class Empleado {
    // Atributos
    private final String dni;
    private final String nombreCompleto;
    private final int edad;
    private final double sueldoBasico;
    private final String seguro;
    private final int horasExtras;
    private final int tardanzas;
    private double sueldoFinal;

    // Constructor que inicializa todos los atributos con valores aleatorios
    public Empleado(String dni, String nombreCompleto, int edad, double sueldoBasico, String seguro, int horasExtras, int tardanzas) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sueldoBasico = sueldoBasico;
        this.seguro = seguro;
        this.horasExtras = horasExtras;
        this.tardanzas = tardanzas;
        calcularSueldoFinal();  // Llamada a método para calcular el sueldo final
    }

    // Métodos Getters
    public String getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public String getSeguro() {
        return seguro;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public int getTardanzas() {
        return tardanzas;
    }

    public double getSueldoFinal() {
        return sueldoFinal;
    }

    // Método para calcular el sueldo final
    public void calcularSueldoFinal() {
        double descuentoSeguro = seguro.equals("AFP") ? 0.10 : 0.08; // Descuento por seguro
        double pagoHorasExtras = horasExtras * 20.0; // Pago por horas extras
        double descuentoTardanzas = tardanzas * 0.5; // Descuento por tardanzas

        sueldoFinal = sueldoBasico - (sueldoBasico * descuentoSeguro) + pagoHorasExtras - descuentoTardanzas;
        sueldoFinal = Utilidades.formatearDouble(sueldoFinal); // Redondea a 2 decimales
    }

    // Método toString para imprimir información del empleado
    @Override
    public String toString() {
        return "Empleado{" +
                "DNI='" + dni + '\'' +
                ", Nombre Completo='" + nombreCompleto + '\'' +
                ", Edad=" + edad +
                ", Sueldo Básico=" + String.format("%.2f", sueldoBasico) +
                ", Seguro='" + seguro + '\'' +
                ", Horas Extras=" + horasExtras +
                ", Tardanzas=" + tardanzas + " minutos" +
                ", Sueldo Final=" + String.format("%.2f", sueldoFinal) +
                '}';
    }
}