/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice2;

import java.net.InetAddress;

/**
 *
 * @author Christopher
 */
public class getIPAddress {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
            
            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
