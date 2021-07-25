/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;
import java.io.*;
import java.net.*;
import java.util.Date;
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

                String today = new Date().toString();


                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                PrintWriter writer = new PrintWriter(output,true);

                writer.println(today);

                ss.close();
            }
        }catch(Exception e){System.out.println(e);}
    }
}
