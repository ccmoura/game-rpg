/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import Itens.Item;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import Personagens.Utilitarios.Status;
import Itens.Wallet;

/**
 *
 * @author chris
 */
public class Heroi extends Personagem {
    private HashMap<String, Item> inventory;
    private int weightLimit;
    private Wallet wallet;
    private Status status;
    
    public Heroi(String nome, int energia, int d) {
        super(nome, energia, d);
        inventory = new HashMap<String, Item>();
        weightLimit = 23;
        wallet = new Wallet();
        inventory.remove(wallet);
        wallet = wallet.addCoins(500, weightLimit, wallet);
        if(wallet.getWeight() <= weightLimit - pesoAtual()){
            inventory.put(wallet.getName(), wallet);
        }
        status = new Status(super.getMaxEnergy(), super.getEnergy(), inventory, getBaseDamage());
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public Wallet getWallet() {
        return wallet;
    }
    
    public void colectCoins(int moedas){
        inventory.remove(wallet);
        inventory.put("Coins", wallet.addCoins(moedas, weightLimit, wallet));
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
    
    public boolean pay(int price){
        int original = wallet.getCoins();
        wallet.setCoins((wallet.getCoins()-price>=0) ? wallet.getCoins()-price : wallet.getCoins());
        if(original == wallet.getCoins()) return false;
        return true;
    }
    
    public boolean inserir(Item item){
        if(item.getWeight() <= weightLimit - pesoAtual()){
            if(item.getName().equals("Coins")){
                wallet = wallet.addCoins(((Wallet)item).getCoins(), weightLimit, wallet);
                inventory.remove(wallet);
                inventory.put("Coins", wallet);
                return true;
            }
            inventory.put(item.getName(), item);
            status = new Status(super.getMaxEnergy(), super.getEnergy(), inventory, getBaseDamage());
            return true;
        }
        return false;
    }
    
    public Item remover(String nome){
        if(inventory.get(nome) instanceof Wallet){
        Wallet x = new Wallet();
            x.setCoins(wallet.getCoins());
            x.setWeight(wallet.getWeight());
            inventory.remove(nome);
            wallet.setCoins(0);
            return x;
        }
        return inventory.remove(nome);
    }
    
    public void fight(Vilao v){
        Random rand = new Random();
        while((v.getEnergy() != 0) && getEnergy()!=0){
            if(v instanceof Chefe){
                // vs chefe
                if((rand.nextInt(9)%2) == 0){
                    v.decreaseEnergy(calculateDamage(status, ((Chefe) v).status));
                    // quebra itens
                    for(Item i : ((Chefe) v).getInventory().values()){
                        if(!(i instanceof Wallet)){
                            i.decreaseDurability();
                            ((Chefe) v).broke(i);
                        }
                    }
                    // add no vilao os stats alterados
                    ((Chefe) v).status = new Status(v.getMaxEnergy(), v.getEnergy(), ((Chefe) v).dropItens(), v.getBaseDamage());
                } else{
                    decreaseEnergy(calculateDamage(((Chefe) v).status, status));
                    // quebra itens
                    for(Item i : inventory.values()){
                        if(!(i instanceof Wallet)){
                            i.decreaseDurability();
                            broke(i);
                        }
                    }
                    // add no heroi os stats alterados
                    status = new Status(getMaxEnergy(), getEnergy(), inventory, getBaseDamage());
                }
            } else{
                // vs vilao normal
                if((rand.nextInt(9)%2) == 0){
                    v.decreaseEnergy((int) (getBaseDamage()*status.getDamageMultiplier()));
                } else{
                    decreaseEnergy(v.getBaseDamage());
                    // quebra itens
                    for(Item i : inventory.values()){
                        if(!(i instanceof Wallet)){
                            i.decreaseDurability();
                            broke(i);
                        }
                    }
                    // add no heroi os stats alterados
                    status = new Status(getMaxEnergy(), getEnergy(), inventory, getBaseDamage());
                }
            }
        }
    }
    
    private int calculateDamage(Status winner, Status loser){
        Random rand = new Random();
        if(winner.isHitKillChance()){
            if(rand.nextInt(100) < ((winner.isAdditionalLuck() ? 9 : 5))){  // % hit kill
                return loser.getCurrentEnergy();
            }
        }
        int damage = (int)((winner.getDamage()*winner.getDamageMultiplier())*
                (((rand.nextInt(99))) <= winner.getCriticalChance() ? 2 : 1));
        int armor = loser.getArmor();
        if((armor + loser.getCurrentEnergy())<= damage){
            return damage;
        } else{
            return damage-armor;
        }
    }

    public void setInventory(HashMap<String, Item> inventory) {
        this.inventory = inventory;
    }
    
    public int pesoAtual() {
        int peso = 0;
        for(Item i : inventory.values()){
            peso += i.getWeight();
        }
        return peso;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }
    
    void broke(Item i) {
        inventory.put(i.getName(), i);
    }
}
