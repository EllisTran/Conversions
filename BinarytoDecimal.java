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

  public void printConversion() {
    System.out.println("The conversion name is: " + this.getConversionName());
    System.out.println("The number to be converted is: " + this.getNumber1());
    System.out.println("The converted value is: " + this.doConversion());
  }
}