package christopher.practice1;

import java.util.Scanner;

/**
 *
 * @author Bluesky
 */
public class ArithmeticException {
    public static void main(String [] args){
    int number1=0,number2=0,result=0;
    try{
        System.out.println("Enter the first number:");
        Scanner scanner1=new Scanner(System.in);
        number1=scanner1.nextInt();
        System.out.println("Enter the second number:");
        Scanner scanner2=new Scanner(System.in);
        number2=Integer.parseInt(scanner2.nextLine());
        result=number1/number2;
    }
    catch(NumberFormatException e){
    System.out.println("Invalid integer entered!");
    System.exit(-1);
    }
    System.out.print(number1+"/"+number2+"="+result);
    }
}
