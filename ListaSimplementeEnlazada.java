package listadoble;

// ===============================================
// ACTIVIDAD EN CLASE: Lista Simplemente Enlazada
// Materia: Estructura de Datos
// Descripción: Implementación de una lista simplemente enlazada
//              basada en el pseudocódigo trabajado en clase.
// Autor: Nataly Victoria González Aviles - GTID0141
// ===============================================

class NodoSimple {
    String dato;
    NodoSimple sig;

    // Constructor del nodo
    public NodoSimple(String valor) {
        dato = valor;
        sig = null;
    }
}

public class ListaSimplementeEnlazada {
    NodoSimple inicio;

    // Creación de la lista
    public void crearLista() {
        NodoSimple Ana = new NodoSimple("Ana");
        NodoSimple Benjamin = new NodoSimple("Benjamín");
        NodoSimple Carla = new NodoSimple("Carla");
        NodoSimple Diego = new NodoSimple("Diego");

        // Enlaces
        Ana.sig = Benjamin;
        Benjamin.sig = Carla;
        Carla.sig = Diego;
        Diego.sig = null;

        inicio = Ana;
    }

    // Inserción: Elena entre Carla y Diego
    public void insertarElena() {
        NodoSimple nuevo = new NodoSimple("Elena");
        NodoSimple aux = inicio;
        while (aux != null) {
            if (aux.dato.equals("Carla")) {
                nuevo.sig = aux.sig;
                aux.sig = nuevo;
                System.out.println("Se insertó 'Elena' entre Carla y Diego.\n");
                break;
            }
            aux = aux.sig;
        }
    }

    // Inserción: Dalia al final
    public void insertarDalia() {
        NodoSimple nuevo = new NodoSimple("Dalia");
        NodoSimple aux = inicio;
        while (aux.sig != null) {
            aux = aux.sig;
        }
        aux.sig = nuevo;
        System.out.println("Se insertó 'Dalia' al final.\n");
    }

    // Eliminación: Benjamín
    public void eliminarBenjamin() {
        NodoSimple aux = inicio;
        while (aux.sig != null) {
            if (aux.sig.dato.equals("Benjamín")) {
                aux.sig = aux.sig.sig;
                System.out.println("Se eliminó 'Benjamín' de la lista.\n");
                break;
            }
            aux = aux.sig;
        }
    }

    // Recorrer la lista
    public void recorrer() {
        NodoSimple aux = inicio;
        System.out.print("Lista: ");
        while (aux != null) {
            System.out.print("[" + aux.dato + "] → ");
            aux = aux.sig;
        }
        System.out.println("NULL");
    }

    // Programa principal
    public static void main(String[] args) {
        ListaSimplementeEnlazada lista = new ListaSimplementeEnlazada();

        // 1. Crear la lista
        lista.crearLista();
        lista.recorrer();

        // 2. Insertar "Elena"
        lista.insertarElena();
        lista.recorrer();

        // 3. Insertar "Dalia"
        lista.insertarDalia();
        lista.recorrer();

        // 4. Eliminar "Benjamín"
        lista.eliminarBenjamin();
        lista.recorrer();
    }
}

