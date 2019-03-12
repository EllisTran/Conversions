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

  
  //Setter and Getter Functions
  private void setNumber(int num) {
    this.number1 = num;
  }

  public int getNumber1() {
    return this.number1;
  }

  private void setConversionName(String conversionName) {
    this.conversionName = conversionName;
  }

  public String getConversionName() {
    return this.conversionName;
  }
  
  private void setConverted() {
    this.converted = true;
  }

  private boolean getConverted() {
    return this.converted;
  }

  public int getConversionValue() {
    if (this.conversionName.equals("Binary to Decimal") && !this.getConverted()) {
      return this.BinarytoDecimal();
    }
    return this.getValue();
  }
  
  private void setValue(int value) {
    this.value = value;
  }
  public int getValue() {
    return this.value;
  }

  private int BinarytoDecimal() {
    String number = Integer.toString(this.number1);

    // Reverse the string
    String numberToConvert = reverseString(number);

    for (int i = 0; i < number.length(); i++) {
      if (numberToConvert.charAt(i) == '1') {
        this.setValue(this.value + ((int) Math.pow(2, i)));
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
