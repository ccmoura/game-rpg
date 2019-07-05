/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

/**
 *
 * @author chris
 */
public class Vilao extends Personagem{
    private int coins;
    
    public Vilao(String nome, int energia, int coins, int d) {
        super(nome, energia, d);
        this.coins = coins;
    }
    
    public int dropCoins(){
        return coins;
    }
    
}
