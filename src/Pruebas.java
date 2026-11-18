import java.util.Arrays;
import java.util.List;

/** Pruebas simples sin librerías externas. Ejecutar: java -cp out Pruebas */
public class Pruebas {
    static int fallos = 0;

    static void verificar(String nombre, boolean ok) {
        System.out.println((ok ? "OK    " : "FALLO ") + nombre);
        if (!ok) fallos++;
    }

    public static void main(String[] args) {
        GrafoNoDirigido vacio = new GrafoNoDirigido("A", "B");
        verificar("creación: matriz inicial en ceros",
                Arrays.deepEquals(vacio.getMatriz(), new int[][]{{0, 0}, {0, 0}}));

        GrafoNoDirigido g = Main.crearEjemplo();
        int[][] m = g.getMatriz();
        boolean simetrica = true;
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m.length; j++)
                if (m[i][j] != m[j][i]) simetrica = false;
        verificar("matriz simétrica (no dirigido)", simetrica);
        verificar("fila de A correcta", Arrays.equals(m[0], new int[]{0, 1, 1, 0, 0, 0}));

        verificar("DFS desde A", g.dfs("A").equals(List.of("A", "B", "D", "E", "F", "C")));
        verificar("BFS desde A", g.bfs("A").equals(List.of("A", "B", "C", "D", "E", "F")));

        boolean lanzo = false;
        try { g.dfs("Z"); } catch (IllegalArgumentException e) { lanzo = true; }
        verificar("vértice inexistente lanza error", lanzo);

        if (fallos > 0) System.exit(1);
    }
}
