import java.lang.Math;

abstract class Conversions {
  protected String conversionName = "";
  protected long number1 = 0;
  protected long value = 0;
  protected boolean converted = false;

  // Setter and Getter Functions
  abstract void setNumber(long num);

  abstract long getNumber1();

  abstract void setConverted();

  abstract boolean getConverted();

  abstract void setValue(long value);

  abstract long getValue();

  abstract String getConversionName();

  abstract void setConversionName(String conversionName);

//  abstract void printConversion();
  protected void printConversion() {
    System.out.println("The conversion name is: " + this.getConversionName());
    System.out.println("The number to be converted is: " + this.getNumber1());
    System.out.println("The converted value is: " + this.getValue());
  }
}
