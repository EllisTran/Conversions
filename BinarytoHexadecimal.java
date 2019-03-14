import java.util.*;

class BinarytoHexadecimal extends Conversions {
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

  protected void setValue(int num) {
    this.value = num;
  }

  public int getValue() {
    return this.value;
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

  private char hexConversion(char[] number) {
    System.out.println("REAL SIZE: " + number.length);
    for (int i = 0; i < number.length; i++) {
      System.out.println(number[0]);
      if (i < number.length) {
        System.out.println("HELLO WORLD" + i);
      }
    }
    System.out.println("SIZE: " + number.length);
    int numberBeforeHex = 0;
    for (int i = 0; i < number.length; i++) {
      // System.out.println(number[i]);
      if (number[i] == '1') {
        numberBeforeHex = numberBeforeHex + ((int) Math.pow(2, i));
      }
    }
    System.out.println(numberBeforeHex);
    if (numberBeforeHex > 10) {
      System.out.println(this.hexConverted(numberBeforeHex));
      return this.hexConverted(numberBeforeHex);
    } else
      return (char) numberBeforeHex;
  }

  public int doConversion() {
    String s = "";
    boolean count = false;
    this.setValue(0);
    String number = Integer.toString(this.getNumber1());

    while (number.length() % 4 != 0) {
      number = "0" + number;
    }
    // Reverse the string
    System.out.println("STRING NUMBER: " + number);
    String numberTest = reverseString(number);
    // StringBuilder numberToConvert = new
     StringBuilder numberToConvert = new StringBuilder(numberTest);
    
    Stack<Character> stack = new Stack<Character>();
    char[] sendToHexConversion = new char[64];
    for (int i = 0; i < numberToConvert.length(); i++) {
      sendToHexConversion[i] = numberToConvert.charAt(i);
      System.out.println("Index " + i + ": " + sendToHexConversion[i]);
      if (i % 3 == 0 && i != 1 && i != 0 && !count) {
        System.out.println("LALA: " + i);
        // for (int j = 0; j < 4; j++) {
        //   System.out.println("Index " + j + ": " + sendToHexConversion[j]);
        // }
        //this.hexConversion(sendToHexConversion);
       // numberToConvert.delete(0, 4);
        count = true;
      }
      else if (i % 4 == 0 && i!=1 && i!=0 && count && i != 4) {
        System.out.println("LALA: " + i);
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
    // System.out.println("The converted value is (Stack Method): " +
    // this.doConversionWithStack());
  }
}