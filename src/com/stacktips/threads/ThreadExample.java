package com.stacktips.threads;

class ThreadExample extends Thread {
   public void run(){  
       System.out.println("Thread runs...");  
   }  
   public static void main(String args[]){  
       ThreadExample threadExample = new ThreadExample();
       threadExample.start();
   }  
}