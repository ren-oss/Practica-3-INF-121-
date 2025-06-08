class Empleado:
    def __init__(self, nombre: str, edad: int, salario: float):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def __str__(self):
        return f"Nombre: {self.nombre}, Edad: {self.edad}, Salario: {self.salario}"


class ArchivoEmpleado:
    def __init__(self, nomA: str):
        self.nomA = nomA
        self.empleados = []

    def crearArchivo(self):
        self.empleados = []

    def guardarEmpleado(self, e: Empleado):
        self.empleados.append(e)

    def buscaEmpleado(self, n: str):
        for empleado in self.empleados:
            if empleado.nombre == n:
                return empleado
        return None

    def mayorSalario(self, sueldo: float):
        for empleado in self.empleados:
            if empleado.salario > sueldo:
                return empleado
        return None


# Prueba
archivo = ArchivoEmpleado("empleados.txt")
archivo.guardarEmpleado(Empleado("Ana", 25, 3000))
archivo.guardarEmpleado(Empleado("Luis", 30, 4500))
archivo.guardarEmpleado(Empleado("Maria", 28, 4000))

print("Buscar Luis:", archivo.buscaEmpleado("Luis"))
print("Empleado con salario mayor a 3500:", archivo.mayorSalario(3500))
