/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PilaGenerica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renzo
 */
public class Pila<T> {
      private List<T> elementos = new ArrayList<>();

    public void apilar(T item) {
        elementos.add(item);
    }

    public T desapilar() {
        if (!estaVacia()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public List<T> mostrar() {
        return new ArrayList<>(elementos); // copia
    }
}
