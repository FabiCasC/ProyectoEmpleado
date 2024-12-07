/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Empleado;
import utilidades.Utilidades;


public class Planilla {

    // Arreglos paralelos y lista de objetos Empleado
    public String[] dni = new String[20];
    public String[] nombres = new String[20];
    public int[] edades = new int[20];
    public double[][] sueldos = new double[20][5]; // Sueldo básico, descuento seguro, horas extras, tardanzas, sueldo final
    private final Empleado[] empleados = new Empleado[20]; // Lista de objetos empleados

    // Método para inicializar los datos de los empleados
    public void inicializarDatos() {
        for (int i = 0; i < empleados.length; i++) {
            String dniEmpleado = Utilidades.generarDniAleatorio();
            String nombreEmpleado = Utilidades.generarNombreAleatorio();
            int edadEmpleado = Utilidades.generarEdadAleatoria();
            double sueldoBasico = Utilidades.generarSueldoBasicoAleatorio();
            String seguro = Utilidades.generarSeguroAleatorio();
            int horasExtras = Utilidades.generarHorasExtrasAleatorias();
            int tardanzas = Utilidades.generarTardanzasAleatorias();

            // Inicializando el objeto Empleado
            empleados[i] = new Empleado(dniEmpleado, nombreEmpleado, edadEmpleado, sueldoBasico, seguro, horasExtras, tardanzas);

            // Guardando los datos en los arreglos
            dni[i] = dniEmpleado;
            nombres[i] = nombreEmpleado;
            edades[i] = edadEmpleado;
            sueldos[i][0] = sueldoBasico;
            sueldos[i][1] = seguro.equals("AFP") ? 0.10 : 0.08; // Descuento por seguro
            sueldos[i][2] = horasExtras * 20.0; // Pago por horas extras
            sueldos[i][3] = tardanzas * 0.5; // Descuento por tardanzas
            sueldos[i][4] = empleados[i].getSueldoFinal(); // Sueldo final
        }
    }

    // Método para calcular los sueldos de los empleados
    public void calcularSueldos() {
        for (Empleado empleado : empleados) {
            empleado.calcularSueldoFinal();
        }
    }

    // Método para mostrar un empleado específico
    public void mostrarEmpleado(int index) {
        if (index >= 0 && index < empleados.length) {
            System.out.println(empleados[index].toString());
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Método para calcular el menor sueldo final y devolver el nombre del empleado correspondiente
    public String calcularMenorSueldo() {
        double menorSueldo = Double.MAX_VALUE;
        String nombreEmpleado = "";
        for (Empleado empleado : empleados) {
            if (empleado.getSueldoFinal() < menorSueldo) {
                menorSueldo = empleado.getSueldoFinal();
                nombreEmpleado = empleado.getNombreCompleto();
            }
        }
        return nombreEmpleado + " con un sueldo final de: " + String.format("%.2f", menorSueldo);
    }

    // Método para calcular el mayor sueldo final y devolver el nombre del empleado correspondiente
    public String calcularMayorSueldo() {
        double mayorSueldo = Double.MIN_VALUE;
        String nombreEmpleado = "";
        for (Empleado empleado : empleados) {
            if (empleado.getSueldoFinal() > mayorSueldo) {
                mayorSueldo = empleado.getSueldoFinal();
                nombreEmpleado = empleado.getNombreCompleto();
            }
        }
        return nombreEmpleado + " con un sueldo final de: " + String.format("%.2f", mayorSueldo);
    }

    // Método para calcular el promedio de los sueldos finales
    public double calcularPromedioSueldos() {
        double sumaSueldos = 0;
        for (Empleado empleado : empleados) {
            sumaSueldos += empleado.getSueldoFinal();
        }
        return Utilidades.formatearDouble(sumaSueldos / empleados.length);
    }

    // Método para filtrar empleados por nombre y/o seguro
    public ArrayList<Empleado> buscarPorDni(String dni) {
    ArrayList<Empleado> resultado = new ArrayList<>();
    for (Empleado empleado : empleados) {
        if (empleado.getDni().equalsIgnoreCase(dni)) {
            resultado.add(empleado);
        }
    }
    return resultado;
}

    // Método para filtrar empleados por tipo de seguro
    public ArrayList<Empleado> filtrarPorSeguro(String seguro) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (seguro.equals("Todos") || empleado.getSeguro().equalsIgnoreCase(seguro)) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    // Método para obtener todos los datos de los empleados
    public String obtenerTodosLosDatos() {
        StringBuilder resultado = new StringBuilder();
        for (Empleado empleado : empleados) {
            resultado.append(empleado.toString()).append("\n");
        }
        return resultado.toString();
    }

    // Acceder a los empleados
    public ArrayList<Empleado> getEmpleados() {
    ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    for (Empleado emp : empleados) {
        if (emp != null) { // Evitar posibles valores null en el arreglo
            listaEmpleados.add(emp);
        }
    }
    return listaEmpleados;
}
}




