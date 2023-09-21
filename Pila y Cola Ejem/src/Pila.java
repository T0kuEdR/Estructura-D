public class Pila {
    private Nodo cima;
    private int tamaño;

    private class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Pila() {
        cima = null;
        tamaño = 0;
    }
    public void push(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cima == null) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cima;
            cima = nuevoNodo;
        }
        tamaño++;
    }
    public int pop() {
        if (esVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        int valorCima = cima.dato;
        cima = cima.siguiente;
        tamaño--;
        return valorCima;
    }
    public int peek() {
        if (esVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return cima.dato;
    }
    public int busqueda(int elemento) {
        Nodo nodoActual = cima;
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
        Pila pila = new Pila();

        pila.push(1);
        pila.push(2);
        pila.push(3);

        System.out.println("Tamaño de la pila: " + pila.tamaño());
        System.out.println("Elemento en la cima: " + pila.peek());
        System.out.println("Posición del elemento 2 desde la cima: " + pila.busqueda(2));

        while (!pila.esVacia()) {
            System.out.println("Elemento eliminado de la cima: " + pila.pop());
        }
    }
}

