# Grafo no dirigido con matriz de adyacencia (DFS y BFS)

Proyecto académico de estructuras de datos en Java. Implementa un **grafo no dirigido** con **matriz de adyacencia** y los recorridos **DFS** y **BFS**.

## Grafo no dirigido
Las aristas no tienen dirección: si A está conectado con B, también B lo está con A.

## Matriz de adyacencia
Matriz `n x n` (n = número de vértices). `matriz[i][j] = 1` si hay arista entre el vértice `i` y el `j`, y `0` si no. Al ser no dirigido, `agregar_arista(a, b)` marca `[a][b]` y `[b][a]`, por lo que la matriz es simétrica.

## DFS (búsqueda en profundidad)
Avanza lo más profundo posible por un camino antes de retroceder. Usa una **pila**.

## BFS (búsqueda en anchura)
Visita primero todos los vecinos del vértice actual, luego los siguientes niveles. Usa una **cola**.

## Diferencia entre DFS y BFS
- DFS: pila, explora en profundidad (un camino hasta el fondo).
- BFS: cola, explora por niveles (de cerca a lejos); encuentra el camino con menos aristas.

## Archivos
- `src/GrafoNoDirigido.java`: clase del grafo (matriz, DFS, BFS)
- `src/Main.java`: ejemplo de ejecución
- `src/Pruebas.java`: pruebas (creación, matriz, DFS, BFS)

## Ejecución
Requiere JDK (Java 11 o superior). Desde la carpeta del proyecto:
```
javac -d out src/*.java
java -cp out Main
java -cp out Pruebas
```

## Ejemplo de ejecución
Aristas: A-B, A-C, B-D, B-E, C-F, E-F
```
Matriz de adyacencia:
     A  B  C  D  E  F
 A   0  1  1  0  0  0
 B   1  0  0  1  1  0
 C   1  0  0  0  0  1
 D   0  1  0  0  0  0
 E   0  1  0  0  0  1
 F   0  0  1  0  1  0

DFS desde A: A -> B -> D -> E -> F -> C
BFS desde A: A -> B -> C -> D -> E -> F
```
