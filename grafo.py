"""Grafo no dirigido implementado con una matriz de adyacencia, con DFS y BFS."""
from collections import deque


class GrafoNoDirigido:
    def __init__(self, vertices):
        # Lista de nombres de los vértices; la posición en la lista es su índice.
        self.vertices = list(vertices)
        n = len(self.vertices)
        # Matriz n x n inicializada en 0 (0 = sin arista, 1 = hay arista).
        self.matriz = [[0] * n for _ in range(n)]

    def _indice(self, v):
        if v not in self.vertices:
            raise ValueError(f"El vértice '{v}' no existe")
        return self.vertices.index(v)

    def agregar_arista(self, a, b):
        """Conecta a y b. Al ser no dirigido, se marcan (a,b) y (b,a)."""
        i, j = self._indice(a), self._indice(b)
        self.matriz[i][j] = 1
        self.matriz[j][i] = 1

    def mostrar_matriz(self):
        print("    " + " ".join(f"{v:>2}" for v in self.vertices))
        for v, fila in zip(self.vertices, self.matriz):
            print(f"{v:>2}  " + " ".join(f"{x:>2}" for x in fila))

    def _vecinos(self, i):
        """Índices de los vecinos de i, leyendo la fila i de la matriz."""
        return [j for j, x in enumerate(self.matriz[i]) if x == 1]

    def dfs(self, inicio):
        """Recorrido en profundidad (usa una pila explícita)."""
        visitados = [False] * len(self.vertices)
        orden = []
        pila = [self._indice(inicio)]
        while pila:
            i = pila.pop()
            if visitados[i]:
                continue
            visitados[i] = True
            orden.append(self.vertices[i])
            # Se apilan en reversa para visitar primero el vecino de menor índice.
            for j in reversed(self._vecinos(i)):
                if not visitados[j]:
                    pila.append(j)
        return orden

    def bfs(self, inicio):
        """Recorrido en anchura (usa una cola)."""
        visitados = [False] * len(self.vertices)
        orden = []
        i0 = self._indice(inicio)
        visitados[i0] = True
        cola = deque([i0])
        while cola:
            i = cola.popleft()
            orden.append(self.vertices[i])
            for j in self._vecinos(i):
                if not visitados[j]:
                    visitados[j] = True
                    cola.append(j)
        return orden
