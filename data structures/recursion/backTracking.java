package recursion;

import java.util.Stack;

public class backTracking {
    private int rows;
    private int columns;
    private int[][] obstacles;
    private Stack<int[]> traceStack;

    public backTracking(int rows,int columns){
        this.rows=rows;
        this.columns=columns;
        this.obstacles=null;
        this.traceStack=new Stack<int[]>();
    }

    public backTracking(int rows, int columns ,int[][] obastacles){
        this.rows=rows;
        this.columns=columns;
        this.obstacles=obastacles;
        this.traceStack=new Stack<int[]>();
    }

    private int[][] setup(){
        int maze[][]=new int[rows][columns];
        for(int i=0;i<rows;i++){
            maze[i][0]=1;
            maze[i][columns-1]=1;
        }
        for(int j=0;j<rows;j++){
            maze[0][j]=1;
            maze[rows-1][j]=1;
        }
        if(obstacles!=null){
            for(int[] obstacle:obstacles){
                maze[obstacle[0]][obstacle[1]]=1;
            }
        }
        return maze;
    }
    public void printTrace(){
        int[] temp;
        while(!this.traceStack.empty()){
            temp=this.traceStack.pop();
            System.out.printf("[%d,%d]\n",temp[0],temp[1]);
        }
    }
    public boolean findIfReachable(int startX, int StartY){
        traceStack.clear();
        int[][] newMaze=setup();
        return backTrack(newMaze, startX, StartY);
    }
    private boolean backTrack(int[][] newMaze, int startX, int StartY){
        if(startX==rows-2 && StartY==columns-2){
            int[] temp={startX,StartY};
            traceStack.push(temp);
            return true;
        }
        if(newMaze[startX][StartY]==0){
            newMaze[startX][StartY]=2;
            if(backTrack(newMaze,startX+1, StartY)){
                int[] temp={startX,StartY};
                traceStack.push(temp);
                return true;
            }
            else if(backTrack(newMaze,startX, StartY+1)){
                int[] temp={startX,StartY};
                traceStack.push(temp);
                return true;
            }
            else if(backTrack(newMaze,startX-1, StartY)){
                int[] temp={startX,StartY};
                traceStack.push(temp);
                return true;
            }
            else if(backTrack(newMaze,startX, StartY-1)){
                int[] temp={startX,StartY};
                traceStack.push(temp);
                return true;
            }
            else{
                newMaze[startX][StartY]=3;
                return false;
            }
        }
        else{
            return false;
        }

    }

}
