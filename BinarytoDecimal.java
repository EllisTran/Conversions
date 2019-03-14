import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;
class BinarytoDecimal extends Conversions {
  BinarytoDecimal(int num) {
    this.setNumber(num);
    this.setConversionName("Binary to Decimal");
  }
  protected void setNumber(int num) {
    this.number1 = num;
  }

  protected void setConversionName(String conversionName) {
    this.conversionName = conversionName;
  }

  public String getConversionName() {
    return this.conversionName;
  }

  public int getNumber1() {
    return this.number1;
  }

  protected void setConverted() {
    this.converted = true;
  }

  public boolean getConverted() {
    return this.converted;
  }

  protected void setValue(int num) {
    this.value = num;
  }

  public int getValue() {
    return this.value;
  }

  public int doConversion() {
    this.setValue(0);
    String number = Integer.toString(this.getNumber1());

    // Reverse the string
    String numberToConvert = reverseString(number);

    for (int i = 0; i < number.length(); i++) {
      if (numberToConvert.charAt(i) == '1') {
        this.setValue(this.getValue() + ((int) Math.pow(2, i)));
      }
    }

    this.setConverted();
    return this.getValue();
  }

  public int doConversionWithStack() {
    this.setValue(0);
    String number = Integer.toString(this.getNumber1());
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = number.length() - 1; i >= 0; i--) {
      stack.push(Character.getNumericValue(number.charAt(i)));
    }
    for (int i = 0; i < number.length(); i++) {
      int num = stack.pop();
      if (num == 1) {
        this.setValue(this.getValue() + ((int) Math.pow(2, i)));
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

  public void printConversion() {
    System.out.println("The conversion name is: " + this.getConversionName());
    System.out.println("The number to be converted is: " + this.getNumber1());
    System.out.println("The converted value is (Regular Method): " + this.doConversion());
    System.out.println("The converted value is (Stack Method): " + this.doConversionWithStack());
  }
}