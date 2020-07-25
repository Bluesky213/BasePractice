/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.BaiduOCR;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.w3c.dom.Element;

/**
 *
 * @author Bluesky
 */
public class test2 {
	public static void main(String args[])
	{
		WebView webview=new WebView();
		WebEngine webengine=new WebEngine();
                Element e=webengine.getDocument().getElementById("userAccount");
                System.out.println(e);
		webengine.load("executeScript(\"alert('Helloworld')\");");
		webview.getEngine().executeScript("alert.('HelloWorld')");
	}
}
