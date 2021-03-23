package controller;

import java.util.concurrent.Semaphore;

public class ThreadTreino extends Thread {
    private Semaphore semaforo;
    private int melhorVolta;
    private int carro;
    private int equipe;
    
    public ThreadTreino ( Semaphore semaforo ) {
        this.semaforo = semaforo;
    }
    
    public void run () {
        try {
            semaforo.acquire();
            Corrida();
        }
            catch (InterruptedException e)
    		{
    			e.printStackTrace();
    		}
    		finally
    		{
    			semaforo.release();
    		}
   }

    public void Corrida () { 
        int i;
        
        for (i = 1 ; i < 3 ; i ++) {
            for (equipe = 1 ; equipe < 8 ; equipe ++) {
            	
                carro = (int)(Math.random() * 14);
                
                melhorVolta = 10000;
                
                System.out.println("O carro #"+carro+" da equipe #"+equipe+" entrou na pista");
                
                for (int b = 0; b < 3; b++)
        		{
        			int lap = (int) ((Math.random() * 2001) + 1000);
        			
        			
        			if (lap < melhorVolta)
        			{
        				melhorVolta = lap;
        			}
        			
        			System.out.println("Carro #" + carro + " da equipe " + equipe + " completou sua "
        					+ (b+1) + "º volta em " + (lap / Math.pow(10, 3)) + "s.");
        		}
        		System.out.println("Carro #" + carro + " da equipe " + equipe + " completou as 3 voltas do circuito - "
        				+ "Melhor tempo: " + (melhorVolta / Math.pow(10, 3)) + "s. \n");
        		
            }
        }
    }
}