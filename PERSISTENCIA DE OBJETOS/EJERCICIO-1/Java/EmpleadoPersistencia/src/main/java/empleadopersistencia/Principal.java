/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadopersistencia;

/**
 *
 * @author Renzo
 */
public class Principal {
       public static void main(String[] args) {
        // Crear instancias de empleados
        Empleado emp1 = new Empleado("Juan Pérez", 35, 2500.50f);
        Empleado emp2 = new Empleado("María Gómez", 28, 3200.75f);
        Empleado emp3 = new Empleado("Carlos Ruiz", 42, 1800.25f);
        
        // Crear archivo de empleados (TXT)
        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.txt");
        
        // Guardar empleados
        archivo.guardarEmpleado(emp1);
        archivo.guardarEmpleado(emp2);
        archivo.guardarEmpleado(emp3);
        
        // Buscar un empleado
        Empleado empleadoBuscado = archivo.buscaEmpleado("María Gómez");
        if (empleadoBuscado != null) {
            System.out.println("Empleado encontrado: " + empleadoBuscado.getNombre() + 
                             ", Edad: " + empleadoBuscado.getEdad() + 
                             ", Salario: " + empleadoBuscado.getSalario());
        } else {
            System.out.println("Empleado no encontrado");
        }
        
        // Buscar empleado con mayor salario que 2000
        Empleado empleadoMayorSalario = archivo.mayorSalario(2000.0f);
        if (empleadoMayorSalario != null) {
            System.out.println("Empleado con salario mayor a 2000: " + 
                              empleadoMayorSalario.getNombre() + 
                              ", Salario: " + empleadoMayorSalario.getSalario());
        } else {
            System.out.println("No hay empleados con salario mayor al especificado");
        }
    }
}
