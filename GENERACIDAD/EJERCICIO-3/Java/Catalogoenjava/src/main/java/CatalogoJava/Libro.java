/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CatalogoJava;

/**
 *
 * @author Renzo
 */
public class Libro {
    private String nombre;
    private String autor;

    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Libro: " + nombre + ", Autor: " + autor;
    }
}
