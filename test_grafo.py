import unittest
from grafo import GrafoNoDirigido


def crear():
    g = GrafoNoDirigido(["A", "B", "C", "D", "E", "F"])
    for a, b in [("A", "B"), ("A", "C"), ("B", "D"), ("B", "E"), ("C", "F"), ("E", "F")]:
        g.agregar_arista(a, b)
    return g


class TestGrafo(unittest.TestCase):
    def test_creacion(self):
        g = GrafoNoDirigido(["A", "B"])
        self.assertEqual(g.matriz, [[0, 0], [0, 0]])

    def test_matriz_simetrica(self):
        g = crear()
        n = len(g.vertices)
        for i in range(n):
            for j in range(n):
                self.assertEqual(g.matriz[i][j], g.matriz[j][i])
        self.assertEqual(g.matriz[0], [0, 1, 1, 0, 0, 0])

    def test_dfs(self):
        self.assertEqual(crear().dfs("A"), ["A", "B", "D", "E", "F", "C"])

    def test_bfs(self):
        self.assertEqual(crear().bfs("A"), ["A", "B", "C", "D", "E", "F"])

    def test_vertice_invalido(self):
        with self.assertRaises(ValueError):
            crear().dfs("Z")


if __name__ == "__main__":
    unittest.main()
