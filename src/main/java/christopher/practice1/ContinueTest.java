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
public class ContinueTest {
    public static void main(String [] args){
    String output="";
    int i;
    for(i=1;i<=10;i++){
        if(i==5)
        {continue;
            }
    output+=i+"";
    }
    
    output+="\nUsing continue to skip printing 5";
    output+="\ni="+i;
    System.out.println(output);
}
}
