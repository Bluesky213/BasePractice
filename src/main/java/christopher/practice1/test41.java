/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

/**
 *
 * @author Bluesky
 */
public class test41 {
    public static void main(String [] args){
        String ratioStr = "0.0001";
        float ratio = Float.parseFloat(ratioStr)*10000;
        double coefficient = 1.229;
        double a = ratio * coefficient;
        System.out.println(a);
    }
}
