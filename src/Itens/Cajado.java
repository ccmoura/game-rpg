/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itens;

/**
 *
 * @author chris
 */
public class Cajado extends Item{
    private int damage;
    private int criticalChance;
    private boolean hitKillChance;
    
    public Cajado(String name, int weight, int damage, int cc, boolean hk) {
        super(name, weight);
        this.damage = damage;
        criticalChance = cc;
        hitKillChance = hk;
    }

    public int getDamage() {
        return damage;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    public boolean getHitKillChance() {
        return hitKillChance;
    }
    
}
