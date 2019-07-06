/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import Itens.Item;
import java.util.HashMap;

/**
 *
 * @author chris
 */
public class NPC {
    private String name;
    private String dialog;
    private Item item;
    private int value;

    public int getValue() {
        return value;
    }

    public Item getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialogs) {
        this.dialog = dialog;
    }

    public NPC(String name, String dialog, Item item, int value) {
        this.name = name;
        this.dialog = dialog;
        this.item = item;
        this.value = value;
    }
    
    public Item buy(){
        return item;
    }
    
    public String itemName(){
        return item.getName();
    }
}
