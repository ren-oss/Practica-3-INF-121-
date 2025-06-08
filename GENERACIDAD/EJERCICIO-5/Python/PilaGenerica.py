# Clase genérica Pila
class Pila:
    def __init__(self):
        self.elementos = []

    def apilar(self, item):
        self.elementos.append(item)

    def desapilar(self):
        if not self.esta_vacia():
            return self.elementos.pop()
        return None

    def esta_vacia(self):
        return len(self.elementos) == 0

    def mostrar(self):
        return self.elementos.copy()

# Prueba con enteros
pila_enteros = Pila()
pila_enteros.apilar(10)
pila_enteros.apilar(20)
print("Pila de enteros:", pila_enteros.mostrar())
print("Desapilando:", pila_enteros.desapilar())

# Prueba con cadenas
pila_cadenas = Pila()
pila_cadenas.apilar("uno")
pila_cadenas.apilar("dos")
print("Pila de cadenas:", pila_cadenas.mostrar())
print("Desapilando:", pila_cadenas.desapilar())
