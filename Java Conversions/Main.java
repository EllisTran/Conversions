import java.util.Scanner;
public class Main {

  public static void main(String[] args) {
    String conversionType = "";
    long num1 = 0;
    Scanner scan = new Scanner(System.in);
    // Get user input
    do {
      System.out.println("Types of conversions available:\nBinary to Decimal\nBinary to Hexadecimal\n");
      System.out.print("Pick a conversion type: ");
      conversionType = scan.nextLine();
    } while (!(conversionType.equals("Binary to Decimal") || conversionType.equals("Binary to Hexadecimal")));

    System.out.print("What numbers would you like to convert? (Up to 20 digits): ");
    num1 = scan.nextLong();

    if (conversionType.equals("Binary to Decimal")) {
      BinarytoDecimal b2d = new BinarytoDecimal(num1, scan);
      b2d.printConversion();
    }
    else if (conversionType.equals("Binary to Hexadecimal")) {
      BinarytoHexadecimal b2h = new BinarytoHexadecimal(num1, scan);
      b2h.printConversion();
    }
    scan.close();
  }

}