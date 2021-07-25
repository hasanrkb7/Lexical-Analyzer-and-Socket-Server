/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;
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
            Socket s = new Socket("localhost",6666);
            //connection established.
            
            InputStreamReader input = new InputStreamReader(new DataInputStream(s.getInputStream()));
            BufferedReader reader = new BufferedReader(input);
            
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            PrintWriter writer = new PrintWriter(output, true);
            
            Scanner sc = new Scanner(System.in);
                
            while(true){
                System.out.println("Enter 1 for Add, 2 for Sub, 3 for Mult, 0 to exit.");

                String operator = sc.nextLine();
                writer.println(operator);
                if(Integer.parseInt(operator)!=0){
                    System.out.println("Please enter 2 Operands:");

                    String op1 = sc.nextLine();
                    writer.println(op1);

                    String op2 = sc.nextLine();
                    writer.println(op2);
                }else{
                    writer.println("0");
                    writer.println("0");
                }
                String response = reader.readLine();
                System.out.println("Answer From Server = " + response);

                if (operator.equals("0")){
                    writer.println("0");
                    break;
                }
            }
            s.close();
            
            
        }catch(Exception e){System.out.println(e);}
        
    }
}
