/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import Itens.Wallet;

/**
 *
 * @author chris
 */
public class Vilao extends Personagem{
    private Wallet wallet;
    
    public Vilao(String nome, int energia, int coins, int d) {
        super(nome, energia, d);
        wallet = new Wallet();
        wallet.setCoins(coins);
    }
    
    public Wallet dropCoins(){
        return wallet;
    }
    
}
