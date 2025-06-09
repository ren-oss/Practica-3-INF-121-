/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadopersistencia;

/**
 *
 * @author Renzo
 */
public class Empleado {
     private String nombre;
    private int edad;
    private float salario;
    
    public Empleado(String nombre, int edad, float salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public float getSalario() {
        return salario;
    }
    
    @Override
    public String toString() {
        return nombre + "," + edad + "," + salario;
    }
    
    // Método para crear Empleado desde String
    public static Empleado fromString(String str) {
        String[] partes = str.split(",");
        return new Empleado(
            partes[0],
            Integer.parseInt(partes[1]),
            Float.parseFloat(partes[2])
        );
    }
}
