

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadopersistencia;
import java.util.ArrayList;
/**
 *
 * @author Renzo
 */
public class ArchivoEmpleado {
     private String nomA;
    private ArrayList<Empleado> empleados;

    public ArchivoEmpleado(String nomA) {
        this.nomA = nomA;
        empleados = new ArrayList<>();
    }

    public void crearArchivo() {
        empleados.clear();
    }

    public void guardarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public Empleado buscaEmpleado(String n) {
        for (Empleado e : empleados) {
            if (e.nombre.equals(n)) {
                return e;
            }
        }
        return null;
    }

    public Empleado mayorSalario(float sueldo) {
        for (Empleado e : empleados) {
            if (e.salario > sueldo) {
                return e;
            }
        }
        return null;
    }
}
