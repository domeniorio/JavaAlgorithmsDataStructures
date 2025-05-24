package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

 



public class Graph {

    private Map <Integer, List<Integer>> adiacenza;

    public Graph(){
        this.adiacenza = new HashMap<>();
    }
    public void aggiungiNodo(int node){
        this.adiacenza.putIfAbsent(node, new ArrayList<>());
    }
    
    public void aggiungiArco(int node1, int node2){
        this.adiacenza.putIfAbsent(node1, new ArrayList<>());
        this.adiacenza.putIfAbsent(node2, new ArrayList<>());
        this.adiacenza.get(node1).add(node2);
        // this.adiacenza.get(node2).add(node1); per grafo non orientato
    }

    public void rimuoviArco(int node1, int node2){
        this.adiacenza.getOrDefault(node1, new ArrayList<>()).remove(node2);
        // this.adiacenza.getOrDefault(node2, new ArrayList<>()).remove(node1); //per grafo non orientato
    }

    public void rimuoviNodo(int node){
        if(adiacenza.containsKey(node)){
            /*for(int vicino : adiacenza.get(node)){
                this.adiacenza.get(vicino).remove(node);
            } //ciclo for per grafo non orientato */
            this.adiacenza.remove(node);
        }  
    }

    public List<Integer> getVicini(int node){
        return this.adiacenza.getOrDefault(node,Collections.emptyList());
    }

    public void dfsRecursive(int startingNode){
        if(this.adiacenza.get(startingNode) == null) return;

        ArrayList<Integer> isVisited = new ArrayList<>();
        this.dfsRecursiveHelper(startingNode, isVisited);

    }

    public void dfsRecursiveHelper(int node, List<Integer> isVisited){

        if(isVisited.contains(node)) return;
        isVisited.add(node);
        System.out.println("Nodo " + node + " visitato");

        List<Integer> vicini = this.getVicini(node);
        if(vicini.isEmpty()) return;
        for(int vicino : vicini){
            this.dfsRecursiveHelper(vicino, isVisited);
        }
        //return;
    }

    public void dfsStack(int startingNode){
        Stack<Integer> stack = new Stack<>();
        stack.push(startingNode);
        ArrayList<Integer> isVisited = new ArrayList<>();

        while(!stack.isEmpty()){
            int visitedNode = stack.pop();
            if(isVisited.contains(visitedNode)) continue;
            isVisited.add(visitedNode);
            System.out.println(visitedNode);

            List<Integer> vicini = getVicini(visitedNode);
            if(vicini.isEmpty()) continue;

            for(int vicino : vicini){
                stack.add(vicino);
            }
        }
    }


    public void bfs(int startingNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        ArrayList<Integer> isVisited = new ArrayList<>();

        while(!queue.isEmpty()){
            int visitedNode = queue.poll();
            if(isVisited.contains(visitedNode)) continue;
            isVisited.add(visitedNode);
            System.out.println(visitedNode);

            List<Integer> vicini = getVicini(visitedNode);
            if(vicini.isEmpty()) continue;
 
            for(int vicino : vicini){
                queue.add(vicino);
            }
        }
    }
}
