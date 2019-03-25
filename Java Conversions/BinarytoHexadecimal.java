import java.util.*;
import java.util.Scanner;

class BinarytoHexadecimal extends Conversions {
  BinarytoHexadecimal(long num, Scanner scan) {
    super(num, scan, "Binary to Hexadecimal");
    this.doFirst();
  }
  protected void doFirst() {
    this.introduction();
    if (this.getDataStructureName().equals("Stack")) {
      System.out.println("Stack");
    }
    else if (this.getDataStructureName().equals("Queue")) {
      System.out.println("Queue");
    }
  }

  

  private char hexConverted(long number) {
    switch ((int) number) {
    case 10:
      return 'a';
    case 11:
      return 'b';
    case 12:
      return 'c';
    case 13:
      return 'd';
    case 14:
      return 'e';
    case 15:
      return 'f';
    default:
      return 'z';
    }
  }

  private String hexConversion(Stack<Character> number) {
    long numberToCon = 0;
    Stack<Long> stackInt = new Stack<Long>();
    int i = 0;
    char pop = ' ';
    String result = "";
    while(!number.isEmpty()) {
      pop = number.pop();
      if (pop == '1') {
        numberToCon = numberToCon + ((int) Math.pow(2, i));
      }
      if (i % 3 == 0  && i !=0) {
        if (numberToCon >= 10) {
          stackInt.push(numberToCon);
        }
        else {
          stackInt.push(numberToCon);
        }
        numberToCon = 0;
        i = -1;
      }
      i++;
    }
    while(!stackInt.isEmpty()) {
      if (stackInt.peek() >= 10) {
        result += this.hexConverted(stackInt.pop());
      }
      else result = result + stackInt.pop();
      
    }
    this.setStringValue(result);

    return this.getStringValue();
  }

  public void doConversion() {
    this.setValue(0);
    String number = Long.toString(this.getNumber());
    while (number.length() % 4 != 0) {
      number = "0" + number;
    }

    Stack<Character> stack = new Stack<Character>();
    StringBuilder numberToConvert = new StringBuilder(number);

    char[] sendToHexConversion = new char[64];
    for (int i = 0; i < numberToConvert.length(); i++) {
      sendToHexConversion[i] = numberToConvert.charAt(i);
      stack.push(sendToHexConversion[i]);
    }
    this.hexConversion(stack);
    
    this.setConverted();
  }
  @Override
  public void printConversion() {
    System.out.println("The conversion name is: " + this.getConversionName());
    System.out.println("The number to be converted is: " + this.getNumber());
    System.out.println("The converted value is: " + this.getStringValue());
  }
}