/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.io.IOException;

/**
 *
 * @author Bluesky
 */
public class executeApplication {
    public static void main(String args[]) throws IOException
    {
        Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe www.baidu.com/s?wd=呵呵");
    }
}
