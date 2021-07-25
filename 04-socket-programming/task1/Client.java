/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;
import java.io.*;
import java.net.*;
/**
 *
 * @author Rakibul Hasan Remon
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",7777);
            //connection established.
            
            InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader reader = new BufferedReader(input);
            
            System.out.println("Response = "+reader.readLine());
            
            s.close();
            
            
        }
        catch(Exception e){System.out.println(e);}
        
    }
}
