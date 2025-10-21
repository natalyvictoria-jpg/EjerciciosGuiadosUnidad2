package listadoble;

// ===============================================
// ACTIVIDAD EN CLASE: Lista Doblemente Enlazada
// Materia: Estructura de Datos
// Descripción: Implementación de una lista doblemente enlazada
//              basada en el pseudocódigo trabajado en clase.
// Autor: Nataly Victoria González Aviles - GTID0141
// ===============================================

class Nodo {
    String dato;
    Nodo ant;
    Nodo sig;

    // Constructor del nodo
    public Nodo(String d) {
        dato = d;
        ant = null;
        sig = null;
    }
}

public class ListaDoblementeEnlazada {
    Nodo inicio;

    // Creación de la lista según el pseudocódigo
    public void crearLista() {
        Nodo programacion = new Nodo("Programación");
        Nodo matematicas = new Nodo("Matemáticas");
        Nodo ingles = new Nodo("Inglés");
        Nodo fisica = new Nodo("Física");

        // Enlaces hacia adelante
        programacion.sig = matematicas;
        matematicas.sig = ingles;
        ingles.sig = fisica;

        // Enlaces hacia atrás
        matematicas.ant = programacion;
        ingles.ant = matematicas;
        fisica.ant = ingles;

        // Asignar inicio
        inicio = programacion;
    }

    // Recorrido hacia adelante
    public void recorrerAdelante() {
        Nodo aux = inicio;
        System.out.print("Recorrido hacia adelante: ");
        while (aux != null) {
            System.out.print("[" + aux.dato + "] ↔ ");
            aux = aux.sig;
        }
        System.out.println("NULL");
    }

    // Recorrido hacia atrás
    public void recorrerAtras() {
        if (inicio == null) return;

        Nodo aux = inicio;
        // Avanza al último nodo
        while (aux.sig != null) {
            aux = aux.sig;
        }

        System.out.print("Recorrido hacia atrás: ");
        while (aux != null) {
            System.out.print("[" + aux.dato + "] ↔ ");
            aux = aux.ant;
        }
        System.out.println("NULL");
    }

    // Inserción al inicio (Historia)
    public void insertarInicio() {
        Nodo nuevo = new Nodo("Historia");
        nuevo.sig = inicio;
        inicio.ant = nuevo;
        inicio = nuevo;
        System.out.println("Se insertó 'Historia' al inicio.\n");
    }

    // Eliminación del nodo "Inglés"
    public void eliminarIngles() {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.dato.equals("Inglés")) {
                aux.ant.sig = aux.sig;
                aux.sig.ant = aux.ant;
                System.out.println("Se eliminó el nodo 'Inglés'.\n");
                break;
            }
            aux = aux.sig;
        }
    }

    // Método principal
    public static void main(String[] args) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        // 1. Crear la lista
        lista.crearLista();
        lista.recorrerAdelante();

        // 2. Insertar "Historia" al inicio
        lista.insertarInicio();
        lista.recorrerAdelante();

        // 3. Eliminar "Inglés"
        lista.eliminarIngles();
        lista.recorrerAdelante();

        // 4. Recorrer hacia atrás
        lista.recorrerAtras();
    }
}

