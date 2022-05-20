import java.util.*;
public class BetterStackExpTestDay2
{
  public static String infix2Postfix(String infix)
  {
    return "";  
  }
 
  public static ArrayList<String> tokenArrayGenerator(String exp) {
    String operators = "+-*/%^!()";
    ArrayList<String> result = new ArrayList<String>();
    while (exp.length() > 0) {
      if (operators.indexOf(exp.substring(0,1)) > -1) {
        if (exp.substring(0,1) == "-") {
          if (Character.isDigit(exp.charAt(1)) || exp.charAt(1) == '.') {
            String temp1 = "-" + exp.substring(1,2);
            boolean operatorFound = false;
            while (!operatorFound) {
              if (exp.charAt(2)
            }
          }
        }
      }
    }
  }

  /*public static int findIndexOfNextOperator(String exp) {
    int counter = 0;
    for (int i = 0; i < exp.length(); i++) {
      
    }
  }*/
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
