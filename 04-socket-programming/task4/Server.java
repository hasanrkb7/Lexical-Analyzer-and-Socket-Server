/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;
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
                ServerSocket ss = new ServerSocket(6666);
                System.out.println("Server running at Port : 6666");
                Socket socket = ss.accept();
                System.out.println("Client Connected.");

                InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
                BufferedReader reader = new BufferedReader(input);
            
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output,true);
                
                
                while(true){
                    String cr1 = reader.readLine();
                    String op1 = reader.readLine();
                    String op2 = reader.readLine();
                    
                    if(cr1.equals("1")){
                        writer.println((Integer.parseInt(op1))+(Integer.parseInt(op2)));
                    }else if (cr1.equals("2")){
                        writer.println((Integer.parseInt(op1))-(Integer.parseInt(op2)));
                    }else if (cr1.equals("3")){
                        writer.println((Integer.parseInt(op1))*(Integer.parseInt(op2)));
                    }else if (cr1.equals("0")){
                        writer.print("goodbye");
                        break;
                    }
                    
                }

                ss.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}
