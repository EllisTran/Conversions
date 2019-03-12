import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //Initialize variables
    String conversionType = "";
    int num1 = 0;

    //Get user input
    Scanner scan = new Scanner(System.in);
   
    do {
      System.out.println("Types of conversions available:\nBinary to Decimal\nBinary to Hexadecimal\n");
      System.out.print("Pick a conversion type: ");
      conversionType = scan.nextLine();
    }
    while(!(conversionType.equals("Binary to Decimal") || conversionType.equals("Binary to Hexadecimal")));

    System.out.print("What numbers would you like to convert? ");
    num1 = scan.nextInt();
    
    //Initialize Object
    BinarytoDecimal b2d = new BinarytoDecimal(num1);

    System.out.println("The conversion type is: " + b2d.getConversionName());
    System.out.println("The number is: " + b2d.getNumber1());
    scan.close();
    
    if (conversionType.equals("Binary to Decimal")) {
      System.out.println("Conversion is: " + b2d.doConversion());
    }

  }
}