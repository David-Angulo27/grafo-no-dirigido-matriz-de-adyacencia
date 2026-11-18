/** Ejemplo: construye un grafo, muestra su matriz y ejecuta DFS y BFS. */
public class Main {
    public static GrafoNoDirigido crearEjemplo() {
        GrafoNoDirigido g = new GrafoNoDirigido("A", "B", "C", "D", "E", "F");
        String[][] aristas = {{"A","B"},{"A","C"},{"B","D"},{"B","E"},{"C","F"},{"E","F"}};
        for (String[] a : aristas) g.agregarArista(a[0], a[1]);
        return g;
    }

    public static void main(String[] args) {
        GrafoNoDirigido g = crearEjemplo();
        System.out.println("Matriz de adyacencia:");
        g.mostrarMatriz();
        System.out.println("\nDFS desde A: " + String.join(" -> ", g.dfs("A")));
        System.out.println("BFS desde A: " + String.join(" -> ", g.bfs("A")));
    }
}
