/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Bluesky
 */
public class FileIO_FileWriteExample5 {
    public static void main(String args[]) throws IOException{
        String filename="C:/Users/Bluesky/Desktop/2.txt";
        BufferedReader bufferedReader=new BufferedReader(new FileReader(filename));
        String s=bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
    }
}
