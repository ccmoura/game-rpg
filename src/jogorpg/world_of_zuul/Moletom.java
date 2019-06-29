/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.world_of_zuul;

/**
 *
 * @author chris
 */
public class Moletom extends Camisa {
    private byte life;
    
    public Moletom(String name, int weight, int armor) {
        super(name, weight, armor);
    }

    public byte getLife() {
        return life;
    }
    
}
