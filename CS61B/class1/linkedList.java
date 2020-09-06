

public class linkedList {
    private linkedListNode Anchor;
    public linkedList(){
        this.Anchor=new linkedListNode(0);
    }
    public linkedList(linkedListNode root){
        this.Anchor=new linkedListNode(0);
        Anchor.setTail(root);
    }
    public linkedList(int i){
        this.Anchor=new linkedListNode(0);
        Anchor.setTail(i);
    }
    public linkedList(int[]a){
        this.Anchor=new linkedListNode(0);
        linkedListNode temp=Anchor;
        for(int i=0;i<a.length;i++){
            temp.setTail(new linkedListNode(a[i]));
            temp=temp.getTail();
        }
    }
    public void printList(){
        linkedListNode root=Anchor.getTail();
        while(root!=null){
            System.out.print(root.getHead()+"\t");
            root=root.getTail();
        }
        System.out.println();
    }
    public linkedListNode getRoot(){
        return this.Anchor.getTail();
    }
    public linkedListNode getAnchor(){
        return this.Anchor;
    }
}
