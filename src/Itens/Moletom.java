/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itens;

import Itens.Camisa;

/**
 *
 * @author chris
 */
public class Moletom extends Camisa {
    private int life;
    
    public Moletom(String name, int weight, int armor, int life) {
        super(name, weight, armor);
        this.life = life;
    }

    public int getLife() {
        return life;
    }
    
}
