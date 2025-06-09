import json
import os

class Empleado:
    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

class ArchivoEmpleado:
    def __init__(self, nomA):
        self.nomA = nomA
        if not os.path.exists(nomA):
            self.crearArchivo()
    
    def crearArchivo(self):
        with open(self.nomA, 'w') as f:
            json.dump([], f)
    
    def guardarEmpleado(self, e):
        empleados = []
        if os.path.exists(self.nomA):
            with open(self.nomA, 'r') as f:
                empleados = json.load(f)
        
        empleados.append({
            'nombre': e.nombre,
            'edad': e.edad,
            'salario': e.salario
        })
        
        with open(self.nomA, 'w') as f:
            json.dump(empleados, f)
    
    def buscaEmpleado(self, n):
        if not os.path.exists(self.nomA):
            return None
        
        with open(self.nomA, 'r') as f:
            empleados = json.load(f)
        
        for emp in empleados:
            if emp['nombre'] == n:
                return Empleado(emp['nombre'], emp['edad'], emp['salario'])
        return None
    
    def mayorSalario(self, s):
        if not os.path.exists(self.nomA):
            return None
        
        with open(self.nomA, 'r') as f:
            empleados = json.load(f)
        
        for emp in empleados:
            if emp['salario'] > s:
                return Empleado(emp['nombre'], emp['edad'], emp['salario'])
        return None

# Ejemplo de uso 


# Crear instancias de empleados
emp1 = Empleado("Juan Pérez", 35, 2500.50)
emp2 = Empleado("María Gómez", 28, 3200.75)
emp3 = Empleado("Carlos Ruiz", 42, 1800.25)

# Crear archivo de empleados
archivo = ArchivoEmpleado("empleados.json")

# Guardar empleados
archivo.guardarEmpleado(emp1)
archivo.guardarEmpleado(emp2)
archivo.guardarEmpleado(emp3)

# Buscar un empleado
empleado_buscado = archivo.buscaEmpleado("María Gómez")
if empleado_buscado:
    print(f"Empleado encontrado: {empleado_buscado.nombre}, Edad: {empleado_buscado.edad}, Salario: {empleado_buscado.salario}")
else:
    print("Empleado no encontrado")

# Buscar empleado con mayor salario que 2000
empleado_mayor_salario = archivo.mayorSalario(2000.0)
if empleado_mayor_salario:
    print(f"Empleado con salario mayor a 2000: {empleado_mayor_salario.nombre}, Salario: {empleado_mayor_salario.salario}")
else:
    print("No hay empleados con salario mayor al especificado")