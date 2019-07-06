/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import java.util.HashMap;
import java.util.Map;
import Itens.Item;
import Itens.Wallet;
import Personagens.Utilitarios.Status;
import Personagens.Utilitarios.Status;
import Personagens.Vilao;

/**
 *
 * @author chris
 */
public class Chefe extends Vilao{
    private Map<String, Item> inventory;
    private int weightLimit;
    public Status status;
    private Wallet wallet;
    
    public Chefe(String nome, int energia, int coins, int damage, HashMap<String, Item> i) {
        super(nome, energia, coins, damage);
        inventory = i;
        weightLimit = 18;
        status = new Status(energia, energia, inventory, getBaseDamage());
    }

    public void setInventory(Map<String, Item> inventory) {
        this.inventory = inventory;
    }
    
    public Map<String, Item> dropItens(){
        return inventory;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public int getWeightLimit() {
        return weightLimit;
    }
    
    public void addItem(Item k){
        int peso = 0;
        for(Item x : inventory.values()){
            peso+=x.getWeight();
        }
        if(weightLimit-peso < k.getWeight()){
            inventory.put(k.getName(), k);
        }
    }

    void broke(Item i) {
        inventory.put(i.getName(), i);
    }
}
