public class Producto {
    int id;
    String nombre;

    Producto izquierdo;
    Producto derecho;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }
}