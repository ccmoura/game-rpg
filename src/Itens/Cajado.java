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
    private byte criticalChance;
    private boolean hitKillChance;
    
    public Cajado(String name, int weight, int damage, byte cc, boolean hk) {
        super(name, weight);
        this.damage = damage;
        criticalChance = cc;
        hitKillChance = hk;
    }

    public int getDamage() {
        return damage;
    }

    public byte getCriticalChance() {
        return criticalChance;
    }

    public boolean getHitKillChance() {
        return hitKillChance;
    }
    
}
