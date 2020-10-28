package stack;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.Stack;

import javax.lang.model.element.Element;
import javax.management.RuntimeErrorException;
import javax.swing.text.StyledEditorKit;

public class stackCalculator {
    private Stack<Integer> numberStack;
    private Stack<String> operatorStack;
    private Map<String,Integer> priority = new HashMap<String,Integer> ();

    
    public stackCalculator(){
        this.priority.put("+", 1);
        this.priority.put("-", 1);
        this.priority.put("*", 2);
        this.priority.put("/", 2);
    }
    private int calculate(String operator,int a, int b) throws RuntimeException{
        int result;
        switch(operator){
            case "+" :
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                try{
                    result=a/b;
                }catch(RuntimeException e){
                    throw e;
                }
                break;
                
            default :
                throw new RuntimeException("Illegal input element!");
        }
        return result;
    }
    private Integer ifNumber(String inputElement) throws Exception {
        int currentNumber;
        try{
            currentNumber=Integer.parseInt(inputElement);
            return currentNumber;
        }catch(NumberFormatException e){
            return null;
        }catch (Exception e){
            throw e;
        }
    }
    public int calculate(String input) throws RuntimeException,Exception{
        return 0;
    }
}
