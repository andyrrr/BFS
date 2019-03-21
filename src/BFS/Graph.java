package BFS;

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list 
// representation 
class Graph {
	int numNodos; // Numero de nodos
	LinkedList<Integer> listaAdyacente[]; //Lista con las aristas

	// Constructor
	Graph(int numVertices) {
		numNodos = numVertices;
		listaAdyacente = new LinkedList[numVertices];
		for (int i = 0; i < numVertices; ++i)
			listaAdyacente[i] = new LinkedList<>();
	}

	// Función para agregar arista y asignarle el destino
	void agregarArista(int nodo, int destino) {
		listaAdyacente[nodo].add(destino);
	}

	// Imprime el algoritmo BFS desde un nodo s
	void BFS(int actual) {
		// Marca los nodos como nodos no visitados
		boolean visitados[] = new boolean[numNodos];

		// Crea una lista de espera para el algoritmo
		LinkedList<Integer> listaEspera = new LinkedList<Integer>();

		// Marca el nodo temp como visitado
		visitados[actual] = true;
		listaEspera.add(actual);

		String camino = "";

		while (listaEspera.size() != 0) {
			// Saca el nodo de la lista y lo imprime
			actual = listaEspera.poll();
			camino = camino + actual + " ";
			System.out.print("Nodo: " + actual+"\n");

			// Busca todos los nodos adyacentes del nodo actual
			// Si el nodo adyacente no ha sido visitado, lo agrega
			Iterator<Integer> nodoActual = listaAdyacente[actual].listIterator();
			while (nodoActual.hasNext()) {
				int nodoSiguiente = nodoActual.next();
				if (!visitados[nodoSiguiente]) {
					visitados[nodoSiguiente] = true;
					listaEspera.add(nodoSiguiente);
					System.out.println("Cola: " + listaEspera+"\n");
				}
			}
		}
		System.out.println("Camino con nodo: "+actual);
		System.out.println(camino);
	}

	public static void main(String args[]) {
		Graph g = new Graph(25);

		g.agregarArista(0, 1);
		g.agregarArista(0, 5);
		g.agregarArista(1, 0);
		g.agregarArista(1, 2);
		g.agregarArista(2, 1);
		g.agregarArista(2, 7);
		g.agregarArista(2, 3);
		g.agregarArista(3, 2);
		g.agregarArista(3, 4);
		g.agregarArista(4, 3);
		g.agregarArista(4, 9);
		g.agregarArista(5, 0);
		g.agregarArista(5, 10);
		g.agregarArista(7, 2);
		g.agregarArista(7, 12);
		g.agregarArista(9, 4);
		g.agregarArista(9, 14);
		g.agregarArista(10, 5);
		g.agregarArista(10, 15);
		g.agregarArista(12, 7);
		g.agregarArista(12, 17);
		g.agregarArista(14, 9);
		g.agregarArista(14, 19);
		g.agregarArista(15, 10);
		g.agregarArista(15, 20);
		g.agregarArista(17, 12);
		g.agregarArista(17, 22);
		g.agregarArista(19, 14);
		g.agregarArista(19, 24);
		g.agregarArista(20, 15);
		g.agregarArista(20, 21);
		g.agregarArista(21, 20);
		g.agregarArista(21, 22);
		g.agregarArista(22, 21);
		g.agregarArista(22, 23);
		g.agregarArista(22, 17);
		g.agregarArista(24, 23);
		g.agregarArista(24, 19);
		
		g.BFS(6);
		g.BFS(10);
		g.BFS(2);
		g.BFS(23);
	}

}
