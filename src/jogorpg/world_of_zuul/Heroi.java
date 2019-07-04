/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.world_of_zuul;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author chris
 */
public class Heroi extends Personagem {
    private Map<String, Item> inventory;
    private int weightLimit;
    private Wallet wallet;
    private Status status;
    
    public Heroi(String nome, byte energia) {
        super(nome, energia);
        inventory = new HashMap<String, Item>();
        weightLimit = 30;
        wallet = new Wallet();
        inventory.put("Wallet", wallet);
        status = new Status(super.getMaxEnergy(), super.getEnergy(), inventory);
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
        Random rand = new Random();
        while(v.getEnergy() > 0){
            if(v instanceof Chefe){
                // vs chefe
                if((rand.nextInt(9)%2) == 0){
                    v.decreaseEnergy(calculateDamage(status, ((Chefe) v).status));
                    // quebra itens
                    
                    // add no vilao os stats alterados
                    ((Chefe) v).status = new Status(v.getMaxEnergy(), v.getEnergy(), ((Chefe) v).dropItens());
                } else{
                    decreaseEnergy(calculateDamage(((Chefe) v).status, status));
                    // quebra itens
                    
                    // add no heroi os stats alterados
                    status = new Status(getMaxEnergy(), getEnergy(), ((Chefe) v).dropItens());
                }
            } else{
                // vs vilao normal
                // quebra itens
                // add no heroi os stats alterados
            }
        }
    }
    
    private int calculateDamage(Status winner, Status loser){
        Random rand = new Random();
        if(winner.isHitKillChance()){
            if(rand.nextInt(100) < (winner.isAdditionalLuck() ? 9 : 5)){  // % hit kill
                return Integer.MAX_VALUE;
            }
        }
        int damage = (int)((winner.getDamage()*winner.getDamageMultiplier())*((rand.nextInt((int) winner.getCriticalChance())/100)+1));
        int armor = loser.getArmor();
        if((armor + loser.getCurrentEnergy())<= damage){
            return damage;
        } else{
            return damage-armor;
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
