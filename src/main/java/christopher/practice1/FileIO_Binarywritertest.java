/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Bluesky
 */
public class FileIO_Binarywritertest {
    public static void main(String[]args)throws IOException{
        String filename="C:/Users/Bluesky/Desktop/6.dat";
        DataOutputStream dataOut=new DataOutputStream(
            new BufferedOutputStream(
            new FileOutputStream(filename)));
        dataOut.writeInt(0);
        System.out.println(dataOut.size()+"bytes have been written");
        dataOut.writeDouble(31.2);
        System.out.println(dataOut.size()+"bytes have been written");
        dataOut.writeBytes("JAVA");
        System.out.println(dataOut.size()+"bytes have been written");
        dataOut.close();
    }
}
