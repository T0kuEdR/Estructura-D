public class Cola {
    private Nodo frente;
    private Nodo finalCola;
    private int tamaño;

    private class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Cola() {
        frente = null;
        finalCola = null;
        tamaño = 0;
    }

    public void push(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (esVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        tamaño++;
    }
    public int pop() {
        if (esVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        int valorFrente = frente.dato;
        frente = frente.siguiente;
        tamaño--;
        return valorFrente;
    }

    public int peek() {
        if (esVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return frente.dato;
    }

    public int busqueda(int elemento) {
        Nodo nodoActual = frente;
        int posicion = 1;
        while (nodoActual != null) {
            if (nodoActual.dato == elemento) {
                return posicion;
            }
            nodoActual = nodoActual.siguiente;
            posicion++;
        }
        return -1; // Elemento no encontrado
    }

    public boolean esVacia() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    public static void main(String[] args) {
        Cola cola = new Cola();

        cola.push(1);
        cola.push(2);
        cola.push(3);

        System.out.println("Tamaño de la cola: " + cola.tamaño());
        System.out.println("Elemento al frente de la cola: " + cola.peek());
        System.out.println("Posición del elemento 2 desde el frente: " + cola.busqueda(2));

        while (!cola.esVacia()) {
            System.out.println("Elemento eliminado al frente de la cola: " + cola.pop());
        }
    }
}
