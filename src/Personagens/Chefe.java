/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import java.util.HashMap;
import java.util.Map;
import Itens.Item;
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
    
    public Chefe(String nome, int energia, int coins, int d, Map<String, Item> i) {
        super(nome, energia, coins, d);
        inventory = i;
        weightLimit = 18;
        status = new Status(energia, energia, inventory, getBaseDamage());
    }
    
    public Map<String, Item> dropItens(){
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
}
