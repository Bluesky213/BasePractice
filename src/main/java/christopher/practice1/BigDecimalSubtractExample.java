/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.math.BigDecimal;

/**
 *
 * @author Christopher
 */
public class BigDecimalSubtractExample {
    public static void main(String[] args)
    {
        double  a=3.0;
        double  b=2.1;
        BigDecimal bigDecimal1=new BigDecimal(String.valueOf(a));
        BigDecimal bigDecimal2=new BigDecimal(String.valueOf(b));
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);
        System.out.println(bigDecimal1.subtract(bigDecimal2));
        
        double c=3.0;
        double d=2.1;
        System.out.println(Double.valueOf(c-d));
    }
}
