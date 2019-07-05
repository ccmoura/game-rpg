/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personagens;

import java.util.HashMap;

/**
 *
 * @author chris
 */
public class NPC {
    private String name;
    private String dialog;

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

    public NPC(String name, String dialog) {
        this.name = name;
        this.dialog = dialog;
    }
}
