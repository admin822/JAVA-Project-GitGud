package class1;
public class deleteAll {
    private boolean isIterative;
    public deleteAll(Boolean isIterative){
        this.isIterative=isIterative;
    }
    private void dremoveAllIteratively(int n, linkedListNode root,linkedListNode prev){
        linkedListNode current=root;
        if(current==null){
            return;
        }
        else{
            while(current!=null){
                if(current.getHead()==n){
                    prev.setTail(current.getTail());
                    current=current.getTail();
                }
                else{
                    prev=current;
                    current=current.getTail();
                }
                
            }
        }
    }
    private void dremoveAllRecursively(int n,linkedListNode root,linkedListNode prev){
        if(root==null){
            return;
        }
        else{
            if(root.getHead()==n){
                prev.setTail(root.getTail());
                dremoveAllRecursively(n, root.getTail(),prev);
            }
            else{
                dremoveAllRecursively(n, root.getTail(), root);
            }
        }
    }
    public void dremoveAll(int n, linkedListNode root,linkedListNode prev){
        if(this.isIterative){
            /**
             * remove all ns from the linkedList provided iteratively
             */
            dremoveAllIteratively(n, root,prev);
        }
        else{
            /**
             * remove all ns from the LinkedList provided recursively
             */
            dremoveAllRecursively(n, root, prev);
        }
    }
    private linkedList removeAllInteratively(int n,linkedListNode root){
        linkedList newList=new linkedList();
        linkedListNode newListNode=newList.getAnchor();
        linkedListNode originalListNode=root;
        while(originalListNode!=null){
            if(originalListNode.getHead()==n){
                originalListNode=originalListNode.getTail();
            }
            else{
                newListNode.setTail(originalListNode.getHead());
                newListNode=newListNode.getTail();
                originalListNode=originalListNode.getTail();
            }
        }
        return newList;
    }
    
    private linkedListNode removeAllRecursivelyGetRoot(int n,linkedListNode root){
        if(root==null){
            return null;
        }
        else{
            if(root.getHead()==n){
                return removeAllRecursivelyGetRoot(n, root.getTail());
            }
            else{
                linkedListNode newRoot=new linkedListNode(root.getHead());
                newRoot.setTail(removeAllRecursivelyGetRoot(n, root.getTail()));
                return newRoot;
            }
        }
    }

    private linkedList removeAllRecursively(int n,linkedListNode root){
        linkedListNode newRoot=removeAllRecursivelyGetRoot(n,root);
        linkedList result= new linkedList(newRoot);
        return result;
        }
    public linkedList removeAll(int n, linkedListNode root){
        if(this.isIterative){
            /**
             * remove all ns from the linkedList provided iteratively
             */
            return removeAllInteratively(n, root);
        }
        else{
            /**
             * remove all ns from the LinkedList provided recursively
             */
            return removeAllRecursively(n, root);
        }
        
    }
}
