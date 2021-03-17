package demothreadunsafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
class ThreadUnsafeCounter {

    int count = 0;

    public void decrementa() {
        count++;
    }

    public void aggiungi() {
        count--;
    }

    void stampaNumeroFinale() {
        System.out.println("counter is: " + count);
    }
}
