/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Rakibul Hasan Remon
 */
public class Server {
    public static void main(String[] args) {
        try{
            while(true){
                ServerSocket ss = new ServerSocket(7777);
                System.out.println("Server running at Port : 7777");
                Socket socket = ss.accept();
                System.out.println("Client Connected.");

                InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
                BufferedReader reader = new BufferedReader(input);
            
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output,true);
                
                
                while(true){
                    String client_response = reader.readLine();
                    if(client_response.equalsIgnoreCase("end game")){
                        writer.println("Goodbye");
                        break;
                    }else{
                        writer.println(client_response);
                    }
                    
                }

                ss.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}
