/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.world_of_zuul;

/**
 *
 * @author chris
 */
public class SimuladorDeBatalha {
    
    public static void main(String[] args) {
        Vilao v = new Vilao("Nemesis",  10, 800, 90);
        Heroi h = new Heroi("Jill Valentine",  10, 70);
        boolean end = false;
        
        while(!end){
            h.fight(v);
            h.print();
            v.print();
            if(h.getEnergy() == 0){
                end = true;
                System.out.println(v.getName()+ " wins!\nEnergy: " + v.getEnergy());
            } else if(v.getEnergy() == 0){
                end = true;
                System.out.println(h.getName()+ " wins!\nEnergy: " + h.getEnergy());
            }
        }
    }
    
}
