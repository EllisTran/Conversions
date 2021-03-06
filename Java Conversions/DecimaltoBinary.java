import java.util.Scanner;
import java.util.Stack;

import com.sun.jdi.LongValue;

class DecimaltoBinary extends Conversions {
  Stack<Long> stack;
  long permNum;
  DecimaltoBinary(long num, Scanner scan) {
    super(num, scan, "Decimal to Binary");
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
      this.stack.push((long) 0);
      this.setNumber(this.getNumber() / 2);
    } else {
      this.stack.push((long) 0);
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