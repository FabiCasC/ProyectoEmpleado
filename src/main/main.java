package main;

import controlador.Planilla;

public class main {
    public static void main(String[] args) {
        // Crear una instancia de Planilla
        Planilla planilla = new Planilla();

        // Generar aleatoriamente los datos de los empleados
        planilla.inicializarDatos();

        // Calcular los sueldos finales de los empleados
        planilla.calcularSueldos();

        // Establecer el ancho total de la tabla
        int width = 118;  // Suma de los anchos de las columnas con los separadores

        // Mostrar el encabezado
        System.out.println("+--------------------------------------------------+");
        System.out.println("|              Lista Completa de Empleados        |");
        System.out.println("+--------------------------------------------------+");
        // Encabezado de la tabla
        System.out.printf("| %-15s | %-25s | %-5s | %-15s | %-10s | %-15s | %-10s | %-15s |\n", 
                "DNI", "Nombre", "Edad", "Sueldo Inicial", "Seguro", "Horas Extras", "Tardanzas", "Sueldo Final");
        System.out.println("+--------------------------------------------------+");

        // Imprimir los datos de los empleados
        for (int i = 0; i < 20; i++) {
            System.out.printf("| %-15s | %-25s | %-5d | %-15.2f | %-10s | %-15d | %-10d | %-15.2f |\n",
                    planilla.dni[i], 
                    planilla.nombres[i], 
                    planilla.edades[i], 
                    planilla.sueldos[i][0], // Sueldo básico
                    planilla.sueldos[i][1] == 0.10 ? "AFP" : "SNP", // Determinar el tipo de seguro
                    (int) planilla.sueldos[i][2], // Horas extras generadas
                    (int) planilla.sueldos[i][3], // Tardanzas generadas
                    planilla.sueldos[i][4] // Sueldo final calculado
            );
        }

        // Sección de resultados adicionales
        System.out.println("+--------------------------------------------------+");
        System.out.printf("| Menor Sueldo Final: %-53s |\n", planilla.calcularMenorSueldo());
        System.out.printf("| Mayor Sueldo Final: %-53s |\n", planilla.calcularMayorSueldo());
        System.out.printf("| Promedio de Sueldos Finales: %-45s |\n", planilla.calcularPromedioSueldos());
        System.out.println("+--------------------------------------------------+");
    }
}
