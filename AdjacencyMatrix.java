// import java.util.Scanner;

// public class AdjacencyMatrix {

//     private int[][] adjacencyMatrix;
//     private int vertices;

//     public AdjacencyMatrix(int vertices) {
//         this.vertices = vertices;
//         this.adjacencyMatrix = new int[vertices][vertices];
//     }

//     public void addConnection(int source, int destination) {
//         adjacencyMatrix[source][destination] = 1;
//         adjacencyMatrix[destination][source] = 1;
//     }

//     public void removeConnection(int source, int destination) {
//         adjacencyMatrix[source][destination] = 0;
//         adjacencyMatrix[destination][source] = 0;
//     }

//     public void printMatrix() {
//         System.out.println("Adjacency Matrix:");
//         for (int i = 0; i < vertices; i++) {
//             for (int j = 0; j < vertices; j++) {
//                 System.out.print(adjacencyMatrix[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the number of vertices: ");
//         int vertices = scanner.nextInt();

//         AdjacencyMatrix graph = new AdjacencyMatrix(vertices);

//         // Example: Adding connections
//         graph.addConnection(0, 1);
//         graph.addConnection(1, 2);
//         graph.addConnection(2, 0);

//         graph.printMatrix();

//         // Example: Removing connection
//         graph.removeConnection(1, 2);

//         graph.printMatrix();

//         scanner.close();
//     }
// }




// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class AdjacencyMatrix {

//     private int[][] adjacencyMatrix;
//     private int vertices;

//     public AdjacencyMatrix(int vertices) {
//         this.vertices = vertices;
//         this.adjacencyMatrix = new int[vertices][vertices];
//     }

//     public void addConnection(int source, int destination) {
//         adjacencyMatrix[source][destination] = 1;
//         adjacencyMatrix[destination][source] = 1;
//     }

//     public void removeConnection(int source, int destination) {
//         adjacencyMatrix[source][destination] = 0;
//         adjacencyMatrix[destination][source] = 0;
//     }

//     public void printMatrix() {
//         System.out.println("Adjacency Matrix:");
//         for (int i = 0; i < vertices; i++) {
//             for (int j = 0; j < vertices; j++) {
//                 System.out.print(adjacencyMatrix[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public List<Integer> getNeighbors(int vertex) {
//         List<Integer> neighbors = new ArrayList<>();
//         for (int i = 0; i < vertices; i++) {
//             if (adjacencyMatrix[vertex][i] == 1) {
//                 neighbors.add(i);
//             }
//         }
//         return neighbors;
//     }

//     public boolean isConnected() {
//         // Implement logic to check if the graph is connected.
//         // You may use depth-first search (DFS) or breadth-first search (BFS) algorithms for this.
//         // Return true if connected, false otherwise.
//         // Placeholder implementation
//         return false;
//     }

//     public int getDegree(int vertex) {
//         int degree = 0;
//         for (int i = 0; i < vertices; i++) {
//             degree += adjacencyMatrix[vertex][i];
//         }
//         return degree;
//     }

//     public boolean isCyclic() {
//         // Implement logic to check if the graph contains any cycles.
//         // You may use depth-first search (DFS) for this. Return true if cyclic, false otherwise.
//         // Placeholder implementation
//         return false;
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the number of vertices: ");
//         int vertices = scanner.nextInt();

//         AdjacencyMatrix graph = new AdjacencyMatrix(vertices);

//         // Example: Adding connections
//         graph.addConnection(0, 1);
//         graph.addConnection(1, 2);
//         graph.addConnection(2, 0);

//         graph.printMatrix();

//         // Example: Removing connection
//         graph.removeConnection(1, 2);

//         graph.printMatrix();

//         // Example: Get neighbors of vertex 1
//         List<Integer> neighborsOfVertex1 = graph.getNeighbors(1);
//         System.out.println("Neighbors of vertex 1: " + neighborsOfVertex1);

//         // Example: Check if the graph is connected
//         boolean isConnected = graph.isConnected();
//         System.out.println("Is the graph connected? " + isConnected);

//         // Example: Get degree of vertex 0
//         int degreeOfVertex0 = graph.getDegree(0);
//         System.out.println("Degree of vertex 0: " + degreeOfVertex0);

//         // Example: Check if the graph is cyclic
//         boolean isCyclic = graph.isCyclic();
//         System.out.println("Is the graph cyclic? " + isCyclic);

//         scanner.close();
//     }
// }




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyMatrix {

    private int[][] adjacencyMatrix;
    private int vertices;

    public AdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addConnection(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void removeConnection(int source, int destination) {
        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0;
    }

    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        dfs(0, visited);

        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public int getDegree(int vertex) {
        int degree = 0;
        for (int i = 0; i < vertices; i++) {
            degree += adjacencyMatrix[vertex][i];
        }
        return degree;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && isCyclicUtil(i, -1, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, vertex, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        AdjacencyMatrix graph = new AdjacencyMatrix(vertices);

         // System.out.println("enter connections: ");
        // for(int i = 0; i < vrtx; i++){
        //     int s = sc.nextInt();
        //     int d = sc.nextInt();
        //     matrix.connAdd(s, d);
        // }
        
        // Example: Adding connections
        graph.addConnection(0, 1);
        graph.addConnection(1, 2);
        graph.addConnection(2, 0);

        graph.printMatrix();

        // Example: Removing connection
        graph.removeConnection(1, 2);

        graph.printMatrix();

        // Example: Get neighbors of vertex 1
        List<Integer> neighborsOfVertex1 = graph.getNeighbors(1);
        System.out.println("Neighbors of vertex 1: " + neighborsOfVertex1);

        // Example: Check if the graph is connected
        boolean isConnected = graph.isConnected();
        System.out.println("Is the graph connected? " + isConnected);

        // Example: Get degree of vertex 0
        int degreeOfVertex0 = graph.getDegree(0);
        System.out.println("Degree of vertex 0: " + degreeOfVertex0);

        // Example: Check if the graph is cyclic
        boolean isCyclic = graph.isCyclic();
        System.out.println("Is the graph cyclic? " + isCyclic);

        scanner.close();
    }
}

