/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author Bluesky
 */
//java程序让默认浏览器打开并访问一个网页
public class openUrl {
    public static void main(String args[]) throws URISyntaxException, IOException
    {
        java.net.URI uri = new java.net.URI("http://www.baidu.com");
                  java.awt.Desktop.getDesktop().browse(uri);
    }
}
