package com.stacktips.threads;

class RunnableExample implements Runnable {
    public void run() {
        System.out.println("Thread runs...");
    }

    public static void main(String args[]) {
        Thread ib = new Thread(new ThreadExample());
        ib.start();
    }
}