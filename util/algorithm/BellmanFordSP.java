package co.edu.unbosque.util.algorithm;
import java.	util.Scanner;

import co.edu.unbosque.util.MyLinkedList;
import co.edu.unbosque.util.Vertex;

public class BellmanFordSP {
    public static final int MAX = 105;
    public static final int INF = 1 << 30;
    public static int[] previous = new int[MAX];
    public static int[] distance = new int[MAX];
    public static int vertices;
    public static MyLinkedList<MyLinkedList<Vertex>> adyacencia = new MyLinkedList<MyLinkedList<Vertex>>();
    public static Scanner sc = new Scanner(System.in);

    public static int[] getPrevious() {
		return previous;
	}

	public static void setPrevious(int[] previous) {
		BellmanFordSP.previous = previous;
	}

	public static int[] getDistance() {
		return distance;
	}

	public static void setDistance(int[] distance) {
		BellmanFordSP.distance = distance;
	}

	public static int getVertices() {
		return vertices;
	}

	public static void setVertices(int vertices) {
		BellmanFordSP.vertices = vertices;
	}

	public static MyLinkedList<MyLinkedList<Vertex>> getAdyacencia() {
		return adyacencia;
	}

	public static void setAdyacencia(MyLinkedList<MyLinkedList<Vertex>> adyacencia) {
		BellmanFordSP.adyacencia = adyacencia;
	}

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		BellmanFordSP.sc = sc;
	}

	public static int getMax() {
		return MAX;
	}

	public static int getInf() {
		return INF;
	}

	public static void inicializacion() {
        for (int i = 0; i <= vertices; i++) {
            distance[i] = INF;
            previous[i] = -1;
        }
    }

    public static void print(int destino) {
        if (previous[destino] != -1) {
            print(previous[destino]);
        }
        System.out.printf("%d ", destino);
    }

    public static boolean relajacion(int actual, int adyacente, int peso) {
        if (distance[actual] + peso < distance[adyacente]) {
            distance[adyacente] = distance[actual] + peso;
            previous[adyacente] = actual;
            return true;
        }
        return false;
    }

    public static void bellmanFord(int inicial) {
        inicializacion();
        distance[inicial] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            for (int actual = 0; actual < vertices; actual++) {
                for (int j = 0; j < adyacencia.get(actual).getInfo().size(); j++) {
                    int adyacente = adyacencia.get(actual).getInfo().get(j).getInfo().getFirst();
                    int peso = adyacencia.get(actual).getInfo().get(j).getInfo().getSecond();
                    relajacion(actual, adyacente, peso);
                }
            }
        }
        for (int actual = 0; actual < vertices; actual++) {
            for (int j = 0; j < adyacencia.get(actual).getInfo().size(); j++) {
                int adyacente = adyacencia.get(actual).getInfo().get(j).getInfo().getFirst();
                int peso = adyacencia.get(actual).getInfo().get(j).getInfo().getSecond();
                if (relajacion(actual, adyacente, peso)) {
                    System.out.println("Existe ciclo negativo");
                    return;
                }
            }
        }
        System.out.println("No existe ciclo negativo");
        System.out.printf("distancias más cortas iniciando en el nodo %d\n", inicial);
        for (int i = 0; i < vertices; i++) {
            System.out.printf("Nodo %d , distanceimás corta = %d\n", i, distance[i]);
        }
    }

}