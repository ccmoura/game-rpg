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
public class Anel extends Item{
    private boolean additionalLuck;
    private double damageMultiplier;
    
    public Anel(String name, int weight, boolean al, double dm) {
        super(name, weight);
        additionalLuck = al;
        damageMultiplier = dm;
    }

    public boolean isAdditionalLuck() {
        return additionalLuck;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }
    
}
