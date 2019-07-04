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
public abstract class Item {
    private String name;
    private int weight;
    private int durability;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
        durability = 100;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability -= durability;
        if(this.durability < 0) this.durability = 0;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    
}
