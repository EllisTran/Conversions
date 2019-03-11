import java.lang.Math;

public class Conversions {
  private String conversionName = "";
  private int number1 = 0;
  private int value = 0;
  private boolean converted = false;

  Conversions(String conversionName, int num) {
    this.setConversionName(conversionName);
    this.setNumber(num);
  }

  private void setConversionName(String conversionName) {
    this.conversionName = conversionName;
  }

  private void setNumber(int num) {
    this.number1 = num;
  }

  public String getConversionName() {
    return this.conversionName;
  }

  public int getNumber1() {
    return this.number1;
  }
  private void setConverted() {
    this.converted = true;
  }

  public boolean getConverted() {
    return this.converted;
  }
  public int getConversionValue() {
    if (this.conversionName.equals("Binary to Decimal") && !this.converted) {
      return this.BinarytoDecimal();
    }
    if (this.converted) 
      return this.value;
    return this.value;
  }

  private int BinarytoDecimal() {
    String number = Integer.toString(this.number1);
    System.out.println("The length of the number is: " + number.length());

    // Reverse the string
    String numberToConvert = reverseString(number);

    for (int i = 0; i < number.length(); i++) {
      if (numberToConvert.charAt(i) == '1') {
        this.value = this.value + ((int) Math.pow(2, i));
      }
    }
    return this.value;
  }

  private String reverseString(String number) {
    StringBuilder sb = new StringBuilder();
    for (int i = number.length() - 1; i >= 0; i--) {
      sb.append(number.charAt(i));
    }
    return sb.toString();
  }
}