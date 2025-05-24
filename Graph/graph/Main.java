package graph;

public class Main {
    public static void main(String[] args){

        Graph graph = new Graph();
        for(int i = 0; i < 5; i++){
            graph.aggiungiNodo(i);
        }

        graph.aggiungiArco(0, 1);
        graph.aggiungiArco(1, 2);
        graph.aggiungiArco(1, 4);
        graph.aggiungiArco(2, 3);
        graph.aggiungiArco(2, 4);
        graph.aggiungiArco(4, 0);
        graph.aggiungiArco(4, 2);

        graph.bfs(0);
    }
}
