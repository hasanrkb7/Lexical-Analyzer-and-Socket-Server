/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task3;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rakibul Hasan Remon
 */
public class ServerThread extends Thread {
    private Socket socket;
    
    ServerThread(Socket s){
        socket = s;
    }
    
    public void run(){
        InputStreamReader input = null;
        try {
            input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
            BufferedReader reader = new BufferedReader(input);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            PrintWriter writer = new PrintWriter(output,true);
            while(true){
                String client_response = reader.readLine();
                
                if(client_response.equalsIgnoreCase("end game")){
                    writer.println("goodbye");
                    break;
                }else{
                    writer.println(client_response);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


