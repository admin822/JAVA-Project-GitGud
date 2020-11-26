package file_compressor;

public class codingTreeNode implements Comparable{
    private Integer weight;
    private Byte value;
    private String code;
    public codingTreeNode left;
    public codingTreeNode right;
    public codingTreeNode(Integer weight){
        this.weight=weight;
        this.value=null;
        this.code="";
        left=null;
        right=null;
    }
    public codingTreeNode(Integer weight,Byte value){
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
    public Byte getValue(){
        return this.value;
    }
    public Integer getWeight(){
        return this.weight;
    }
    @Override
    public int compareTo(Object o) {
        codingTreeNode anotherNode=(codingTreeNode)o;
        return this.weight-anotherNode.getWeight();
    }
}
