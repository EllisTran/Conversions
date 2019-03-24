import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;
class BinarytoDecimal extends Conversions {
  BinarytoDecimal(long num) {
    super(num, "Binary to Decimal");
    this.doConversion();
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
      }
      else if (num == 0) {
        continue;
      }
    }
    this.setConverted();

    return this.getValue();
  }

  private String reverseString(String number) {
    StringBuilder sb = new StringBuilder();
    for (int i = number.length() - 1; i >= 0; i--) {
      sb.append(number.charAt(i));
    }
    return sb.toString();
  }

  // public void printConversion() {
  //   System.out.println("The conversion name is: " + this.getConversionName());
  //   System.out.println("The number to be converted is: " + this.getNumber1());
  //   System.out.println("The converted value is (Regular Method): " + this.doConversion());
  //   System.out.println("The converted value is (Stack Method): " + this.doConversionWithStack());
  // }
}