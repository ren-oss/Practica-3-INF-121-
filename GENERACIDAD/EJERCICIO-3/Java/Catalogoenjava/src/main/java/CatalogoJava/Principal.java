/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CatalogoJava;

/**
 *
 * @author Renzo
 */
public class Principal {
    public static void main(String[] args) {
        // Prueba con libros
        Catalogo<Libro> catalogoLibros = new Catalogo<>();
        catalogoLibros.agregar(new Libro("1984", "George Orwell"));
        catalogoLibros.agregar(new Libro("Fahrenheit 451", "Ray Bradbury"));
        Libro libroBuscado = catalogoLibros.buscar("1984");
        System.out.println(libroBuscado);

        // Prueba con productos
        Catalogo<Producto> catalogoProductos = new Catalogo<>();
        catalogoProductos.agregar(new Producto("Laptop", 1500));
        catalogoProductos.agregar(new Producto("Mouse", 25));
        Producto productoBuscado = catalogoProductos.buscar("Mouse");
        System.out.println(productoBuscado);
    }
}
