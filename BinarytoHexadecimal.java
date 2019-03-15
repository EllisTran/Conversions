import java.util.*;

class BinarytoHexadecimal extends Conversions {
  private String stringValue = "";
  BinarytoHexadecimal(int num) {
    this.setNumber(num);
    this.setConversionName("Binary to Hexadecimal");
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
  @Override
  protected void setValue(int num) {
    this.value = num;
  }

  public int getValue() {
    return this.value;
  }
  private void setStringValue(String number) {
    this.stringValue = number;
  }

  public String getStringValue() {
    return this.stringValue;
  }

  private char hexConverted(int number) {
    switch (number) {
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
    System.out.println("HexConversion");
    int numberToCon = 0;
    Stack<Integer> stackInt = new Stack<Integer>();
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
      System.out.println(stackInt.peek());
      if (stackInt.peek() >= 10) {
        result += this.hexConverted(stackInt.pop());
      }
      else result = result + stackInt.pop();
      
    }
    this.setStringValue(result);
    System.out.println(result);
    
    return this.getStringValue();
  }

  public String doConversion() {
    this.setValue(0);
    String number = Integer.toString(this.getNumber1());
    while (number.length() % 4 != 0) {
      number = "0" + number;
    }
    System.out.println("STRING NUMBER: " + number);
    Stack<Character> stack = new Stack<Character>();
    StringBuilder numberToConvert = new StringBuilder(number);

    char[] sendToHexConversion = new char[64];
    for (int i = 0; i < numberToConvert.length(); i++) {
      sendToHexConversion[i] = numberToConvert.charAt(i);
      stack.push(sendToHexConversion[i]);
    }
    this.hexConversion(stack);
    
    this.setConverted();
    return this.getStringValue();
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
    // System.out.println("The converted value is (Stack Method): " +
    // this.doConversionWithStack());
  }
}