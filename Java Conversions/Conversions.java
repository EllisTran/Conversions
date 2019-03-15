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

  abstract void printConversion();
}
