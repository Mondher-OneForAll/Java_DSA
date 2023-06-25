package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    ArrayList<Node>nodes;
    int matrix [][];
    Graph(int size){
        this.matrix = new int [size][size];
        this.nodes = new ArrayList<>();
    }
    public void addNode(Node node){
        this.nodes.add(node);

    }
    public void addEdge(int src, int dst){
        this.matrix[src][dst] = 1;
    }
    public boolean checkEdge(int src, int dst){
        return (this.matrix[src][dst] == 1);
    }

    public void print(){
        System.out.print("  ");
        for (Node node : this.nodes){
            System.out.print(node.data + " ");
        }
        System.out.println();

        for (int i = 0; i < this.matrix.length; i++){
            System.out.print(nodes.get(i).data + " ");
            for (int j = 0; j < this.matrix[i].length; j++){
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void depthFirstSearch(int src){
        boolean[] visited = new boolean[matrix.length];
        dfsHelper(src, visited);
    }
    private void dfsHelper(int src, boolean[] visited) {
        if (visited[src]) return;
        else {
            visited[src] = true;
            System.out.print(nodes.get(src).data + " => ");
        }
        for (int i = 0; i < matrix[src].length; i++){
            if (matrix[src][i] == 1) dfsHelper(i, visited);
        }
        return;
    }

    public void breadthFirstSearch(int src){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];

        queue.offer(src);
        visited[src] = true;

        while (!queue.isEmpty()){
            src = queue.poll();
            System.out.println("\t\t" + nodes.get(src).data);

            for (int i = 0; i < matrix[src].length; i++){
                if (matrix[src][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
