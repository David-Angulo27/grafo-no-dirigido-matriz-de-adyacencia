import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/** Grafo no dirigido implementado con una matriz de adyacencia, con DFS y BFS. */
public class GrafoNoDirigido {
    private final String[] vertices;   // el índice en el arreglo identifica al vértice
    private final int[][] matriz;      // 0 = sin arista, 1 = hay arista

    public GrafoNoDirigido(String... vertices) {
        this.vertices = vertices;
        this.matriz = new int[vertices.length][vertices.length];
    }

    private int indice(String v) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(v)) return i;
        }
        throw new IllegalArgumentException("El vértice '" + v + "' no existe");
    }

    /** Conecta a y b. Al ser no dirigido, se marcan (a,b) y (b,a). */
    public void agregarArista(String a, String b) {
        int i = indice(a), j = indice(b);
        matriz[i][j] = 1;
        matriz[j][i] = 1;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void mostrarMatriz() {
        System.out.print("    ");
        for (String v : vertices) System.out.printf("%2s ", v);
        System.out.println();
        for (int i = 0; i < vertices.length; i++) {
            System.out.printf("%2s  ", vertices[i]);
            for (int j = 0; j < vertices.length; j++) System.out.printf("%2d ", matriz[i][j]);
            System.out.println();
        }
    }

    /** Recorrido en profundidad (usa una pila explícita). */
    public List<String> dfs(String inicio) {
        boolean[] visitados = new boolean[vertices.length];
        List<String> orden = new ArrayList<>();
        Deque<Integer> pila = new ArrayDeque<>();
        pila.push(indice(inicio));
        while (!pila.isEmpty()) {
            int i = pila.pop();
            if (visitados[i]) continue;
            visitados[i] = true;
            orden.add(vertices[i]);
            // Se recorre en reversa para que el vecino de menor índice quede arriba de la pila.
            for (int j = vertices.length - 1; j >= 0; j--) {
                if (matriz[i][j] == 1 && !visitados[j]) pila.push(j);
            }
        }
        return orden;
    }

    /** Recorrido en anchura (usa una cola). */
    public List<String> bfs(String inicio) {
        boolean[] visitados = new boolean[vertices.length];
        List<String> orden = new ArrayList<>();
        Queue<Integer> cola = new ArrayDeque<>();
        int i0 = indice(inicio);
        visitados[i0] = true;
        cola.add(i0);
        while (!cola.isEmpty()) {
            int i = cola.poll();
            orden.add(vertices[i]);
            for (int j = 0; j < vertices.length; j++) {
                if (matriz[i][j] == 1 && !visitados[j]) {
                    visitados[j] = true;
                    cola.add(j);
                }
            }
        }
        return orden;
    }
}
