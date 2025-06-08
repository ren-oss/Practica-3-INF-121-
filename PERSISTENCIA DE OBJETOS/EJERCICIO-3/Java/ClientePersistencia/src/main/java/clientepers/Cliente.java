/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientepers;

/**
 *
 * @author Renzo
 */
public class Cliente {
    int id;
    String nombre;
    int telefono;

    public Cliente(int id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String toFileString() {
        return id + "," + nombre + "," + telefono;
    }

    public static Cliente fromFileString(String linea) {
        String[] partes = linea.split(",");
        return new Cliente(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2]));
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}
