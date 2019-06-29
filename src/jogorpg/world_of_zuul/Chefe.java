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
public class Chefe extends Vilao{
    private Map<String, Item> inventory;
    private int weightLimit;
    
    public Chefe(String nome, byte energia, int coins) {
        super(nome, energia, coins);
        inventory = new HashMap<String, Item>();
        weightLimit = 18;
    }
    
    public Map<String, Item> dropItens(){
        return inventory;
    }

    public int getWeightLimit() {
        return weightLimit;
    }
    
    
}
