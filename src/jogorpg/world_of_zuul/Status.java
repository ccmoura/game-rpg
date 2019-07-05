/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.world_of_zuul;

import java.util.Map;

/**
 *
 * @author chris
 */
public class Status {
    private int maxEnergy;
    private int currentEnergy;
    private boolean additionalLuck;
    private double damageMultiplier;
    private int armor;
    private int damage;
    private int criticalChance;
    private boolean hitKillChance;

    public Status(int maxEnergy, int currentEnergy, Map<String, Item> inventory, int baseDamage) {
        this.maxEnergy = maxEnergy;
        this.currentEnergy = currentEnergy;
        
        for(Item item : inventory.values()){
            if(item instanceof Camisa){
                armor = ((Camisa) item).getArmor();
            } else if(item instanceof Cajado){
                damage = ((Cajado) item).getDamage();
                hitKillChance = ((Cajado) item).getHitKillChance();
                criticalChance = ((Cajado) item).getCriticalChance();
            } else if(item instanceof Anel){
                additionalLuck = ((Anel) item).isAdditionalLuck();
                damageMultiplier = ((Anel) item).getDamageMultiplier();
            }
        }
        if(damageMultiplier == 0) damageMultiplier = 1;
        if(criticalChance == 0) criticalChance = 1;
        damage += baseDamage;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        if(currentEnergy>=0) this.currentEnergy = currentEnergy;
    }

    public boolean isAdditionalLuck() {
        return additionalLuck;
    }

    public void setAdditionalLuck(boolean additionalLuck) {
        this.additionalLuck = additionalLuck;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(byte criticalChance) {
        this.criticalChance = criticalChance;
    }

    public boolean isHitKillChance() {
        return hitKillChance;
    }

    public void setHitKillChance(boolean hitKillChance) {
        this.hitKillChance = hitKillChance;
    }

    @Override
    public String toString() {
        return "Status{" + "maxEnergy=" + maxEnergy + ", currentEnergy=" + currentEnergy + ", additionalLuck=" + additionalLuck + ", damageMultiplier=" + damageMultiplier + ", armor=" + armor + ", damage=" + damage + ", criticalChance=" + criticalChance + ", hitKillChance=" + hitKillChance + '}';
    }
    
    
}
