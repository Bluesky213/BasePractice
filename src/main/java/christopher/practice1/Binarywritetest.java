/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Bluesky
 */
public class Binarywritetest {
    public static void main(String []args)throws IOException{
        int a=1;
        int b=1000;
        String filename="C:/Users/Bluesky/Desktop/5.dat";
        DataOutputStream out=new DataOutputStream(new FileOutputStream(filename));
        out.writeInt(a);
        out.writeInt(b);
        out.close();
    }
}
