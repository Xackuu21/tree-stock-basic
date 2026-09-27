Tree-Stock es una aplicación de consola desarrollada en Java que gestiona un inventario de productos utilizando un Árbol Binario de Búsqueda (ABB / BST) implementado manualmente, sin recurrir a colecciones o librerías de Java (`ArrayList`, `LinkedList`, etc.).

---

## ¿De qué trata el proyecto?

El objetivo principal fue entender cómo funcionan las **estructuras dinámicas en memoria** mediante el uso de referencias ("punteros") y la **recursividad**. 

Al usar un árbol binario organizado por el `ID` del producto, logré que la búsqueda sea eficiente y que el inventario se pueda imprimir ordenado automáticamente gracias al recorrido **Inorden**.

---

## Estructura del Código

El proyecto está dividido estrictamente en tres clases para mantener una buena separación de responsabilidades:

* **`Producto.java` (El Nodo):** Representa cada elemento del árbol. Almacena los datos del producto (`id` y `nombre`) junto con las referencias a sus nodos hijos (`izquierdo` y `derecho`).
* **`ArbolInventario.java` (La Lógica):** Contiene la estructura del árbol y los métodos recursivos para:
  * **Insertar:** Ubica un nuevo producto a la izquierda si el ID es menor, o a la derecha si es mayor.
  * **Recorrido Inorden:** Visita la rama izquierda, imprime el nodo actual y luego la rama derecha, mostrando el inventario perfectamente ordenado de menor a mayor por ID.
  * **Buscar:** Localiza un producto por su ID aprovechando la propiedad de búsqueda del árbol.
* **`Main.java` (La Interfaz):** Menú interactivo en consola mediante un `switch` para que el usuario interactúe con el sistema. Incluye validaciones básicas de entrada y manejo automático de recursos (`try-with-resources`).

---

## Opciones del Menú

```text
==================================
    SISTEMA DE INVENTARIO TREE-STOCK
==================================
1. Registrar Producto  -> Solicita ID y nombre e inserta en el árbol.
2. Mostrar Inventario  -> Ejecuta el recorrido Inorden.
3. Buscar Producto     -> Consulta si existe un ID específico.
0. Salir               -> Finaliza la ejecución.