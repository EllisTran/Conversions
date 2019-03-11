import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String conversionType = "";
    int num1 = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println("Types of conversions available:\nBinary to Decimal\nBinary to Hexadecimal\n");
    System.out.print("Pick a conversion type: ");
    conversionType = scan.nextLine();

    System.out.print("What numbers would you like to convert? ");
    num1 = scan.nextInt();
    //num2 = scan.nextInt();
    
    Conversions conversion = new Conversions(conversionType, num1);

    System.out.println("The conversion type is: " + conversion.getConversionName());
    System.out.println("The number is: " + conversion.getNumber1());
    scan.close();
    
    if (conversion.getConversionName().equals("Binary to Decimal")) {
      System.out.println("Conversion is: " + conversion.getConversionValue());
    }

  }
}