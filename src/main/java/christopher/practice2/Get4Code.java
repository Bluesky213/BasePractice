/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.util.Random;

/**
 *
 * @author Christopher
 */
public class Get4Code {
    public static void main(String args[]){
        System.out.println(get4Codes());
    }
        public static  String get4Codes(){
        StringBuffer sb = new StringBuffer();
        String codes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        for (int i =0; i< codes.length(); i++){
            char c = codes.charAt(random.nextInt(codes.length()));
            if (sb.length() == 4) break;
            if (!sb.toString().contains(c+"")) sb.append(c);
        }
        return sb.toString();
    }
}
