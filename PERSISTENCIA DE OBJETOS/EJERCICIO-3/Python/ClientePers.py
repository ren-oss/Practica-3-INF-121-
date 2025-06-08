import json

class Cliente:
    def __init__(self, id, nombre, telefono):
        self.id = id
        self.nombre = nombre
        self.telefono = telefono

    def __str__(self):
        return f"ID: {self.id}, Nombre: {self.nombre}, Teléfono: {self.telefono}"

    def to_dict(self):
        return {"id": self.id, "nombre": self.nombre, "telefono": self.telefono}

    @staticmethod
    def from_dict(d):
        return Cliente(d["id"], d["nombre"], d["telefono"])


class ArchivoCliente:
    def __init__(self, nomA: str):
        self.nomA = nomA
        self.clientes = []
        self.cargarArchivo()

    def crearArchivo(self):
        self.clientes = []
        with open(self.nomA, "w") as f:
            json.dump([], f)

    def guardaCliente(self, c: Cliente):
        self.clientes.append(c)
        self.guardarArchivo()

    def guardarArchivo(self):
        with open(self.nomA, "w") as f:
            json.dump([cliente.to_dict() for cliente in self.clientes], f)

    def cargarArchivo(self):
        try:
            with open(self.nomA, "r") as f:
                data = json.load(f)
                self.clientes = [Cliente.from_dict(d) for d in data]
        except FileNotFoundError:
            self.crearArchivo()

    def buscarCliente(self, c: int):
        for cliente in self.clientes:
            if cliente.id == c:
                return cliente
        return None

    def buscarCelularCliente(self, c: int):
        cliente = self.buscarCliente(c)
        if cliente:
            return f"{cliente.nombre} - Teléfono: {cliente.telefono}"
        return "Cliente no encontrado"


# Prueba
archivo = ArchivoCliente("clientes.txt")
archivo.guardaCliente(Cliente(101, "Carlos", 77712345))
archivo.guardaCliente(Cliente(102, "Elena", 76543210))

print("Buscar Cliente 102:", archivo.buscarCliente(102))
print("Buscar Celular Cliente 101:", archivo.buscarCelularCliente(101))
