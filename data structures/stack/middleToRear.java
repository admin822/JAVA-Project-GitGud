package stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class middleToRear {
    private Stack<String> inputStack;
    private ArrayList<String> inputList;
    private Map<String,Integer> priority= new HashMap<String,Integer>();

    public middleToRear(){
        this.inputStack=new Stack<String>();
        this.inputList=new ArrayList<String>();
        this.priority.put("+", 1);
        this.priority.put("-", 1);
        this.priority.put("*", 2);
        this.priority.put("/", 2);
    }

    private boolean isFirstLarger(String first, String second) throws RuntimeException{
        if(this.priority.get(first)==null || this.priority.get(second)==null){
            // System.out.println(second);
            throw new RuntimeException(" operator does not exist!");
        }
        else{
            if(this.priority.get(first)>this.priority.get(second))
                return true;
            else
                return false;
        }
    }

    private boolean isNumber(String input){
        if(input.matches("[1-9]\\d*\\.?\\d*"))
            return true;
        else
            return false;
    }

    public ArrayList<String> suffixParsing(ArrayList<String> originString) throws RuntimeException{
        try{
            this.reset();
            this.midleToRearConvertion(originString);
            return this.inputList;
        }catch (RuntimeException e){
            throw e;
        }
    }

    private void reset(){
        this.inputList.clear();
        this.inputStack.clear();
    }

    private void midleToRearConvertion(ArrayList<String> originString) throws RuntimeException{
        Integer index=0;
        String temp;
        while(true){
            if(index>=originString.size())
                break;
            temp=originString.get(index);
            // System.out.println(temp);
            if(isNumber(temp)){
                inputList.add(temp);
            }
            else{
                if(this.inputStack.empty() || this.inputStack.peek().equals("("))
                {
                    this.inputStack.push(temp);
                }
                else if(temp.equals("("))
                {
                    this.inputStack.push(temp);
                }
                else if(temp.equals(")")){
                    while(!this.inputStack.peek().equals("(")){
                        this.inputList.add(this.inputStack.pop());
                    }
                    this.inputStack.pop();
                }
                else{
                    try{
                        while(!this.inputStack.empty()){
                            if(isFirstLarger(temp,this.inputStack.peek()))
                                break;
                            this.inputList.add(this.inputStack.pop());
                        }
                        this.inputStack.push(temp);
                    }catch (RuntimeException e){
                        throw e;
                    }
                    
                }
            }
            index++;
        }
        while(!this.inputStack.empty()){
            this.inputList.add(this.inputStack.pop());
        }
    }
        
}

