package heap;


public class heap {
    private Double[] arrayHeap;
    public heap(Double[] array){
        arrayHeap=array;
    }
    private void swap(int index1, int index2){
        Double temp=arrayHeap[index1];
        arrayHeap[index1]=arrayHeap[index2];
        arrayHeap[index2]=temp;
    }
    /**
     * say we have n nodes in a complete binary tree, then we have 
     * (n+1)//2 tree node, and in case of using array to represent the 
     * tree, we know the last node that is not a left node is at:
     * n-(n+1)//2-1
     */
    private void maxheapify(int start, int end){
        Double max;
        int maxIndex;
        if(2*start+2<=end && arrayHeap[2*start+2]>arrayHeap[2*start+1]){
            max=arrayHeap[2*start+2];
            maxIndex=2*start+2;
        }
        else{
            max=arrayHeap[2*start+1];
            maxIndex=2*start+1;
        }
        if(max>arrayHeap[start]){
            swap(start, maxIndex);
            if(2*maxIndex+1<=end){
                maxheapify(maxIndex, end);
            }
        }
        else{
            return;
        }
    }
    private void minheapify(int start, int end){
        Double min;
        int minIndex;
        if(2*start+2<=end && arrayHeap[2*start+2]<arrayHeap[2*start+1]){
            min=arrayHeap[2*start+2];
            minIndex=2*start+2;
        }
        else{
            min=arrayHeap[2*start+1];
            minIndex=2*start+1;
        }
        if(min<arrayHeap[start]){
            swap(start, minIndex);
            if(2*minIndex+1<=end){
                minheapify(minIndex, end);
            }
        }
        else{
            return;
        }
    }
    public void buildHeap(int lastElementIndex,boolean isMaxHeap){
        int size=lastElementIndex+1;
        int indexOfParent=size-(size+1)/2-1;
        while(indexOfParent>=0){
            if(isMaxHeap){
                maxheapify(indexOfParent,lastElementIndex);
            }
            else{
                minheapify(indexOfParent,lastElementIndex);
            }
            indexOfParent--;
        }
    }
    

    public void sort(boolean isReversed){
        int lastElemenIndex=arrayHeap.length-1;
        while(lastElemenIndex>0){
            buildHeap(lastElemenIndex, !isReversed);
            swap(0,lastElemenIndex);
            lastElemenIndex--;
        }
    }

    public Double[] getHeap(){
        return this.arrayHeap;
    }

    public void print(){
        for(Double d:arrayHeap){
            System.out.printf("%f\t",d);
        }
        System.out.println();
    }

}
