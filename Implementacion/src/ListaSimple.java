public class ListaSimple {

        Nodo cabeza;
        int tamano;
        public ListaSimple() {
            this.cabeza = null;
            this.tamano = 0;
        }

        // Agregar un elemento al principio de la lista
        public void agregar(int dato) {
            Nodo nuevoNodo = new Nodo(dato);
            if (cabeza ==  null) {
                cabeza = nuevoNodo;
//        	cabeza.siguiente = cabeza;
            }
            else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
            tamano++;
        }
        public int obtenerTamano() {
            return tamano;
        }

        public int obtenerElemento(int indice) {
            if (indice < 0 || indice >= tamano) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }
            Nodo actual = cabeza;
            for (int i = 0 ; i < indice; i++) {
                actual = actual.siguiente;
            }
            return actual.dato;
        }

        // imprimir la lista
        public void imprimirLista() {
            if (tamano == 0) {
                System.out.println("La lista está vacía");
                return;
            }
            Nodo actual = cabeza;
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
        public void eliminarElemento(int indice) {
            if (indice < 0 || indice >= tamano) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }

            if (indice == 0) {
                // Si el índice es 0, eliminar el primer elemento
                cabeza = cabeza.siguiente;
            } else {
                // Encontrar el nodo anterior al nodo a eliminar
                Nodo anterior = cabeza;
                for (int i = 0; i < indice - 1; i++) {
                    anterior = anterior.siguiente;
                }

                // Eliminar el nodo actual (nodo en la posición de índice)
                anterior.siguiente = anterior.siguiente.siguiente;
            }

            tamano--;
        }
    }

