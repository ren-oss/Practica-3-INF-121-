# Clase genérica Catalogo
class Catalogo:
    def __init__(self):
        self.elementos = []

    def agregar(self, item):
        self.elementos.append(item)

    def buscar(self, nombre):
        for item in self.elementos:
            if hasattr(item, 'nombre') and item.nombre == nombre:
                return item
        return None

# Clase Libro
class Libro:
    def __init__(self, nombre, autor):
        self.nombre = nombre
        self.autor = autor

    def __str__(self):
        return f"Libro: {self.nombre}, Autor: {self.autor}"

# Clase Producto
class Producto:
    def __init__(self, nombre, precio):
        self.nombre = nombre
        self.precio = precio

    def __str__(self):
        return f"Producto: {self.nombre}, Precio: {self.precio}"

# Prueba con libros
catalogo_libros = Catalogo()
catalogo_libros.agregar(Libro("1984", "George Orwell"))
catalogo_libros.agregar(Libro("Fahrenheit 451", "Ray Bradbury"))

resultado_libro = catalogo_libros.buscar("1984")
print(resultado_libro)

# Prueba con productos
catalogo_productos = Catalogo()
catalogo_productos.agregar(Producto("Laptop", 1500))
catalogo_productos.agregar(Producto("Mouse", 25))

resultado_producto = catalogo_productos.buscar("Mouse")
print(resultado_producto)
