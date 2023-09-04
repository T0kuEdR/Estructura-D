public class ListaCircular {
    Nodo cabeza;
    int tamano;

    public ListaCircular() {
        this.cabeza = null;
        this.tamano = 0;
    }

    // Agregar un elemento a la lista circular
    public void agregar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza; // Hacer que el primer nodo apunte a sí mismo
        } else {
            Nodo ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza; // Hacer que el nuevo nodo apunte a la cabeza
        }
        tamano++;
    }

    // Imprimir la lista circular
    public void imprimirLista() {
        if (tamano == 0) {
            System.out.println("La lista esta vaciaa");
            return;
        }
        Nodo actual = cabeza;
        int indice = 0;
        do {
            System.out.println("Indice " + indice + ": " + actual.dato);
            actual = actual.siguiente;
            indice++;
        } while (actual != cabeza);

    }

    // Eliminar un elemento en base al índice
    public void eliminarElemento(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }

        if (tamano == 1) {
            cabeza = null;
        } else if (indice == 0) {
            // Eliminar la cabeza
            Nodo ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            cabeza = cabeza.siguiente;
            ultimo.siguiente = cabeza;
        } else {
            Nodo anterior = cabeza;
            for (int i = 0; i < indice - 1; i++) {
                anterior = anterior.siguiente;
            }
            anterior.siguiente = anterior.siguiente.siguiente;
        }

        tamano--;
    }

    public int obtenerTamano() {
        return tamano;
    }

    public int obtenerElemento(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }
    public void moverIzquierda(int pasos) {
        if (tamano == 0) {
            System.out.println("La lista está vacía");
            return;
        }

        for (int i = 0; i < pasos; i++) {
            cabeza = cabeza.siguiente;
        }
    }

    // Moverse hacia la derecha en la lista circular
    public void moverDerecha(int pasos) {
        if (tamano == 0) {
            System.out.println("La lista está vacía");
            return;
        }

        for (int i = 0; i < pasos; i++) {
            Nodo ultimo = cabeza;
            while (ultimo.siguiente != cabeza) {
                ultimo = ultimo.siguiente;
            }
            cabeza = ultimo;
        }
    }
}
