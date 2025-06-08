/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CatalogoJava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renzo
 */
public class Catalogo<T> {
      private List<T> elementos = new ArrayList<>();

    public void agregar(T item) {
        elementos.add(item);
    }

    public T buscar(String nombre) {
        for (T item : elementos) {
            if (item instanceof Libro && ((Libro) item).getNombre().equals(nombre)) {
                return item;
            }
            if (item instanceof Producto && ((Producto) item).getNombre().equals(nombre)) {
                return item;
            }
        }
        return null;
    }
}
