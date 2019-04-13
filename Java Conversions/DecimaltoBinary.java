import java.util.Scanner;
import java.util.Stack;

class DecimaltoBinary extends Conversions {
  Stack<Integer> stack;
  long permNum;
  DecimaltoBinary(long num, Scanner scan) {
    super(num, scan, "Decimal to Binary");
    this.stack = new Stack<Integer>();
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

  protected void convertStacktoString(Stack stack) {
    String number = "";
    for (int i = 0; i < this.stack.size();) {
      number = number + this.stack.pop().toString();
    }
    this.setStringValue(number);
  }

  protected void introduction() {
    System.out.println("Welcome to the " + this.getConversionName() + " Conversion.");
  }

  protected void doConversion() {
    this.setValue(0);
    if (this.getNumber() % 2 == 0) {
      this.stack.push(0);
      this.setNumber(this.getNumber() / 2);
    } else {
      this.stack.push(1);
      this.setNumber(this.getNumber() / 2);
    }
    if (this.getNumber() != 0) {
      this.doConversion();
    } else {
      this.setNumber(permNum);
      this.convertStacktoString(stack);
    }
  }
}