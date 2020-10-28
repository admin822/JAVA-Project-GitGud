package stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.StyledEditorKit;

public class middleToRearTest {

    private static ArrayList<String> stringToArrayList(String input){
        ArrayList<String> inputList=new ArrayList<String>();
        Pattern numbers=Pattern.compile("[1-9]\\d*\\.?\\d*");
        Matcher numberMatcher=numbers.matcher(input);
        Integer numberStart=0;
        Integer numberEnd=0;
        while(numberMatcher.find(numberEnd))
        {   
            numberStart=numberMatcher.start();
            while(numberEnd<numberStart){
                inputList.add(input.substring(numberEnd, numberEnd+1));
                numberEnd++;
            }
            numberEnd=numberMatcher.end();
            inputList.add(input.substring(numberStart, numberEnd));
        }
        return inputList;
    }
    private static Double calculate(Double elementOne,Double elementTwo, String operator) throws RuntimeException{
        switch(operator){
            case "+":
                return elementOne+elementTwo;
            case "-":
                return elementOne-elementTwo;
            case "*":
                return elementOne*elementTwo;
            case "/":
                return elementOne/elementTwo;
            default:
                throw new RuntimeException("Illegal operator!");
        }
    }
    private static double calculateSuffixExpression(ArrayList<String> inputList) throws RuntimeException{
        Stack<Double> numberStack= new Stack<Double>();
        Double elementOne;
        Double elementTwo;
        for(String temp:inputList){
            if(temp.matches("[1-9]\\d*\\.?\\d*")){
                numberStack.push(Double.parseDouble(temp));
            }
            else{
                elementTwo=numberStack.pop();
                elementOne=numberStack.pop();
                try{
                    numberStack.push(calculate(elementOne, elementTwo, temp));
                }catch(RuntimeException e){
                    throw e;
                }
                
            }
        }
        return numberStack.pop();
    }
    public static void main(String[] args) {
        String newInput="3.0+(3.0-2.0)*6/3";
        ArrayList<String> newInputList=stringToArrayList(newInput);
        for(String s:newInputList){
            System.out.printf("%s\t", s);
        }
        System.out.println("");
        middleToRear testSuffixParser=new middleToRear();
        ArrayList<String>result= testSuffixParser.suffixParsing(newInputList);
        for(int i=0;i<result.size();i++){
            System.out.printf("%s\t",result.get(i));
        }
        System.out.println("");
        System.out.println(calculateSuffixExpression(result));
    }

}
