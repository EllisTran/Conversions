import java.util.Stack;
import java.util.Scanner;

class BinarytoDecimal extends Conversions {
  BinarytoDecimal(long num, Scanner scan) {
    super(num, scan, "Binary to Decimal");
    this.doFirst();
    this.setTime(this.getStartTime(), this.getEndTime());
  }

  protected void doFirst() {
    this.introduction();
    this.setStartTime(); // Set time
    if (this.getDataStructureName().equals("Stack")) {
      System.out.println("Stack");
      this.doConversionWithStack();
    } else if (this.getDataStructureName().equals("Queue")) {
      System.out.println("Queue");
    } else if (this.getDataStructureName().equals("Normal")) {
      this.doConversion();
    }
    this.setEndTime(); // End Time
  }

  public void doConversion() {

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

  public long doConversionWithStack() {
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
    return this.getValue();
  }

  private String reverseString(String number) {
    StringBuilder sb = new StringBuilder();
    for (int i = number.length() - 1; i >= 0; i--) {
      sb.append(number.charAt(i));
    }
    return sb.toString();
  }
}