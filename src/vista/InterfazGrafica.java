/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package vista;

import controlador.Planilla;
import modelo.Empleado;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfazGrafica extends Frame {
    // Componentes de la interfaz
    private TextField campoDNI;
    private Choice comboSeguro;
    private Button btnBuscar, btnMostrarTodos, btnMenorSueldo, btnMayorSueldo, btnPromedioSueldos;
    private TextArea areaResultados;
    private Planilla planilla;

    // Colores para el diseño
    private final Color COLOR_FONDO = new Color(240, 240, 240);
    private final Color COLOR_TEXTO = new Color(50, 50, 50);
    private final Color COLOR_BOTON = new Color(100, 149, 237);
    private final Color COLOR_BOTON_TEXTO = Color.WHITE;
    private final Color COLOR_PANEL = new Color(220, 220, 220);

    public InterfazGrafica() {
        super("Sistema de Planilla");
        setSize(1000, 700);
        setLayout(new BorderLayout(10, 10));
        setBackground(COLOR_FONDO);

        inicializarComponentes();
        inicializarDatos();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void inicializarComponentes() {
        // Header personalizado
        HeaderCanvas header = new HeaderCanvas("Sistema de Planilla");
        add(header, BorderLayout.NORTH);

        // Panel principal
        Panel panelPrincipal = new Panel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(COLOR_FONDO);

        // Panel de búsqueda
        Panel panelBusqueda = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBusqueda.setBackground(COLOR_PANEL);

        Label lblDNI = new Label("DNI:");
        campoDNI = new TextField(15);
        
        Label lblSeguro = new Label("Seguro:");
        comboSeguro = new Choice();
        comboSeguro.add("Todos");
        comboSeguro.add("AFP");
        comboSeguro.add("SNP");
        
        btnBuscar = crearBoton("Buscar");

        panelBusqueda.add(lblDNI);
        panelBusqueda.add(campoDNI);
        panelBusqueda.add(lblSeguro);
        panelBusqueda.add(comboSeguro);
        panelBusqueda.add(btnBuscar);

        // Panel de resultados
        Panel panelResultados = new Panel(new BorderLayout(10, 10));
        panelResultados.setBackground(COLOR_FONDO);

        areaResultados = new TextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaResultados.setForeground(COLOR_TEXTO);
        panelResultados.add(areaResultados, BorderLayout.CENTER);

        // Panel de botones
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(COLOR_PANEL);
        
        btnMostrarTodos = crearBoton("Mostrar Todos");
        btnMenorSueldo = crearBoton("Menor Sueldo");
        btnMayorSueldo = crearBoton("Mayor Sueldo");
        btnPromedioSueldos = crearBoton("Promedio Sueldos");
        
        panelBotones.add(btnMostrarTodos);
        panelBotones.add(btnMenorSueldo);
        panelBotones.add(btnMayorSueldo);
        panelBotones.add(btnPromedioSueldos);

        // Agregar paneles al panel principal
        panelPrincipal.add(panelBusqueda, BorderLayout.NORTH);
        panelPrincipal.add(panelResultados, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Agregar panel principal al frame
        add(panelPrincipal, BorderLayout.CENTER);

        // Agregar ActionListeners
        btnBuscar.addActionListener(e -> buscarEmpleados());
        btnMostrarTodos.addActionListener(e -> mostrarTodos());
        btnMenorSueldo.addActionListener(e -> mostrarMenorSueldo());
        btnMayorSueldo.addActionListener(e -> mostrarMayorSueldo());
        btnPromedioSueldos.addActionListener(e -> mostrarPromedioSueldos());
    }

    // Método para crear botones con estilo personalizado
    private Button crearBoton(String texto) {
        Button btn = new Button(texto);
        btn.setBackground(COLOR_BOTON);
        btn.setForeground(COLOR_BOTON_TEXTO);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        return btn;
    }

    // Inicializa los datos de la planilla
    private void inicializarDatos() {
        planilla = new Planilla();
        planilla.inicializarDatos();
        planilla.calcularSueldos();
    }

    // Busca empleados por DNI o seguro
    private void buscarEmpleados() {
        String dni = campoDNI.getText();
        String seguro = comboSeguro.getSelectedItem();
        ArrayList<Empleado> resultados;

        if (!dni.isEmpty()) {
            resultados = planilla.buscarPorDni(dni);
        } else {
            resultados = planilla.filtrarPorSeguro(seguro);
        }

        mostrarResultados(resultados);
    }

    // Muestra todos los empleados
    private void mostrarTodos() {
        mostrarResultados(planilla.getEmpleados());
    }

    // Muestra el empleado con menor sueldo
    private void mostrarMenorSueldo() {
        areaResultados.setText("Empleado con menor sueldo: " + planilla.calcularMenorSueldo());
    }

    // Muestra el empleado con mayor sueldo
    private void mostrarMayorSueldo() {
        areaResultados.setText("Empleado con mayor sueldo: " + planilla.calcularMayorSueldo());
    }

    // Muestra el promedio de sueldos
    private void mostrarPromedioSueldos() {
        areaResultados.setText("Promedio de sueldos: " + planilla.calcularPromedioSueldos());
    }

    // Muestra los resultados en formato de tabla
    private void mostrarResultados(ArrayList<Empleado> empleados) {
        StringBuilder sb = new StringBuilder();
        
        // Encabezado de la tabla
        sb.append("┌───────────────┬───────────────────────────┬─────┬─────────────────┬──────────┬─────────────────┬──────────┬─────────────────┐\n");
        sb.append(String.format("│ %-13s │ %-25s │ %-3s │ %-15s │ %-8s │ %-15s │ %-8s │ %-15s │\n",
                "DNI", "Nombre", "Edad", "Sueldo Inicial", "Seguro", "Horas Extras", "Tardanzas", "Sueldo Final"));
        sb.append("├───────────────┼───────────────────────────┼─────┼─────────────────┼──────────┼─────────────────┼──────────┼─────────────────┤\n");

        // Datos de los empleados
        for (Empleado emp : empleados) {
            sb.append(String.format("│ %-13s │ %-25s │ %-3d │ %-15.2f │ %-8s │ %-15d │ %-8d │ %-15.2f │\n",
                    emp.getDni(), emp.getNombreCompleto(), emp.getEdad(), emp.getSueldoBasico(),
                    emp.getSeguro(), emp.getHorasExtras(), emp.getTardanzas(), emp.getSueldoFinal()));
        }

        // Pie de la tabla
        sb.append("└───────────────┴───────────────────────────┴─────┴─────────────────┴──────────┴─────────────────┴──────────┴─────────────────┘\n");

        areaResultados.setText(sb.toString());
    }

    public static void main(String[] args) {
        new InterfazGrafica();
    }
}
