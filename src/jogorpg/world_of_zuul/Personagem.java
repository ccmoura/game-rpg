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
    private int maxEnergy;
    private int currentEnergy;
    
    public Personagem(String nome, int energia) {
        this.name = nome;
        this.maxEnergy = energia;
    }

    public void setMaxEnergy(byte maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }
    
    public String getName() {
        return name;
    }

    public int getEnergy() {
        return currentEnergy;
    }
     
    public byte luck(){
        Random random = new Random();
        return (byte) random.nextInt(6);
    }
    
    public void increaseEnergy(int total){
        currentEnergy+=total;
        if(currentEnergy > maxEnergy) currentEnergy = maxEnergy;
    }
    
    public void decreaseEnergy(int total){
        currentEnergy -= total;
        if(currentEnergy > -1){
            currentEnergy = 0;
        } else{
            System.out.println(name + " is dead");
        }
    }
    
    public void feed(int total){
        increaseEnergy(total);
        increaseEnergy(total);
    }
    
    public void print(){
        System.out.println(
                "#####################" + 
                "\n# Nome: " + name +
                "\n# Energia: " + currentEnergy + 
                "\n#####################\n");
    }
}
