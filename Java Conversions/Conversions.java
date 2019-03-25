import java.lang.Math;
import java.util.Scanner;

abstract class Conversions {
  protected String conversionName = "";
  protected String stringValue = "";
  protected long number = 0;
  protected long value = 0;
  protected String dataName = "";
  protected boolean converted = false;
  protected Scanner scan;
  Conversions(long number, Scanner scan, String conversionName) {
    this.setNumber(number);
    this.setConversionName(conversionName);
    this.setScanner(scan);
  }

  protected void introduction() {
    boolean firstIter = false;
    String dataName = ""; // To get which data structure the user wants to use.
    System.out.println("\nWelcome to the " + this.conversionName + " Conversion.\nWhich Data Structure would you like to use?\n");
    do {
      if (firstIter) {
        System.out.println("Error. Please enter again\n");
      }
      System.out.println("Stack\nQueue\nNormal (Iterates through a loop)");
      dataName = this.scan.next();
      firstIter = true;
    } while (!(dataName.equals("Stack") || dataName.equals("Queue") || dataName.equals("Normal")));
    System.out.println("\nYou chose the " + dataName + " method\n");
    this.setDataStructureName(dataName);
  }

  abstract protected void doFirst();
  // Setter and Getter Functions
  private void setNumber(long number) {
    this.number = number;
  }
  protected long getNumber() {
    return this.number;
  }
  private void setScanner(Scanner scan) {
    this.scan = scan;
  }
  private void setDataStructureName(String dataName) {
    this.dataName = dataName;
  }
  protected String getDataStructureName() {
    return this.dataName;
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
  protected void setStringValue(String number) {
    this.stringValue = number;
  }

  protected String getStringValue() {
    return this.stringValue;
  }
  protected abstract void doConversion();

  protected void printConversion() {
    System.out.println("The conversion name is: " + this.getConversionName());
    System.out.println("The data structure used is: " + this.getDataStructureName());
    System.out.println("The number to be converted is: " + this.getNumber());
    System.out.println("The converted value is: " + this.getValue());
  }
}