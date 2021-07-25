/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;
import java.io.*;
import java.net.*;
import java.util.Scanner;
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
            
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);
            
            Scanner sc = new Scanner(System.in);
                
                while(true){
                    System.out.println("Say Something to the Server -");
                    String in = sc.nextLine();
                    writer.println(in);
                    String response = reader.readLine();
                    System.out.println("From server - " + response);
                    
                    if (response.equalsIgnoreCase("goodbye"))
                        break;
                }
            s.close();
            
            
        }catch(Exception e){System.out.println(e);}
        
    }
}
