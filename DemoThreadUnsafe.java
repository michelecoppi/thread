/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demothreadunsafe;
import java.util.Random;

public class DemoThreadUnsafe {

static Random random = new Random(System.currentTimeMillis());

   
    public static void main(String[] args) throws InterruptedException {
      
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        
        Thread thread1 = new Thread(new Runnable() {
          
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrementa();
                    DemoThreadUnsafe.sleep();
                    
                }
            }
        });

        
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.aggiungi();
                    DemoThreadUnsafe.sleep();
                }
            }
        });

        
        thread1.start();
        thread2.start();

        
        thread1.join();
        thread2.join();

        //il numero sperato è 0 però eseguendo più volte il programma il risultato non è sempre 0.
        badCounter.stampaNumeroFinale();
    }

    public static void sleep() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }
}



    
    

