package graph;

import linked_list.nodeDoesNotExistException;

public class graphTest {
    public static void main(String[] args) {
        graph testGraph=new graph();
        try{
            testGraph.insertVertex("A");
            testGraph.insertVertex("B");
            testGraph.insertVertex("C");
            testGraph.insertVertex("D");
            testGraph.insertVertex("E");
            testGraph.insertVertex("F");
            testGraph.insertVertex("G");
            testGraph.insertEdge("A", "C", 1);
            testGraph.insertEdge("A", "F", 5);
            testGraph.insertEdge("C", "G", 11);
            testGraph.insertEdge("D", "E", 121);
            testGraph.insertEdge("F", "C", 121);
            testGraph.insertEdge("E", "D", 121);
            testGraph.print();
            // testGraph.DFS("A");
            System.out.println("############BFS#############");
            // testGraph.BFS("D");
            testGraph.deleteVertex("E");
            // testGraph.BFSThruWholeGraph();
            testGraph.DFSThruWholeGraph();
            testGraph.print();
        }catch(nodeDoesNotExistException e){
            System.out.println("Node does not exist failed to insert new edge");
        }
        
    }
}
