import java.util.Scanner;
import java.util.Stack;

class DecimaltoHexadecimal extends Conversions {
  Stack<Long> stack;
  long permNum;
  
  DecimaltoHexadecimal(long num, Scanner scan) {
    super(num, scan, "DecimaltoHexadecimal");
    this.stack = new Stack<Long>();
    this.setPermNum(num);
    this.doFirst();
    this.setTime(this.getStartTime(), this.getEndTime());
  }

  private void setPermNum(long num) {
    this.permNum = num;
  }

  protected void doFirst() {
    this.introduction();
    this.setStartTime();
    this.doConversion();
    this.setEndTime();
  }

  protected void convertStacktoString(Stack<Long> stack) {
    String number = "";
    for (int i = 0; i < this.stack.size();) {
      if (this.stack.peek() > 9) {
        number = number + (this.hexConverted(this.stack.pop()));
      } else
        number = number + this.stack.pop().toString();
    }
    this.setStringValue(number);
  }

  protected void introduction() {
    System.out.println("Welcome to the " + this.getConversionName() + " Conversion.");
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

  protected void doConversion() {
    this.setValue(0);
    long remainder = 0;

    remainder = this.getNumber() % 16;
    this.stack.push(remainder);
    this.setNumber(this.getNumber() / 16);
    if (this.getNumber() != 0) {
      this.doConversion();
    }
    else {
      this.setNumber(this.permNum);
      this.convertStacktoString(stack);
    }
  }
}