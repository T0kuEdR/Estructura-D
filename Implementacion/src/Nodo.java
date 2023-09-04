public class Nodo {
    int dato;
    int indice;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(int dato,int indice) {
        this.indice = indice;
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo(int dato) {
        this.dato = dato;
    }
}


