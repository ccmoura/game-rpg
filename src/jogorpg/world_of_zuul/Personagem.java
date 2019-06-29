/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.world_of_zuul;

import java.util.Random;

/**
 *
 * @author chris
 */
public abstract class Personagem {
    private String name;
    private byte maxEnergy;
    private byte currentEnergy;
    
    public Personagem(String nome, byte energia) {
        this.name = nome;
        this.maxEnergy = energia;
    }

    public void setMaxEnergy(byte maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public byte getMaxEnergy() {
        return maxEnergy;
    }
    
    public String getName() {
        return name;
    }

    public byte getEnergy() {
        return currentEnergy;
    }
     
    public byte luck(){
        Random random = new Random();
        return (byte) random.nextInt(6);
    }
    
    public void increaseEnergy(){
        if(currentEnergy < 10)
            currentEnergy++;
    }
    
    public void decreaseEnergy(){
        if(currentEnergy > 0){
            currentEnergy--;
        } 
        if(currentEnergy == 0){
            System.out.println(name + " is dead");
        }
    }
    
    public void feed(){
        increaseEnergy();
        increaseEnergy();
    }
    
    public void print(){
        System.out.println(
                "#####################" + 
                "\n# Nome: " + name +
                "\n# Energia: " + currentEnergy + 
                "\n#####################\n");
    }
}
