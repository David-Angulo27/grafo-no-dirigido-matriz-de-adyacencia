"""Ejemplo de uso: construye un grafo, muestra su matriz y ejecuta DFS y BFS."""
from grafo import GrafoNoDirigido

g = GrafoNoDirigido(["A", "B", "C", "D", "E", "F"])
for a, b in [("A", "B"), ("A", "C"), ("B", "D"), ("B", "E"), ("C", "F"), ("E", "F")]:
    g.agregar_arista(a, b)

print("Matriz de adyacencia:")
g.mostrar_matriz()
print("\nDFS desde A:", " -> ".join(g.dfs("A")))
print("BFS desde A:", " -> ".join(g.bfs("A")))
