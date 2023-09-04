public class Lista {
    Nodo cabeza;
    Nodo cola;
    int size;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    // Método para insertar un nodo al final de la lista
    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(size,dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        size++;
    }
    public void insertarPorIndice(int indice, int dato) {
        if (indice < 0 || indice > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo nuevoNodo = new Nodo(dato);
        if (indice == 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        } else if (indice == size) {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        } else {
            Nodo nodoActual = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                nodoActual = nodoActual.siguiente;
            }
            nuevoNodo.siguiente = nodoActual.siguiente;
            nuevoNodo.anterior = nodoActual;
            nodoActual.siguiente.anterior = nuevoNodo;
            nodoActual.siguiente = nuevoNodo;
        }
        size++;
    }

    // Método para imprimir la lista en orden
    public void imprimirLista() {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.println("Índice: " + nodoActual.indice + ", Dato: " + nodoActual.dato);
            nodoActual = nodoActual.siguiente;
        }
    }
}









