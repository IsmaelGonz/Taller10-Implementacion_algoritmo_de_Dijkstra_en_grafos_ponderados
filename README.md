# Taller – Implementación del Algoritmo de Dijkstra en Grafos Ponderados

## Descripción
Este proyecto implementa el **algoritmo de Dijkstra** en Java para encontrar las **distancias mínimas y caminos más cortos** desde un nodo de origen en un **grafo dirigido y ponderado**.

El programa permite:
- Cargar grafos desde archivos `.txt`
- Seleccionar el archivo de entrada desde un menú interactivo
- Elegir dinámicamente el nodo de origen
- Ejecutar Dijkstra y mostrar los resultados en una **tabla formateada en consola**
- Repetir la ejecución con otro nodo de origen o con otro archivo sin reiniciar el programa

---

## Estructura del Proyecto
```
Proyecto_Dijkstra/
├── data/
│ └── grafo_ponderado_dijkstra_10n.txt
│
├── src/
│ ├── app/
│ │ └── Main.java
│ │
│ ├── algorithm/
│ │ └── Dijkstra.java
│ │
│ └── model/
│ ├── Graph.java
│ └── Edge.java
│
└── README.md
```

---

## Formato del Archivo de Entrada (.txt)

Línea 1: n m

n → número de nodos

m → número de aristas

Siguientes líneas:

u v w

u → nodo origen

v → nodo destino

w → peso de la arista

### Ejemplo
4 5

0 1 2

0 2 5

1 2 1

1 3 4

2 3 2

---
## Requisitos para la Ejecución

Para ejecutar correctamente este proyecto se requiere:

- **Java Development Kit (JDK)**
    - OpenJDK 8 o superior (recomendado OpenJDK 11 o 17)

- **Entorno de Desarrollo (IDE)**
    - IntelliJ IDEA Community Edition
    - (Opcional) Visual Studio Code con la extensión *Extension Pack for Java*

- **Sistema Operativo**
    - Windows, Linux o macOS

- **Estructura del Proyecto**
    - La carpeta `data` debe existir en el directorio raíz del proyecto
    - Los archivos de entrada deben estar en formato `.txt` y cumplir con el formato especificado

- **Ejecución**
- Ejecutar la clase `Main.java`
- Interactuar con el menú desde la consola


---

## Ejecución del Programa

1. Ejecutar la clase `Main.java`
2. El programa mostrará los archivos disponibles en la carpeta `data`
3. Seleccionar el archivo deseado
4. Ingresar el nodo de origen
5. Visualizar la tabla de resultados en consola

---

## Menús Interactivos

### Selección de archivo
Permite elegir cualquiera de los archivos `.txt` disponibles en la carpeta `data`.

### Selección de nodo de origen
El usuario puede ingresar cualquier nodo válido entre `0` y `n-1`.

### Menú posterior a la ejecución
Después de mostrar la tabla, el programa permite:

1. Volver a seleccionar otro nodo de origen
2. Seleccionar otro archivo
3. Salir

---

## Salida en Consola

El programa muestra una tabla alineada dinámicamente con:

- **Nodo**
- **Distancia mínima desde el origen**
- **Camino reconstruido**


🔹 **INF** indica que no existe un camino desde el nodo origen.

---

## Detalles de Implementación

- El grafo se representa mediante **listas de adyacencia**
- Se utilizan las estructuras:
    - Arreglo de distancias
    - Arreglo de nodos visitados
    - Arreglo de predecesores
- El algoritmo sigue el procedimiento clásico de Dijkstra
- La tabla se adapta automáticamente a grafos pequeños o grandes

---

## Observaciones

- El programa valida entradas del usuario
- Permite múltiples ejecuciones sin reiniciar
- Diseñado para facilitar pruebas y análisis comparativos

---
## Conclusiones

- El algoritmo de Dijkstra permite resolver de manera eficiente el problema del **camino más corto** en grafos ponderados con **pesos positivos**, cumpliendo con los objetivos planteados en la práctica.

- La implementación en Java facilitó la comprensión de las **estructuras auxiliares del algoritmo**, como el arreglo de distancias, el arreglo de nodos visitados y el arreglo de predecesores, fundamentales para el correcto funcionamiento del método.

- La reconstrucción del camino mínimo a partir del arreglo de predecesores permitió **interpretar claramente los resultados**, no solo en términos de distancia, sino también de la ruta seguida.

- La comparación entre la **ejecución manual realizada en clase** y la salida generada por el programa evidenció que el algoritmo fue implementado correctamente y produce resultados consistentes.

- Se comprobó que el algoritmo de Dijkstra **no funciona correctamente con pesos negativos**, ya que asume que una vez encontrada la menor distancia a un nodo, esta no puede disminuir.

- El uso de archivos de entrada y menús interactivos facilitó la prueba de distintos grafos y nodos de origen, fortaleciendo el análisis y la validación de resultados.

- Este algoritmo tiene aplicaciones reales en problemas como **rutas en mapas, redes viales, redes de comunicación y sistemas de planificación**, lo que resalta su importancia en el área de estructuras de datos y algoritmos.


## Autores
**Ariel Ismael González Astudillo**

**Mateo Fabián Silva Aguilar**

---

## Asignatura
Estructura de Datos / Grafos  
Implementación del Algoritmo de Dijkstra


