package view;

import java.util.concurrent.Semaphore;

import controller.ThreadTreino;


public class Principal {
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
        Thread thread = new ThreadTreino(semaforo);
        thread.start();
    }
}