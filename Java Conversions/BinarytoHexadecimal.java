import java.util.*;
import java.util.Scanner;

//Class Declaration
class BinarytoHexadecimal extends Conversions {
	
  //Constructor	
  BinarytoHexadecimal(long num, Scanner scan) {
    super(num, scan, "Binary to Hexadecimal");
    this.doFirst();
    this.setTime(this.getStartTime(), this.getEndTime());
  }

  //Methods
  protected void doFirst() {
    this.introduction();
    this.setStartTime();
    if (this.getDataStructureName().equals("Stack")) {
      this.doConversion();
    } else if (this.getDataStructureName().equals("Queue")) {
      this.doConversionWithQueue();
    }
    else {
      this.doConversion();
    }
    this.setEndTime();
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

  private void hexConversion(Stack<Character> number) {
    long numberToCon = 0;
    Stack<Long> stackInt = new Stack<Long>();
    int i = 0;
    char pop = ' ';
    String result = "";
    while (!number.isEmpty()) {
      pop = number.pop();
      if (pop == '1') {
        numberToCon = numberToCon + ((int) Math.pow(2, i));
      }
      if (i % 3 == 0 && i != 0) {
        if (numberToCon >= 10) {
          stackInt.push(numberToCon);
        } else {
          stackInt.push(numberToCon);
        }
        numberToCon = 0;
        i = -1;
      }
      i++;
    }
    while (!stackInt.isEmpty()) {
      if (stackInt.peek() >= 10) {
        result += this.hexConverted(stackInt.pop());
      } else
        result = result + stackInt.pop();

    }
    this.setStringValue(result);
  }
  private String hexConversion(Queue<Character> number) {
    long numberToCon = 0;
    Queue<Long> queueInt = new LinkedList<Long>();
    int i = 0;
    char remove = ' ';
    String result = "";
    while (!number.isEmpty()) {
      remove = number.remove();
      if (remove == '1') {
        numberToCon = numberToCon + ((int) Math.pow(2, i));
      }
        if (i % 3 == 0 && i != 0) {
          if (numberToCon >= 10) {
            queueInt.add(numberToCon);
          } else {
            System.out.println(numberToCon);
            queueInt.add(numberToCon);
          }
          numberToCon = 0;
          i = -1;
        }
        i++;
      }
      
    while (!queueInt.isEmpty()) {
      if (queueInt.peek() >= 10) {
        result += this.hexConverted(queueInt.remove());
      }
      else {
        result = result + queueInt.remove();
      }
    }
    this.setStringValue(this.reverseString(result));
    return this.getStringValue();
  }

  protected void doConversion() {
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
  
  protected void doConversionWithQueue() {
    this.setValue(0);
    String number = Long.toString(this.getNumber());
    while (number.length() % 4 != 0) {
      number = "0" + number;
    }

    number = this.reverseString(number);
    Queue<Character> queue = new LinkedList<Character>();
    StringBuilder numberToConvert = new StringBuilder(number);

    char[] sendToHexConversion = new char[64];
    for (int i = 0; i < numberToConvert.length(); i++) {
      sendToHexConversion[i] = numberToConvert.charAt(i);
      queue.add(sendToHexConversion[i]);
    }
    
    this.hexConversion(queue);
  }
}
