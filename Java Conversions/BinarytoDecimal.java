import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;
class BinarytoDecimal extends Conversions {
  BinarytoDecimal(long num) {
    this.setNumber(num);
    this.setConversionName("Binary to Decimal");
  }
  protected void setNumber(long num) {
    this.number1 = num;
  }

  protected void setConversionName(String conversionName) {
    this.conversionName = conversionName;
  }

  public String getConversionName() {
    return this.conversionName;
  }

  public long getNumber1() {
    return this.number1;
  }

  protected void setConverted() {
    this.converted = true;
  }

  public boolean getConverted() {
    return this.converted;
  }

  protected void setValue(long num) {
    this.value = num;
  }

  public long getValue() {
    return this.value;
  }

  public long doConversion() {
    this.setValue(0);
    String number = Long.toString(this.getNumber1());

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

  public long doConversionWithStack() {
    long num = 0;
    this.setValue(0);
    String number = reverseString(Long.toString(this.getNumber1()));
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
}