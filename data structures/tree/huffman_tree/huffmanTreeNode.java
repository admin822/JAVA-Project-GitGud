package tree.huffman_tree;


public class huffmanTreeNode implements Comparable{
    private Integer weight;
    private Character value;
    private String code;
    public huffmanTreeNode left;
    public huffmanTreeNode right;
    public huffmanTreeNode(Integer weight){
        this.weight=weight;
        this.value=null;
        this.code="";
        left=null;
        right=null;
    }
    public huffmanTreeNode(Integer weight,Character value){
        this.weight=weight;
        this.value=value;
        this.code="";
        left=null;
        right=null;
    }
    public void setCode(String code){
        this.code=code;
    }
    public String getCode(){
        return this.code;
    }
    public Character getValue(){
        return this.value;
    }
    public Integer getWeight(){
        return this.weight;
    }
    @Override
    public int compareTo(Object o) {
        huffmanTreeNode anotherNode=(huffmanTreeNode)o;
        return this.weight-anotherNode.getWeight();
    }
}
