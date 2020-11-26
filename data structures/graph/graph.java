package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.StyledEditorKit;

import org.javatuples.Pair;

import linked_list.linkedList;
import linked_list.nodeDoesNotExistException;



public class graph {
    private ArrayList<String> vertex=new ArrayList<>();
    private HashMap<String,ArrayList<Pair<String,Integer>>> edges=new HashMap<>();
    private int numberOfNodes;
    public graph() {
        this.numberOfNodes=0;
    }
    public void insertVertex(String vertexName){
        if(this.vertex.contains(vertexName)){
            System.out.printf("vertex %s is already in the graph!",vertexName);
            return;
        }
        this.vertex.add(vertexName);
        this.numberOfNodes++;
    }
    public void insertEdge(String vertexStart,String vertexEnd,int weight) throws nodeDoesNotExistException{
        if(this.vertex.contains(vertexStart)==false||this.vertex.contains(vertexEnd)==false){
            throw new nodeDoesNotExistException();
        }
        if(this.edges.get(vertexStart)==null){
            ArrayList<Pair<String,Integer>> newEdge=new ArrayList<>();
            newEdge.add(new Pair<String,Integer>(vertexEnd,weight));
            this.edges.put(vertexStart, newEdge);
        }
        else{
            this.edges.get(vertexStart).add(new Pair<String,Integer>(vertexEnd,weight));
        }
    }
    public void print(){
        ArrayList<Pair<String,Integer>> tempEdges;
        for(String key:this.vertex){
            System.out.printf("For node %s:\n",key);
            tempEdges=this.edges.get(key);
            if(tempEdges==null||tempEdges.isEmpty()){
                System.out.printf("\tNode connection has not been made to this node!\n");
            }
            else{
                for(Pair<String,Integer> p:tempEdges){
                    System.out.printf("\t it has an edge to %s and weight is %d\n",p.getValue0(),p.getValue1());
                }
            }
        }
    }
    /**
     * 
     * @param vertexName: the vertex to start DFS
     */
    private void DFS(String vertexName,ArrayList<String> hasBeenVisited){
        ArrayList<Pair> needToDelete=new ArrayList<>();
        if(hasBeenVisited.contains(vertexName)==false){ // this line is put here specificly for the DFSThruWholeGraphy Function
            hasBeenVisited.add(vertexName);
            System.out.printf("Currently on vertext:%s\n",vertexName);
        }
        ArrayList<Pair<String,Integer>>allEdges=this.edges.get(vertexName);
        if(allEdges==null){
            return;
        }
        else{
            for(Pair p:allEdges){
                if(this.vertex.contains(p.getValue0())==false){ // edge does not exist anymore
                    System.out.printf("Edge %s->%s will be deleted because %s is not valid anymore\n",vertexName,p.getValue0(),p.getValue0());
                    needToDelete.add(p);
                }
                else if(hasBeenVisited.contains(p.getValue0())==false){ // node has not been visited
                    DFS((String)p.getValue0(), hasBeenVisited);
                }
            }
            if(needToDelete.isEmpty()==false){
                for(Pair dEdge:needToDelete){
                    allEdges.remove(dEdge);
                }
            }
            return;
        }
    }
    public void DFSThruWholeGraph(){
        ArrayList<String> hasBeenVisited=new ArrayList<>();
        for(String vertex:this.vertex){
            System.out.printf("Starting DFS starting from %s...\n",vertex);
            DFS(vertex, hasBeenVisited);
            System.out.printf("DFS starting from %s has completed!\n",vertex);
            System.out.println();
        }
    }
    public void DFS(String vertexName) throws nodeDoesNotExistException{
        if(this.vertex.contains(vertexName)==false){
            throw new nodeDoesNotExistException();
        }
        ArrayList<String> hasBeenVisited=new ArrayList<>();
        DFS(vertexName, hasBeenVisited);
    }
    public void BFSThruWholeGraph() throws nodeDoesNotExistException{
        ArrayList<String> hasBeenVisited=new ArrayList<>();
        try{
            for(String vertex:this.vertex){
                System.out.printf("Starting BFS starting from %s...\n",vertex);
                BFS(vertex, hasBeenVisited);
                System.out.printf("BFS starting from %s has completed!\n",vertex);
                System.out.println();
            }
        }catch (nodeDoesNotExistException e){
            throw e;
        }
    }
    public void BFS(String vertexName)throws nodeDoesNotExistException{
        ArrayList<String> hasBeenVisited=new ArrayList<>();
        try{
            BFS(vertexName, hasBeenVisited);
        }catch(nodeDoesNotExistException e){
            throw e;
        }
    }
    public void deleteVertex(String vertexName) throws nodeDoesNotExistException{
        if(this.vertex.contains(vertexName)==false){
            throw new nodeDoesNotExistException();
        }
        else{
            this.vertex.remove(vertexName);
            if(this.edges.get(vertexName)!=null){
                this.edges.remove(vertexName);
            }
        }
    
    }
    private void BFS(String vertexName,ArrayList<String> hasBeenVisited) throws nodeDoesNotExistException{
        if(this.vertex.contains(vertexName)==false){
            throw new nodeDoesNotExistException();
        }
        Queue<String> tempQueue=new LinkedList<String> ();
        ArrayList<Pair<String,Integer>> allEdges;
        String tempName;
        ArrayList<Pair> needTODelete=new ArrayList<>();
        tempQueue.offer(vertexName);
        while(tempQueue.isEmpty()==false){
            needTODelete.clear();
            vertexName=tempQueue.poll();
            System.out.printf("Currently on vertext:%s\n",vertexName);
            hasBeenVisited.add(vertexName);
            allEdges=this.edges.get(vertexName);
            if(allEdges!=null){
                for(Pair p:allEdges){
                    tempName=(String)p.getValue0();
                    if(this.vertex.contains(tempName)){
                        if(hasBeenVisited.contains(tempName)==false){
                            tempQueue.add(tempName);
                        }
                    }
                    else{
                        System.out.printf("Edge %s->%s will be deleted because %s is not valid anymore\n",vertexName,tempName,tempName);
                        needTODelete.add(p);
                    }
                }
                if(needTODelete.isEmpty()==false){
                    for(Pair dEdge:needTODelete){
                        allEdges.remove(dEdge);
                    }
                }
            }
        }
    }
}
