
package listadoble;
 
// ===============================================
// ACTIVIDAD EN CLASE: Lista Circular Simple
// Materia: Estructura de Datos
// Descripción: Implementación de una lista circular simple
//              basada en el pseudocódigo trabajado en clase.
// Autor: Nataly Victoria González Aviles - GTID0141
// ===============================================

class NodoCircular {
    String dato;
    NodoCircular sig;

    // Constructor
    public NodoCircular(String valor) {
        dato = valor;
        sig = null;
    }
}

public class ListaCircular {
    NodoCircular inicio;

    // Creación de la lista circular
    public void crearLista() {
        NodoCircular rojo = new NodoCircular("Rojo");
        NodoCircular verde = new NodoCircular("Verde");
        NodoCircular azul = new NodoCircular("Azul");
        NodoCircular amarillo = new NodoCircular("Amarillo");

        rojo.sig = verde;
        verde.sig = azul;
        azul.sig = amarillo;
        amarillo.sig = rojo; // Cierre circular

        inicio = rojo;
    }

    // Recorrido (una vuelta)
    public void recorrer() {
        if (inicio == null) return;

        NodoCircular aux = inicio;
        System.out.print("Lista circular: ");
        do {
            System.out.print("[" + aux.dato + "] → ");
            aux = aux.sig;
        } while (aux != inicio);
        System.out.println("(regresa a inicio)");
    }

    // Inserción (Morado entre Azul y Amarillo)
    public void insertarMorado() {
        NodoCircular aux = inicio;
        while (!aux.dato.equals("Azul")) {
            aux = aux.sig;
        }
        NodoCircular nuevo = new NodoCircular("Morado");
        nuevo.sig = aux.sig;
        aux.sig = nuevo;
        System.out.println("Se insertó 'Morado' entre Azul y Amarillo.\n");
    }

    // Eliminación (Verde)
    public void eliminarVerde() {
        NodoCircular aux = inicio;
        while (aux.sig != inicio) {
            if (aux.sig.dato.equals("Verde")) {
                aux.sig = aux.sig.sig;
                System.out.println("Se eliminó 'Verde' de la lista.\n");
                break;
            }
            aux = aux.sig;
        }
    }

    // Método principal
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        // 1. Crear lista
        lista.crearLista();
        lista.recorrer();

        // 2. Insertar "Morado"
        lista.insertarMorado();
        lista.recorrer();

        // 3. Eliminar "Verde"
        lista.eliminarVerde();
        lista.recorrer();
    }
}

