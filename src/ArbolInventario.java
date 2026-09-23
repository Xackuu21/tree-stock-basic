public class ArbolInventario {
    private Producto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    // ----------------------------------------------------------------------------------------------------------
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        if (actual == null) {
            return new Producto(id, nombre);
        }

        if (id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } 
        else if (id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        } 
        else {
            System.out.println("Error: El ID " + id + " ya existe en el inventario.");
        }

        return actual;
    }

    // ----------------------------------------------------------------------------------------------------------
    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
        } else {
            inordenRecursivo(raiz);
        }
    }

    private void inordenRecursivo(Producto actual) {
        if (actual != null) {
            inordenRecursivo(actual.izquierdo);
            System.out.println("ID: " + actual.id + " | Nombre: " + actual.nombre);
            inordenRecursivo(actual.derecho);
        }
    }

    // ----------------------------------------------------------------------------------------------------------
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(Producto actual, int id) {
        if (actual == null || actual.id == id) {
            return actual;
        }

        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }
        return buscarRecursivo(actual.derecho, id);
    }
}