/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

import java.util.*;


class Task03 extends Thread{
     
     private long firstodd;
     private long firsteven;
     private long sumodd;
     private long sumeven;
     private long avg;
     
     private List<Integer> series=new ArrayList<Integer>();
     
     
     Task03(int num){
          series.add(0);
          series.add(1);
          int val=0;
          for(int i=2; i<num; ++i){
               val = series.get(i-2)+series.get(i-1);
               series.add(val);
          }
     }
     
     
     public void run(){
          String name = Thread.currentThread().getName();
          switch(name){
               case "firstodd":
                    firstoddMean();
                    System.out.println("Mean of 1st odd numbers: "+firstodd);
                    break;
               case "firsteven":
                    firstevenMean();
                    System.out.println("Mean of 1st even numbers: "+firsteven);
                    break;
               case "sumodd":
                    sumoddMean();
                    System.out.println("Mean of 2nd odd numbers: "+sumodd);
                    break;
               case "sumeven":
                    sumevenMean();
                    System.out.println("Mean of 2nd even numbers: "+sumeven);
                    break;
               default:
                    firstoddMean();
                    firstevenMean();
                    sumoddMean();
                    sumevenMean();
                    avg = (firstodd + firsteven + sumodd + sumeven) / 4;
                    System.out.println("Average Means: "+avg);
          }
     }
     
     
     private void firstoddMean(){
          int count=0;
          firstodd=0;
          
          for(int i=0; i < (series.size()/2); i++){
               if( series.get(i)%2 != 0){
                    firstodd=firstodd+series.get(i);
                    count++;
               }
          }
          
          firstodd = firstodd / count;
     }
     
     
     private void firstevenMean(){
          int count=0;
          firsteven=0;
          
          for(int i=0; i < (series.size()/2); i++){
               if( series.get(i)%2 == 0){
                    firsteven=firsteven+series.get(i);
                    count++;
               }
          }
          
          firsteven = firsteven / count;
     }
     
     
     private void sumoddMean(){
          int count=0;
          sumodd=0;
          
          for(int i= (series.size()/2)  ; i < series.size(); i++){
               if( series.get(i)%2 != 0){
                    sumodd=sumodd+series.get(i);
                    count++;
               }
          }
          
          sumodd = sumodd / count ;
     }
     
     
     private void sumevenMean(){
          int count=0;
          sumeven=0;
          
          for(int i = (series.size() /2 ) ; i < series.size(); i++){
               if( series.get(i)%2 == 0){
                    sumeven=sumeven+series.get(i);
                    count++;
               }
          }
          
          sumeven = sumeven / count ;
     }
     
public static void main(String[] args){
          Task03 fs = new Task03(10);
          Thread t1 = new Thread(fs);
          t1.setName("firstodd");
          Thread t2 = new Thread(fs);
          t2.setName("firsteven");
          Thread t3 = new Thread(fs);
          t3.setName("sumodd");
          Thread t4 = new Thread(fs);
          t4.setName("sumeven");
          Thread t5 = new Thread(fs);
          t5.setName("avg");
          
          t1.start();
          t2.start();
          t3.start();
          t4.start();
          t5.start();
     }
}