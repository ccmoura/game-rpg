package jogorpg.world_of_zuul;

import Personagens.Personagem;
import Itens.Item;
import Personagens.NPC;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Personagem> characters;
    private HashMap<String, Item> itens;
    private HashMap<String, NPC> npcs;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    
    public void setCharacter(String name, Personagem p){
        characters.put(name, p);
    }
    public void setNPC(String name, NPC p){
        npcs.put(name, p);
    }
    public HashMap<String, Personagem> getCharacters() 
    {
        return characters;
    }

    public void addItem(Item i){
        itens.put(i.getName(), i);
    }
    
    public Item removeItem(String nome){
        return itens.remove(nome);
    }
    
    public void removeCharacter(String p){
        characters.remove(p);
    }
    
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
        characters = new HashMap<String, Personagem>();
        itens = new HashMap<String, Item>();
        npcs = new HashMap<String, NPC>();
    }

    public HashMap<String, NPC> getNPCS(){
        return npcs;
    }
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "Você está " + description + "\n" + getItensString() + ".\n" + getExitString() + "\n" + getCharactersString() + getNPCSString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Saídas:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    private String getCharactersString(){
        String returnString = "Personagens: ";
        Set<String> keys = characters.keySet();
        for(String character : keys) {
            returnString += " _ " + character;
        }
        return returnString;
    }
    private String getNPCSString(){
        String returnString = "";
        Set<String> keys = npcs.keySet();
        for(String npc : keys) {
            returnString += " _ " + npc;
        }
        return returnString;
    }
    
    private String getItensString(){
        String returnString = "Itens: ";
        Set<String> keys = itens.keySet();
        for(String item : keys) {
            returnString += "[" + item + "] ";
        }
        return returnString;
    }
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

