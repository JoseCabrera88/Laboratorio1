import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    private Nodo inicio;

    public ListaEnlazada() {
        this.inicio = null;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = inicio;
        inicio = nuevoNodo;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
            return;
        }
        Nodo temp = inicio;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevoNodo;
    }

    public void recorrer() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    public boolean buscarElemento(int dato) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.dato == dato) {
                return true;
            }
            temp = temp.siguiente;
        }
        return false;
    }

    public void borrarElemento(int dato) {
        if (inicio == null) {
            return;
        }
        if (inicio.dato == dato) {
            inicio = inicio.siguiente;
            return;
        }
        Nodo temp = inicio;
        while (temp.siguiente != null && temp.siguiente.dato != dato) {
            temp = temp.siguiente;
        }
        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion, dato;
        do {
            System.out.println("Lista enlazada:");
            System.out.println("1) Insertar al inicio");
            System.out.println("2) Insertar al final");
            System.out.println("3) Recorrer");
            System.out.println("4) Buscar elemento");
            System.out.println("5) Borrar un elemento");
            System.out.println("6) Salir del programa");
            System.out.print("Ingrese la opción que desea: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el dato que desea insertar al inicio: ");
                    dato = scanner.nextInt();
                    lista.insertarAlInicio(dato);
                }
                case 2 -> {
                    System.out.print("Ingrese el dato que desea insertar al final: ");
                    dato = scanner.nextInt();
                    lista.insertarAlFinal(dato);
                }
                case 3 -> {
                    System.out.print("Elementos de la lista: ");
                    lista.recorrer();
                }
                case 4 -> {
                    System.out.print("Ingrese el elemento que quiere buscar: ");
                    dato = scanner.nextInt();
                    if (lista.buscarElemento(dato)) {
                        System.out.println("El elemento si se encuentra en la lista.");
                    } else {
                        System.out.println("El elemento no se encuentra en la lista.");
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese el elemento que quiere borrar: ");
                    dato = scanner.nextInt();
                    lista.borrarElemento(dato);
                }
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
        scanner.close();
    }
}