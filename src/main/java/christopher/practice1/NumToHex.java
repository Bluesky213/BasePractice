/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christopher.practice1;

/**
 *
 * @author Christopher
 */
public class NumToHex {
    
    public static void main(String argsp[]){
        System.out.println(numToHex16(Float.parseFloat("9746.0")));
    }
    
    	private static final char[] HEX_CHAR_TABLE = {
		'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'	
	};
        
    	public static String toHexString(byte[] data){
        if(data == null || data.length == 0)
            return null;
        byte[] hex = new byte[data.length * 2];
        int index = 0;
        for(byte b : data){
            int v = b & 0xFF;
            hex[index++] = (byte) HEX_CHAR_TABLE[v >>> 4];
            hex[index++] = (byte) HEX_CHAR_TABLE[v & 0xF];
        }
        return new String(hex);
    }
        
        public static String numToHex16(int b) { return String.format("%04x", b); }
        
        public static String numToHex16(float b) { return String.format("%04x", b); }
}
