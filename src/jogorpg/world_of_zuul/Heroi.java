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
    
    public Heroi(String nome, byte energia) {
        super(nome, energia);
        inventory = new HashMap<String, Item>();
        weightLimit = 30;
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
        byte villainLuck = v.luck();
        byte heroLuck = this.luck();
        
        if(villainLuck == heroLuck){
            this.decreaseEnergy();
            v.decreaseEnergy();
        } else if(villainLuck < heroLuck){
            v.decreaseEnergy();
            this.increaseEnergy();
        } else{
            v.increaseEnergy();
            this.decreaseEnergy();
        }
    }

    private int pesoAtual() {
        int peso = 0;
        for(int i = 0; i<inventory.size(); i++){
            peso += inventory.get(i).getWeight();
        }
        return peso;
    }
}
