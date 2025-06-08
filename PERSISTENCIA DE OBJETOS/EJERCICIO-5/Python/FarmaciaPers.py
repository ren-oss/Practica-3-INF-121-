class Medicamento:
    def __init__(self, nombre, codMedicamento, tipo, precio):
        self.nombre = nombre
        self.codMedicamento = codMedicamento
        self.tipo = tipo
        self.precio = precio

    def leer(self):
        return f"{self.nombre},{self.codMedicamento},{self.tipo},{self.precio}"

    def getTipo(self):
        return self.tipo

    def getPrecio(self):
        return self.precio

    @staticmethod
    def from_line(linea):
        nombre, cod, tipo, precio = linea.strip().split(",")
        return Medicamento(nombre, int(cod), tipo, float(precio))

class Farmacia:
    def __init__(self, nombre, sucursal, direccion):
        self.nombreFarmacia = nombre
        self.sucursal = sucursal
        self.direccion = direccion
        self.medicamentos = []

    def agregarMedicamento(self, medicamento):
        self.medicamentos.append(medicamento)

    def mostrar(self):
        print(f"Sucursal: {self.sucursal} - {self.nombreFarmacia}, Dirección: {self.direccion}")
        for m in self.medicamentos:
            print("  ", m.leer())

    def medicamentosTos(self):
        return [m for m in self.medicamentos if m.getTipo().lower() == "tos"]

    def buscaMedicamento(self, nombreMed):
        for m in self.medicamentos:
            if m.nombre.lower() == nombreMed.lower():
                return True
        return False

    def to_line(self):
        lines = [f"{self.nombreFarmacia};{self.sucursal};{self.direccion}"]
        for m in self.medicamentos:
            lines.append(m.leer())
        return lines

    @staticmethod
    def from_lines(lines):
        header = lines[0].strip().split(";")
        f = Farmacia(header[0], int(header[1]), header[2])
        for l in lines[1:]:
            f.agregarMedicamento(Medicamento.from_line(l))
        return f

class ArchFarmacia:
    def __init__(self, nombre_archivo):
        self.na = nombre_archivo
        self.farmacias = []

    def crearArchivo(self):
        open(self.na, "w").close()

    def adicionar(self, farmacia):
        self.farmacias.append(farmacia)
        self.guardarArchivo()

    def guardarArchivo(self):
        with open(self.na, "w") as f:
            for farmacia in self.farmacias:
                for linea in farmacia.to_line():
                    f.write(linea + "\n")
                f.write("#\n")  # Separador de farmacias

    def leerArchivo(self):
        self.farmacias = []
        with open(self.na, "r") as f:
            bloque = []
            for linea in f:
                if linea.strip() == "#":
                    self.farmacias.append(Farmacia.from_lines(bloque))
                    bloque = []
                else:
                    bloque.append(linea)
            if bloque:
                self.farmacias.append(Farmacia.from_lines(bloque))

    def listar(self):
        for f in self.farmacias:
            f.mostrar()

    def mostrarMedicamentosTos(self, sucursalX):
        for f in self.farmacias:
            if f.sucursal == sucursalX:
                print(f"TOS en Sucursal {f.sucursal} - {f.direccion}:")
                for med in f.medicamentosTos():
                    print("  ", med.leer())

    def mostrarMedicamentosGolpex(self):
        for f in self.farmacias:
            if f.buscaMedicamento("Golpex"):
                print(f"Sucursal: {f.sucursal}, Dirección: {f.direccion}")

# Ejemplo de uso
                
archivo = ArchFarmacia("farmacias.txt")

f1 = Farmacia("MiSalud", 1, "Calle A")
f1.agregarMedicamento(Medicamento("Golpex", 101, "tos", 12.5))
f1.agregarMedicamento(Medicamento("Paracetamol", 102, "fiebre", 5.5))

f2 = Farmacia("VitaPlus", 2, "Avenida B")
f2.agregarMedicamento(Medicamento("Ibuprofeno", 201, "tos", 6.0))
f2.agregarMedicamento(Medicamento("Golpex", 202, "tos", 10.0))

archivo.adicionar(f1)
archivo.adicionar(f2)

archivo.leerArchivo()
archivo.listar()
print("\nMedicamentos para la tos en sucursal 2:")
archivo.mostrarMedicamentosTos(2)

print("\nFarmacias con Golpex:")
archivo.mostrarMedicamentosGolpex()