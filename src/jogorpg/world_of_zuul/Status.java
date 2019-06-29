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
    private byte maxEnergy;
    private byte currentEnergy;
    private boolean additionalLuck;
    private double damageMultiplier;
    private int armor;
    private int damage;
    private double criticalChance;
    private boolean hitKillChance;

    public Status(byte maxEnergy, byte currentEnergy, Map<String, Item> inventory) {
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
    }
    
    
}
