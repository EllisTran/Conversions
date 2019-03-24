import java.lang.Math;

abstract class Conversions {
  protected String conversionName = "";
  protected long number = 0;
  protected long value = 0;
  protected boolean converted = false;
  Conversions(long number, String conversionName) {
    this.setNumber(number);
    this.setConversionName(conversionName);
  }
  // Setter and Getter Functions
  private void setNumber(long number) {
    this.number = number;
  }
  protected long getNumber() {
    return this.number;
  }
  protected void setConverted() {
    this.converted = true;
  }
  protected boolean getConverted() {
    return this.converted;
  }
  protected void setValue(long value) {
    this.value = value;
  }
  protected long getValue() {
    return this.value;
  }
  private void setConversionName(String conversionName) {
    this.conversionName = conversionName;
  }
  protected String getConversionName() {
    return this.conversionName;
  }
  protected abstract void doConversion();

  protected void printConversion() {
    System.out.println("The conversion name is: " + this.getConversionName());
    System.out.println("The number to be converted is: " + this.getNumber());
    System.out.println("The converted value is: " + this.getValue());
  }
}
