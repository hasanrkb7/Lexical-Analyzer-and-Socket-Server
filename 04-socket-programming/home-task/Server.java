/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometask;
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
		try {
			while(true) {
				ServerSocket ss = new ServerSocket(6666);
				System.out.println("Server Running at Port: 6666");
				Socket socket = ss.accept();
				System.out.println("Client Connected");

				InputStreamReader input = new InputStreamReader(new DataInputStream(socket.getInputStream()));
				BufferedReader reader = new BufferedReader(input);

				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				PrintWriter writer = new PrintWriter(output, true);

				String client_message = reader.readLine();
				char[] message = client_message.toCharArray();

				for (int i = 0; i < message.length; i++) {
					int ascii = message[i];
					writer.println("ASCII code of " + message[i] + " is: " + ascii);
				}


				ss.close();
			}


		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
