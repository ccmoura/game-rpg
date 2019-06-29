/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.world_of_zuul;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chris
 */
public class Heroi extends Personagem {
    private Map<String, Item> inventory;
    private int weightLimit;
    private Wallet wallet;
    
    public Heroi(String nome, byte energia) {
        super(nome, energia);
        inventory = new HashMap<String, Item>();
        weightLimit = 30;
        wallet = new Wallet();
        inventory.put("Wallet", wallet);
    }
    
    public void colectCoins(int moedas){
        wallet.addCoins(moedas, weightLimit);
    }
    
    public boolean testItem(Item item){ // false se item for da mesma instância
        String[] itmSplit = item.getName().split(" ");
        String[] invSplit;
        for(String i : inventory.keySet()){
            invSplit = i.split(" ");
            if(invSplit[0].equals(itmSplit[0])){
                return false;
            }
        }
        return true;
    }
    
    public void dropCoins(int coins){
        wallet.removeCoins(coins);
    }
    
    public boolean inserir(Item item){
        if(item.getWeight() <= weightLimit - pesoAtual()){
            inventory.put(item.getName(), item);
            return true;
        }
        return false;
    }
    
    public Item remover(String nome){
        return inventory.remove(nome);
    }
    
    public void fight(Vilao v){
        // implementar
    }

    private int pesoAtual() {
        int peso = 0;
        for(int i = 0; i<inventory.size(); i++){
            peso += inventory.get(i).getWeight();
        }
        return peso;
    }
}
