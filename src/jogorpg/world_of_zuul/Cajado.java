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
public class Cajado extends Item{
    private int damage;
    private double criticalChance;
    private boolean hitKillChance;
    
    public Cajado(String name, int weight, int damage, double cc, boolean hk) {
        super(name, weight);
        this.damage = damage;
        criticalChance = cc;
        hitKillChance = hk;
    }

    public int getDamage() {
        return damage;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public boolean getHitKillChance() {
        return hitKillChance;
    }
    
}
