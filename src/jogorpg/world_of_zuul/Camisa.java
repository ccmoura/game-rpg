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
public class Camisa extends Item{
    private int armor;
    
    public Camisa(String name, int weight, int armor) {
        super(name, weight);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }
    
}
