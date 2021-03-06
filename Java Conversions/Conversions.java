import java.lang.Math;
import java.util.Scanner;

//Abstract Class Declaration
abstract class Conversions {
  // Initialize Member Variables
  private String conversionName = "";
  private String stringValue = "";
  private long number = 0;
  private long value = 0;
  private long time = 0;
  private long startTime = 0;
  private long endTime = 0;
  private String dataName = "";
  private boolean converted = false;
  private Scanner scan;

  //Constructor
  Conversions(long number, Scanner scan, String conversionName) {
    this.setNumber(number);
    this.setConversionName(conversionName);
    this.setScanner(scan);
  }

  protected void introduction() {
    boolean firstIter = false;
    String dataName = ""; // To get which data structure the user wants to use.
    System.out.println(
        "\nWelcome to the " + this.conversionName + " Conversion.\nWhich Data Structure would you like to use?\n");
    do {
      if (firstIter) {
        System.out.println("Error. Please enter again\n");
      }
      if (this.getConversionName().equals("Binary to Decimal"))
        System.out.println("Stack\nQueue\nNormal (Iterates through a loop)");
      else if (this.getConversionName().equals("Binary to Hexadecimal")){
        System.out.println("Stack\nQueue");
      }
      dataName = this.scan.next();
      firstIter = true;
    } while (!(dataName.equals("Stack") || dataName.equals("Queue") || dataName.equals("Normal")));
    System.out.println("\nYou chose the " + dataName + " method\n");
    this.setDataStructureName(dataName);
  }

  protected String reverseString(String number) {
    StringBuilder sb = new StringBuilder();
    for (int i = number.length() - 1; i >= 0; i--) {
      sb.append(number.charAt(i));
    }
    return sb.toString();
  } 

  // Setter and Getter Functions
  protected void setNumber(long number) {
    this.number = number;
  }

  protected long getNumber() {
    return this.number;
  }

  protected void setStartTime() {
    this.startTime = System.nanoTime();
  }

  protected void setEndTime() {
    this.endTime = System.nanoTime();
  }

  protected long getStartTime() {
    return this.startTime;
  }

  protected long getEndTime() {
    return this.endTime;
  }

  protected void setTime(long timeStart, long timeEnd) {
    this.time = (timeEnd - timeStart);
  }

  protected long getTime() {
    return this.time / 1000; // pico seconds
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

  // Abstract methods (Methods that are required in every child class!)
  protected abstract void doConversion();

  protected abstract void doFirst();

  protected void printConversion() {
    System.out.println("The conversion name is: " + this.getConversionName());
    if (!this.getDataStructureName().equals(""))
      System.out.println("The data structure used is: " + this.getDataStructureName());
    System.out.println("The number to be converted is: " + this.getNumber());
    System.out.println("The converted value is: " + this.getStringValue());
    System.out.println("The time it took to convert: " + this.getTime() + " picoseconds");
  }
}
