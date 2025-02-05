import java.util.*;
public class StackExpTestDay1
{
 public static double evalAns(String exp)
 {
  Double temp1;
  Double temp2;
  Double temp3;
  Stack<String> asdf = new Stack<String>();
  while (exp.length() > 0) {
    
    if (Character.isDigit(exp.charAt(0))) {
      asdf.push(exp.substring(0,1));
    }
    else if (exp.charAt(0)=='+') {
      temp1 = Double.parseDouble(asdf.pop());
      temp2 = Double.parseDouble(asdf.pop());
      asdf.push(Integer.toString((int)(temp1+temp2)));
    }
    else if (exp.charAt(0)=='-') {
      temp1 = Double.parseDouble(asdf.pop());
      temp2 = Double.parseDouble(asdf.pop());
      asdf.push(Integer.toString((int)(temp2-temp1)));
    }
    else if (exp.charAt(0)=='*') {
      temp1 = Double.parseDouble(asdf.pop());
      temp2 = Double.parseDouble(asdf.pop());
      asdf.push(Integer.toString((int)(temp2*temp1)));
    }
    else if (exp.charAt(0)=='/') {
      temp1 = Double.parseDouble(asdf.pop());
      temp2 = Double.parseDouble(asdf.pop());
      asdf.push(Double.toString((temp2/temp1)));
    }
    else if (exp.charAt(0)=='%') {
      temp1 = Double.parseDouble(asdf.pop());
      temp2 = Double.parseDouble(asdf.pop());
      asdf.push(Integer.toString((int)(temp2%temp1)));
    }
    else if (exp.charAt(0)=='^') {
      temp1 = Double.parseDouble(asdf.pop());
      temp2 = Double.parseDouble(asdf.pop());
      asdf.push(Integer.toString((int)Math.pow(temp2, temp1)));
    }
    else if (exp.charAt(0)=='!') {
       temp1 = Double.parseDouble(asdf.pop());
       temp2 = 1.0;
       for (int i = 2; i <= temp1; i++) {
         temp2 *= i;
       }
       
       asdf.push("" + (int)(temp2+0));
    }
    exp = exp.substring(1);
  }
  return Double.parseDouble(asdf.pop());
 }
 
  public static void main(String[] args)
  {
    double answer, yourAns;
    String exp;
  int c=0, w=0;
    
    exp = "256++";
    System.out.println("Testing Post-fix Single Digit Operation");
    System.out.println("Operations tested: +,-,*,/,%,^,!");
    System.out.println("Testing 2+5+6");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 13;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "256*+9-";
    System.out.println("Testing 2+5*6-9");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 23;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "111+3^+2/";
    System.out.println("Testing (1+(1+1)^3)/2");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4.5;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "12+3*23+%";
    System.out.println("Testing (1+2)*3%(2+3)");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "473%-!";
    System.out.println("Testing (4-7%3)!");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 6;
    yourAns = evalAns(exp);
    if(yourAns==answer){
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

