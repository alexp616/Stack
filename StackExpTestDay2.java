import java.util.*;
public class StackExpTestDay2
{
 public static String infix2Postfix(String infix)
 {
   String operators = "+-*/%^!";
   String result = "";
   Stack<String> tempStack = new Stack<String>();
   //step 1
   while (infix.length() > 0) {
     //step 2
     if (Character.isDigit(infix.charAt(0))) {
       result += infix.substring(0,1);
     }
     //step 3
     else if (operators.indexOf(infix.substring(0,1)) > -1) {
       
       
       boolean leftParenFound = false;
       while (!leftParenFound) {
         if (tempStack.empty()) {
           break;
         }
         else if (tempStack.peek().equals("(")) {
           leftParenFound = true;
         }
         else if (priority(tempStack.peek()) >= priority(infix.substring(0,1))) {
           result += tempStack.pop();
         }
         else {
           break;
         }
       }
       tempStack.push(infix.substring(0,1));
     }
     else {//steps 4 and 5
       if (infix.substring(0,1).equals("(")) {
         tempStack.push("(");
       }
       else if (infix.substring(0,1).equals(")")) {
         boolean leftParenFound = false;
         while (!leftParenFound) {
           if (!tempStack.peek().equals("(")) {
             result += tempStack.pop();
           }
           else {
             leftParenFound = true;
             tempStack.pop();
           }
         }
       }
     }
     infix = infix.substring(1);
   }
   while (!tempStack.empty()) {
     result += tempStack.pop();
   }
   return result;
 }
 
 public static int priority(String a) {
   if (a.equals("+") || a.equals("-")) {
     return 1;
   }
   else if (a.equals("*") || a.equals("/") || a.equals("%")) {
     return 2;
   }
   else if (a.equals("^")) {
     return 3;
   }
   else if (a.equals("!")) {
     return 4;
   }
   else {
     return 0;
   }
 }
 
  public static void main(String[] args)
  {
    String answer, yourAns;
    String exp;
    int c=0, w=0;
    
    exp = "2+5+6";
    answer = "25+6+";
    System.out.println("Testing infix to postfix conversion for Single Digit Operation");
    System.out.println("Operations tested: +,-,*,/,%,^,!");
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }
    
    System.out.println();
    exp = "2+5*6-9";
    answer = "256*+9-";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }
    
    System.out.println();
    exp = "(1+(1+1)^3)/2";
    answer = "111+3^+2/";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }
        
   System.out.println();
    exp = "(1+2)*3%(2+3)";
    answer = "12+3*23+%";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }

   System.out.println();
    exp = "(4-7%3)!";
    answer = "473%-!";
    System.out.println("Testing " + exp);
    yourAns = infix2Postfix(exp);
    if(yourAns.equals(answer)){
      System.out.println("Pass");
      c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
      w++;
    }

    System.out.println();
    System.out.println("Number of correct answer: " + c);
    System.out.println("Number of incorect answer: " + w);
    System.out.println("Accuracy: " + Math.round((double)c/(c+w)*100)/100 + "%");
  }
}
