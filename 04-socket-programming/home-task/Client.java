/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometask;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author Rakibul Hasan Remon
 */
public class Client {
    public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 6666);

			InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
			BufferedReader reader = new BufferedReader(input);

			DataOutputStream output = new DataOutputStream(s.getOutputStream());
			PrintWriter writer = new PrintWriter(output, true);

			Scanner sc = new Scanner(System.in);
			System.out.println("What you want to convert to ASCII? : ");

			String message = sc.nextLine();
			writer.println(message);

			for (int i = 0; i < message.length(); i++) {
				System.out.println(reader.readLine());
			}


			sc.close();

			s.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
