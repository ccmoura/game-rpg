package Itens;

import Itens.Item;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class Wallet extends Item {
    int coins;
    
    public Wallet() {
        super("Coins", 0);
    }
    
    public void addCoins(int coins, int weightLimit){
        int w = (int) Math.ceil((double)(coins+this.coins)/1000);
        if(w<=weightLimit){
            this.coins+=coins;
            this.setWeight(w > this.getWeight() ? this.getWeight()+w : this.getWeight());
        } else{
            System.out.println("Você não tem espaço para essa quantia.");
        }
    }
    
    public void removeCoins(int coins){
        if(coins<=this.coins){
            this.coins -= coins;
            this.setWeight((int) Math.ceil((double)(this.coins-coins)/1000));
        } else{
            System.out.println("Dinheiro insuficiente.");
        }
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    
}
