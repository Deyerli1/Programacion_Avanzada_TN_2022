package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GrafoMatriz extends Grafo {

	private int[][] matrizAdj;
	private int cantNodos;
	private int[] padresArray;
	private int[] distancias;
	private int padresKruskal[];
	private ArrayList<Nodo> nodosLista;
	private PriorityQueue<Conexion> conexionesLista;
	private boolean visitadosDFS[];
	private int cantSubgrafos;
	private int[] subGrafos;
	private int pesoMinimoKruskal;
	private int conexionesMax;

	public GrafoMatriz(int[][] matrizAdj, int cantNodos) {

		this.matrizAdj = matrizAdj;
		this.cantNodos = cantNodos;

	}

	public int[] bfsInterno(int inicio) {
		LinkedList<Integer> nodoCola = new LinkedList<Integer>();
		boolean[] visitados = new boolean[cantNodos];
		int[] recorrido = new int[cantNodos + 1];

		for (int i = 0; i < cantNodos; i++) {
			visitados[i] = false;
			recorrido[i] = -1;
		}

		nodoCola.add(inicio);

		while (!nodoCola.isEmpty()) {
			int nodo = nodoCola.poll();
			visitados[nodo] = true;
			int[] vecinos = matrizAdj[nodo];

			for (int i = 0; i < cantNodos; i++) {
				if (!visitados[i] && vecinos[i] > 0) {
					nodoCola.add(vecinos[i]);
					visitados[i] = true;
					recorrido[i] = nodo;
				}
			}

		}

		return recorrido;
	}
	
	@Override
	public ArrayList<Integer> bfs(int start, int end) {
		
		int[] recorrido = bfsInterno(start);
		
		ArrayList<Integer> path = new ArrayList<>();
		for (int at = end; at != -1; at = recorrido[at]) {
			path.add(at);
		}
		Collections.reverse(path);
		if (path.get(0) == start)
			return path;
		
		path.clear();
		return path;
	}

	public int bfsGrid(int inicio) {
		PriorityQueue<Nodo> nodoPQ = new PriorityQueue<Nodo>();
		boolean[] visitados = new boolean[cantNodos+1];
		boolean terminado = false;
		int nodosEnCapa = 1;
		int nodosEnProximaCapa = 0;
		int recorridos = 0;

		if (nodosLista == null) {
			crearListaNodos();
		}

		Nodo inicial = nodosLista.get(inicio);
		Nodo ultimo = nodosLista.get(cantNodos - 1);

		nodoPQ.add(inicial);

		while (!nodoPQ.isEmpty()) {
			
			Nodo actual = nodoPQ.poll();

			visitados[actual.getID()] = true;
			
			if (actual.comparar(ultimo)) {
				terminado = true;
				break;
			}

//			for (int i = 0; i < cantNodos; i++) {
//
//				int vecino = matrizAdj[actual.getID()][i];
//				
//				if (vecino != 0 && !visitados[i]) {
//					nodoPQ.add(nodosLista.get(i));
//					nodosEnProximaCapa++;
//					visitados[i] = true;
//				}
//			}
//			
			for(int vecino : actual.getArrayAdj()) {
				
				if (vecino != 0 && !visitados[vecino]) {
					nodoPQ.add(nodosLista.get(vecino));
					nodosEnProximaCapa++;
					visitados[vecino] = true;
				}
				
			}

			nodosEnCapa--;

			if (nodosEnCapa == 0) {
				nodosEnCapa = nodosEnProximaCapa;
				nodosEnProximaCapa = 0;
				recorridos++;
			}

			if (terminado) {
				return recorridos;
			}

		}

		return -1;
	}
	
	

	@Override
	public void dfs(int inicio) {

		visitadosDFS = new boolean[cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			visitadosDFS[i] = false;
		}
		dfsCiclo(inicio);
	}

	private void dfsCiclo(int inicio) {

		if (visitadosDFS[inicio - 1]) {
			return;
		}

		visitadosDFS[inicio - 1] = true;
		subGrafos[inicio] = cantSubgrafos;

		int[] vecinos = nodosLista.get(inicio).getArrayAdj();
		for (int i = 0; i < cantNodos; i++) {
			if (vecinos[i] > 0) {
				dfsCiclo(vecinos[i]);
			}
		}
	}

	public int buscarSubgrafos() {

		for (int i = 0; i < visitadosDFS.length; i++) {
			visitadosDFS[i] = false;
		}

		cantSubgrafos = 0;

		for (int i = 0; i < cantNodos; i++) {
			if (!visitadosDFS[i]) {
				cantSubgrafos++;
				dfs(i);
			}
		}

		return cantSubgrafos;
	}

	public int[] dijkstra(int inicio, int fin) {

		if (distancias != null) {
			return distancias;
		} // ????

		boolean visitado[] = new boolean[cantNodos + 1];
		padresArray = new int[cantNodos + 1];
		distancias = new int[cantNodos + 1];
		for (int i = 0; i <= cantNodos; i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			padresArray[i] = -1;
			visitado[i] = false;
		}

		distancias[inicio] = 0;
		padresArray[inicio] = -1;
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(inicio, distancias[inicio]));

		while (!pq.isEmpty()) {
			Nodo actual = pq.poll();
			visitado[actual.getID()] = true;

			if (distancias[actual.getID()] < actual.getDistancia()) {
				continue;
			}

			for (int vecino = 0; vecino < cantNodos; vecino++) {
				int pesoVecino = matrizAdj[actual.getID()][vecino];
				if (pesoVecino > 0) { // O en su caso cualquier condicion que indice coneccion
					if (!visitado[vecino]) {
						int nuevaDist = distancias[actual.getID()] + pesoVecino;
						if (nuevaDist < distancias[vecino]) // Para el caso de grafos no ponderados esto es siempre true, creo
						distancias[vecino] = nuevaDist;
						pq.add(new Nodo(vecino, nuevaDist));
						padresArray[vecino] = actual.getID();
					}
				}
			}
			if (actual.getID() == fin) {
				return distancias;
			}
		}
		return null;
	}

	@Override
	public int[] dijkstra(int inicio) {
		boolean visitado[] = new boolean[cantNodos + 1];
		padresArray = new int[cantNodos + 1];
		distancias = new int[cantNodos + 1];
		for (int i = 0; i <= cantNodos; i++) {
			distancias[i] = Integer.MAX_VALUE - 1000;
			padresArray[i] = -1;
			visitado[i] = false;
		}

		distancias[inicio] = 0;
		padresArray[inicio] = -1;
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(inicio, distancias[inicio]));

		while (!pq.isEmpty()) {
			Nodo actual = pq.poll();
			visitado[actual.getID()] = true;

			if (distancias[actual.getID()] < actual.getDistancia()) {
				continue;
			}

			for (int vecino = 0; vecino < cantNodos; vecino++) {
				int pesoVecino = matrizAdj[actual.getID()][vecino];
				if (pesoVecino > 0) { // O en su caso cualquier condicion que indice coneccion
					if (!visitado[vecino]) {
						int nuevaDist = distancias[actual.getID()] + pesoVecino;
						if (nuevaDist < distancias[vecino]) // Para el caso de grafos no ponderados esto es siempre true, creo
						distancias[vecino] = nuevaDist;
						pq.add(new Nodo(vecino, nuevaDist));
						padresArray[vecino] = actual.getID();
					}
				}
			}

		}

		return distancias;
	}
/* DJISKTRA PSEUDOCODE
 * 
 * g = lista o matriz de adj, n nodos de grafo, s = nodo inicio
 * e (opcional) si se quiere encontrar solamente el camino a 1 nodo
 * djikstra(g , n, s) (e)
 * 
 * vis[] = false # tam n+1
 * prev[] = false # tam n+1
 * dist[] = infinito # tam n+1
 * PQ = PrirityQueue
 * dist[s] = 0
 * pq.insertar((s,dist[s]) # la tupla (x,dist[x]) es el nodo al que quiero ir prox, y el costo de ir a ese nodo
 * 
 * while( pq.size != 0)
 *  actual = pq.poll() O indice,peso = pq.poll
 * 	vis[actual.indice] = true
 * 	if dist[indice] < actual.peso  // Ya tengo una distancia mas corta a este nodo, lo ignoro
 * 		continue
 * for(coneccion in g)
 * 	if vis[connecion.hasta]: 
 * 		continue // Nodo ya fue visitado, camino mas corto encontrado, ignoro
 * 
 * nuevoPeso = dist[actual.indice] + connecion.peso
 * if nuevoPeso < dist[connecion.hasta] # si la nueva distancia al vecino es menor que la distancia que ya existe, cambio valores
 * 		dist[connecion.hasta] = nuevoPeso
 * 		pq.insertar((connecion.hasta, nuevoPeso)
 *
 * OPCIONAL if actual.indice == e
 * 	return dist[e];
 * 
 * 
 */

	public ArrayList<Integer> caminoDijkstra(int nodoInicial, int nodoFinal) {

		ArrayList<Integer> camino = new ArrayList<Integer>();

		if (distancias == null) {
			dijkstra(nodoInicial, nodoFinal);
		}

		if (distancias[nodoInicial] == nodoFinal) {
			camino.add(0); 
			return camino;
		} // No entiendo que hace, lo sacaria.
		
		if(distancias[nodoFinal] == (int)Double.POSITIVE_INFINITY) {
			return null; // No se puede llegar al nodo final, devuelve null.
		}

		for (int actual = nodoFinal; actual != -1; actual = padresArray[actual]) {
			camino.add(actual);
		}

		Collections.reverse(camino);

		return camino;

	}

	public int kruskal() {
		conexionesLista = new PriorityQueue<Conexion>();

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				Conexion conexion = new Conexion(i + 1, j + 1, matrizAdj[i][j]);
				conexionesLista.add(conexion);
			}
		}

		padresKruskal = new int[cantNodos + 1];

		for (int i = 1; i <= cantNodos; i++) {
			padresKruskal[i] = i;
		}

		conexionesMax = 0;
		pesoMinimoKruskal = 0;

		while (!conexionesLista.isEmpty() && conexionesMax < cantNodos) {
			Conexion conexion = conexionesLista.poll();
			int padreSalida = buscarPadre(conexion.getSalida());
			int padreDestino = buscarPadre(conexion.getDestino());

			if (padreSalida != padreDestino) {
				padresKruskal[padreSalida] = padreDestino;
				conexionesMax++;
				pesoMinimoKruskal += conexion.getPeso();
			}

		}

		return pesoMinimoKruskal;

	}

	private int buscarPadre(int nodo) {

		if (padresKruskal[nodo] == nodo) {
			return nodo;
		}
		return buscarPadre(padresKruskal[nodo]);
	}

	private void crearListaNodos() {

		nodosLista = new ArrayList<Nodo>();

		for (int i = 0; i < cantNodos; i++) {
			Nodo nodo = new Nodo(i + 1, matrizAdj[i]);
			nodosLista.add(nodo);
		}
	}
	
/* FLOYD PSEUDO
 * floyd (m)
 * n = cantNodos , dp Matriz solucion es decir distancias, next = Matriz de padres/recorridos
 *  setup(m) 
 *  
 *  for k = 0, k < n 
 *  	for i in n
 *  		for j in n
 *  			if (dp[i][k] + dp[k][j] < dp[i][j]:
 *  				dp[i][j] = dp[i][k] + dp[k][j]
 *  				next[i][j] = next[i][k]
 *  
 * setup(m) { 
 *  dp = matriz nxn
 *  next = matriz nxn
 *  for i in n # Copiamos la matriz a DP y armamos los caminos en next 
 *  	for j in n
 *  		dp[i][j] = m[i][j]
 *  		if m[i][j] != INFINITO
 *  			next[i][j] = j
 *  }
 * 
 * 
 */
	
}

class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
 
    //Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    //Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v); //Graph is undirected
    }
 
    // Assigns colors (starting from 0) to all vertices and
    // prints the assignment of colors
    void greedyColoring()
    {
        int result[] = new int[V];
 
        // Initialize all vertices as unassigned
        Arrays.fill(result, -1);
 
        // Assign the first color to first vertex
        result[0]  = 0;
 
        // A temporary array to store the available colors. False
        // value of available[cr] would mean that the color cr is
        // assigned to one of its adjacent vertices
        boolean available[] = new boolean[V];
         
        // Initially, all colors are available
        Arrays.fill(available, true);
 
        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++)
        {
            // Process all adjacent vertices and flag their colors
            // as unavailable
            Iterator<Integer> it = adj[u].iterator() ;
            while (it.hasNext())
            {
                int i = it.next();
                if (result[i] != -1)
                    available[result[i]] = false;
            }
 
            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++){
                if (available[cr])
                    break;
            }
 
            result[u] = cr; // Assign the found color
 
            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }
 
        // print the result
        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color "
                                + result[u]);
    }
 
