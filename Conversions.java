import java.lang.Math;

  abstract class Conversions {
  protected String conversionName = "";
  protected int number1 = 0;
  protected int value = 0;
  protected boolean converted = false;

  Conversions() { }
  
  //Setter and Getter Functions
  abstract void setNumber(int num);
  abstract int getNumber1();
  abstract void setConverted();
  abstract boolean getConverted();
  abstract void setValue(int value);
  abstract int getValue();
  abstract String getConversionName();
  abstract void setConversionName(String conversionName);
  abstract void printConversion();
}
