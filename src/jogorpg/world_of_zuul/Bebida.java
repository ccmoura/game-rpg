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
public class Bebida extends Item {
    private int maxLife;
    
    public Bebida(String name, int weight, int maxLife) {
        super(name, weight);
        this.maxLife = maxLife;
    }
    
}
