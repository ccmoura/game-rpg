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
public class Churros extends Item {
    private double extraLife;
    
    public Churros(String name, int weight) {
        super(name, weight);
        extraLife = 1.35;
    }

    public double getExtraLife() {
        return extraLife;
    }
    
}
