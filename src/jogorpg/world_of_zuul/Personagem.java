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
    private byte energy;
    
    public Personagem(String nome, byte energia) {
        this.name = nome;
        this.energy = energia;
    }

    public String getName() {
        return name;
    }

    public byte getEnergy() {
        return energy;
    }
     
    public byte luck(){
        Random random = new Random();
        return (byte) random.nextInt(6);
    }
    
    public void increaseEnergy(){
        if(energy < 10)
            energy++;
    }
    
    public void decreaseEnergy(){
        if(energy > 0){
            energy--;
        } 
        if(energy == 0){
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
                "\n# Energia: " + energy + 
                "\n#####################\n");
    }
}
