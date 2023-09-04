
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Lista lista = new Lista();
        ListaSimple listaS = new ListaSimple();
        ListaCircular listaC = new ListaCircular();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Que lista desea probar? Escriba segun sea el caso (S: Simple, D: Doble, C: Circular) ");
        String Lista = scanner.next();
        if (Lista.equals("S")) {

            while (true) {
                System.out.println("Ingresa un numero o escribe '-1' para salir :");
                int numero = scanner.nextInt();
                if (numero == -1) {
                    break;
                }
                listaS.agregar(numero);
            }

            System.out.println("La lista queda asi: ");
            lista.imprimirLista();

            // Obtener el tamaño de la lista
            int tamano = listaS.obtenerTamano();
            System.out.println("Tamano de la lista: " + tamano);

            // Eliminar elementos en base al índice
            while (true) {
                System.out.println("Quieres eliminar un elemento? (Si: 1 / No: 0): ");
                int eliminar = scanner.nextInt();
                if (eliminar == 0) {
                    System.out.println("No se elimino ningun elemento");
                    break;
                }

                System.out.println("Ingresa el indice del elemento que deseas eliminar: ");
                int indiceEliminar = scanner.nextInt();
                if (indiceEliminar >= 0 && indiceEliminar < tamano) {
                    listaS.eliminarElemento(indiceEliminar);
                    System.out.println("Elemento eliminado correctamente.");
                } else {
                    System.out.println("Indice fuera de rango. No se pudo eliminar ningún elemento.");
                }

            }

            System.out.println("La lista queda asi despues de los movimientos");
            lista.imprimirLista();

            scanner.close();
        }else if (Lista.equals("D")) {
            //lista doble
            while (true) {
                System.out.println("Elija una opción:");
                System.out.println("1. Insertar al final");
                System.out.println("2. Insertar por índice");
                System.out.println("3. Salir");

                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    System.out.print("Ingrese el valor a insertar al final: ");
                    int valor = scanner.nextInt();
                    lista.insertarAlFinal(valor);
                } else if (opcion == 2) {
                    System.out.print("Ingrese el índice: ");
                    int indice = scanner.nextInt();
                    System.out.print("Ingrese el valor a insertar: ");
                    int valor = scanner.nextInt();
                    lista.insertarPorIndice(indice, valor);
                } else if (opcion == 3) {
                    break;
                } else {
                    System.out.println("Opción no válida");
                }
                System.out.println("Lista en orden:");
                lista.imprimirLista();
            }


        } else if (Lista.equals("C")) {
            ListaCircular lista1 = new ListaCircular();


            while (true) {
                System.out.println("Ingresa un numero o escribe '-1' para salir:");
                int numero = scanner.nextInt();
                if (numero == -1) {
                    break;
                }
                lista1.agregar(numero);
            }

            System.out.println("La lista circular queda asi:");
            lista1.imprimirLista();

            while (true) {
                System.out.println("Quieres eliminar un elemento? (Si: 1 / No: 0):");
                int eliminar = scanner.nextInt();
                if (eliminar == 0) {
                    break;
                }

                System.out.println("Ingresa el Indice del elemento que deseas eliminar:");
                int indiceEliminar = scanner.nextInt();
                if (indiceEliminar >= 0 && indiceEliminar < listaC.obtenerTamano()) {
                    listaC.eliminarElemento(indiceEliminar);
                    System.out.println("Elemento eliminado correctamente.");
                } else {
                    System.out.println("Indice fuera de rango. No se pudo eliminar ningún elemento.");
                }

                System.out.println("La lista circular queda asi despues de eliminar:");
                lista1.imprimirLista();
            }
            // Mostrar la lista circular con índices


            while (true) {
                System.out.println("¿Quieres moverte en la lista? (Si: 1 / No: 0):");
                int mover = scanner.nextInt();
                if (mover == 0) {
                    break;
                }

                System.out.println("Cuantos pasos te quieres mover? (Negativos izquierda, Positivos derecha):");
                int pasos = scanner.nextInt();

                if (pasos < 0) {
                    lista1.moverIzquierda(-pasos);
                } else {
                    lista1.moverDerecha(pasos);
                }

                System.out.println("La lista circular queda asi después de moverte:");
                lista1.imprimirLista();
            }

            scanner.close();

        } else {
            System.out.println("Opción no válida");
        }
    }

}



