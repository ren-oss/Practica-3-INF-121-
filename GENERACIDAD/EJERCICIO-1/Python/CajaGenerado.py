# Clase genérica Caja en Python

class Caja:
    def __init__(self):
        self._contenido = None

    def guardar(self, item):
        self._contenido = item

    def obtener(self):
        return self._contenido

# Crear dos cajas con diferentes tipos de datos
caja1 = Caja()
caja1.guardar("Hola mundo")  # Cadena de texto

caja2 = Caja()
caja2.guardar(12345)  # Número entero

# Mostrar contenido de las cajas
print("Contenido de la caja1:", caja1.obtener())
print("Contenido de la caja2:", caja2.obtener())
