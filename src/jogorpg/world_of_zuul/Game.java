package jogorpg.world_of_zuul;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Heroi heroi = new Heroi("Anonimo", (byte)2500);
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room alfredo, pisca, chrisao, churros, canidia, passarela, posto, beijinho, 
                viaduto, praca, avenida, gauchao, porta;
      
        // create the rooms
        alfredo = new Room("na entrada da escola Alfredo Ferreira Rodrigues");
        pisca = new Room("no campo do piscabol");
        chrisao = new Room("na casa do Chrisão");
        churros = new Room("no churros do Maicon");
        canidia = new Room("no campo do Canidia");
        passarela = new Room("na passarela");   // vazia / passagem
        posto = new Room("no posto Sim");
        beijinho = new Room("na casa do beijinho");
        viaduto = new Room("Embaixo do viaduto");   // passagem
        praca = new Room("na praça Coronel Marcelino");
        avenida = new Room("na Avenida da Paz");
        gauchao = new Room("no Gauchão Acessórios");
        porta = new Room("em frente a uma porta misteriosa");
        
        // initialise room exits
        alfredo.setExit("praca", praca);
        alfredo.setExit("viaduto", viaduto);
        alfredo.setExit("pisca", pisca);

        pisca.setExit("passarela", passarela);
        pisca.setExit("chrisao", chrisao);
        pisca.setExit("beijinho", beijinho);
        pisca.setExit("alfredo", alfredo);
        pisca.setExit("canidia", canidia);

        chrisao.setExit("passarela", passarela);
        chrisao.setExit("pisca", pisca);
        chrisao.setExit("beijinho", beijinho);
        
        churros.setExit("gauchao", gauchao);
        churros.setExit("viaduto", viaduto);
        churros.setExit("avenida", avenida);
        churros.setExit("posto", posto);
        
        beijinho.setExit("chrisao", chrisao);
        beijinho.setExit("passarela", passarela);
        beijinho.setExit("pisca", pisca);
        
        passarela.setExit("beijinho", beijinho);
        passarela.setExit("avenida", avenida);
        passarela.setExit("gauchao", gauchao);
        passarela.setExit("chrisao", chrisao);
        
        gauchao.setExit("churros", churros);
        gauchao.setExit("porta", porta);
        gauchao.setExit("avenida", avenida);
        gauchao.setExit("passarela", passarela);
        
        viaduto.setExit("churros", churros);
        viaduto.setExit("posto", posto);
        viaduto.setExit("alfredo", alfredo);
        
        avenida.setExit("gauchao", gauchao);
        avenida.setExit("churros", churros);
        
        canidia.setExit("praca", praca);
        canidia.setExit("pisca", pisca);
        
        porta.setExit("gauchao", gauchao);
        
        praca.setExit("alfredo", praca);
        praca.setExit("canidia", canidia);
        
        posto.setExit("churros", churros);
        posto.setExit("viaduto", viaduto);
        
        
        // add characters in each room
        posto.setCharacter("Aldenei", new Chefe("Aldenei", (byte)3200, 450));
        posto.setCharacter("Frentista", new Vilao("Gasoline man", (byte)1005, 3000));
                
        // add items in each room
        
        
        // start game
        currentRoom = alfredo;  
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Até a próxima!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Bem-Vindo ao Povo Novo, " + heroi.getName() + "!");
        System.out.println("Derrote todos os inimigos que puder.");
        System.out.println("Digite '" + CommandWord.HELP + "' para ajuda.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Comando inválido...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }else if (commandWord == CommandWord.ATTACK) {
            attack(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Você acordou nas margens da br 392 próximo a escola Alfredo Ferreira Rodrigues");
        System.out.println("Você não se lembra de como foi parar ai e nem conhece o local.");
        System.out.println();
        System.out.println("Comandos:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Comando inválido?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private void attack(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Atacar quem?");
            return;
        }
        
        String who = command.getSecondWord();
        Vilao vilao = (Vilao) currentRoom.getCharacters().get(who);
        if(vilao != null){
            heroi.fight(vilao);
            if(vilao.getEnergy() == 0){
                currentRoom.removeCharacter(vilao);
            }
        }
    }
    
    private void pick(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Pegar o que?");
            return;
        }
        String what = command.getSecondWord();
        currentRoom.removeItem(what);
    }
    
    private void drop(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Soltar o que?");
            return;
        }
        String what = command.getSecondWord();
        currentRoom.addItem(heroi.remover(what));
    }
}
