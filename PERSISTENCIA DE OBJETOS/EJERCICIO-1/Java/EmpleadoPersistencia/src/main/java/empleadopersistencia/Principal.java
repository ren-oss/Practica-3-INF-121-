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
        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.txt");

        archivo.guardarEmpleado(new Empleado("Ana", 25, 3000));
        archivo.guardarEmpleado(new Empleado("Luis", 30, 4500));
        archivo.guardarEmpleado(new Empleado("Maria", 28, 4000));

        System.out.println("Buscar Luis: " + archivo.buscaEmpleado("Luis"));
        System.out.println("Empleado con salario mayor a 3500: " + archivo.mayorSalario(3500));
    }
}
