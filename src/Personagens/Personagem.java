/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import java.util.Random;

/**
 *
 * @author chris
 */
public abstract class Personagem {
    private String name;
    private int maxEnergy;
    private int baseDamage;
    private int currentEnergy;

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }
    
    public Personagem(String nome, int energia, int d) {
        this.name = nome;
        this.maxEnergy = energia;
        currentEnergy = energia;
        baseDamage = d;
    }

    public void setMaxEnergy(int maxEnergy) {
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
        if(currentEnergy < 0){
            currentEnergy = 0;
        }
        if(currentEnergy == 0) System.out.println(name + " is dead");
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
