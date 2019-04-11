import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Class Declaration
class BinarytoDecimal extends Conversions {
  //Constructor
  BinarytoDecimal(long num, Scanner scan) {
    super(num, scan, "Binary to Decimal");
    this.doFirst();
    this.setTime(this.getStartTime(), this.getEndTime());
  }

  //Methods
  protected void doFirst() {
    this.introduction();
    this.setStartTime(); // Set time
    if (this.getDataStructureName().equals("Stack")) {
      this.doConversionWithStack();
    } else if (this.getDataStructureName().equals("Queue")) {
      this.doConversionWithQueue();
    } else if (this.getDataStructureName().equals("Normal")) {
      this.doConversion();
    }
    this.setEndTime(); // End Time
  }

  protected void doConversion() {

    this.setValue(0);
    String number = Long.toString(this.getNumber());

    // Reverse the string
    String numberToConvert = reverseString(number);

    for (int i = 0; i < number.length(); i++) {
      if (numberToConvert.charAt(i) == '1') {
        this.setValue(this.getValue() + ((int) Math.pow(2, i)));
      }
    }
    this.setStringValue(Long.toString(this.getValue()));
    this.setConverted();

  }

  protected void doConversionWithStack() {
    long num = 0;
    this.setValue(0);
    String number = reverseString(Long.toString(this.getNumber()));
    Stack<Long> stack = new Stack<Long>();
    for (int i = number.length() - 1; i >= 0; i--) {
      stack.push((long) Character.getNumericValue(number.charAt(i)));
    }
    for (int i = 0; i < number.length(); i++) {
      if (stack.empty()) {
        break;
      }
      num = stack.pop();
      if (num == 1) {
        this.setValue(this.getValue() + ((int) Math.pow(2, i)));
      } else if (num == 0) {
        continue;
      }
    }
    this.setConverted();
    this.setStringValue(Long.toString(this.getValue()));
  }

  protected void doConversionWithQueue() {
    this.setValue(0);
    String number = Long.toString(this.getNumber());
    Queue<Long> queue = new LinkedList<Long>();
    for (int i = 0; i < number.length(); i++) {
      queue.add((long) Character.getNumericValue(number.charAt(i)));
    }
    for (int i = 0; i < number.length(); i++) {
      if (queue.poll() == 1) {
        this.setValue(this.getValue() + ((int) Math.pow(2,i)));
      }
      else {
        continue;
      }
    }
    this.setConverted();
    this.setStringValue(Long.toString(this.getValue()));
  }
}
