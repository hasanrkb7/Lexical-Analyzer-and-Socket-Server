/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

class Task02 extends Thread{
     public void run(){
          System.out.println("The house is  "+Thread.currentThread().getName());
          
          if(Thread.currentThread().getName().equals("Stark") || Thread.currentThread().getName().equals("Targaryen")){
               try {
                    
                    Thread.sleep(1000);
               } 
               catch (InterruptedException e) {
                   
                    e.printStackTrace();
               }
          }
          else if(Thread.currentThread().getName().equals("Lannister") || Thread.currentThread().getName().equals("Bolton")){
               try {
                    
                    Thread.sleep(3000);
               } 
               catch (InterruptedException e) {
                   
                    e.printStackTrace();
               }
          }
          else{
               try {
                 
                    Thread.sleep(5000);
               } 
               catch (InterruptedException e) {
                 
                    e.printStackTrace();
               }
          }
     }



     public static void main(String[] args){
       
          Task02 house1=new Task02();
          Task02 house2=new Task02();
          Task02 house3=new Task02();
          Task02 house4=new Task02();
          Task02 house5=new Task02();
          
          
          Thread t1 = new Thread(house1);
          t1.setPriority(Thread.MAX_PRIORITY);
          t1.setName("Stark");
          
          Thread t2 = new Thread(house2);
          t2.setName("Targaryen");
          
          Thread t3 = new Thread(house3);
          t3.setName("Lannister");
          
          Thread t4 = new Thread(house4);
          t4.setPriority(Thread.MIN_PRIORITY);
          t4.setName("Bolton");
          
          if( !t4.isAlive()){
               System.out.println("You know nothing!");
          }
          
          t1.start();
          
          if( t1.isAlive()){
               System.out.println("Not Today!");
          }
          
          t2.start();
          t3.start();
          t4.start();
          
          
          Thread t5 = new Thread(house5);
          t5.setPriority(Thread.MAX_PRIORITY);
          t5.setName("Stark");
          
          Thread t6 = new Thread(house5);
          t6.setName("Lannister");
          
          Thread t7 = new Thread(house5);
          t7.setPriority(Thread.MIN_PRIORITY);
          t7.setName("Bolton");
          
          if(!t7.isAlive()){
               System.out.println("You know nothing!");
          }
          
          t5.start();
          if( t5.isAlive()){
               System.out.println("Not Today!");
          }
          
          t6.start();
          t7.start();
     }
}