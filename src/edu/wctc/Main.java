package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Player personPlaying = new Player();
        GemFactory gemFactory = new GemFactory();

        System.out.println("""
                You are in search of a cave full of gems and other worldly power.
                You have located the entrance to the cave and you enter.
                Unfortunately, as you enter the cave entrance behind you collapsed and you loose your pickaxe under the rubble""");

        System.out.println("The controls are f: to go further, b: to go back, i: for interact, l: for loot, e: for exit cave, v: for inventory");

        Room introRoom = new Room("Intro Room", "This is the starting room");
        introRoom.setExit("You can exit the Maze", new ItemBoundStrategy(personPlaying, "Pickaxe"), "You need a pickaxe to escape the maze");

        Room gemRoom = new Room("Gem Room", "This room is full of shiny gems");
        gemRoom.setInteract("You have obtained a gem", new ItemBoundStrategy(personPlaying, "Pickaxe"), "You need a pickaxe to obtain a gem");
        gemRoom.setLoot("You have found a flask", new FreeStrategy(), "");

        Room trappedManRoom = new Room("Room with Trap", "This room has a man who is trapped");
        trappedManRoom.setInteract("You Talk to the man", new FreeStrategy(), "");

        Room darkRoom = new Room("Dark Room", "This room is dark with a small sculpture");
        darkRoom.setInteract("You pressed a button and set of a trap, and the sculpture is enclosed with bars", new FreeStrategy(), "");
        darkRoom.setLoot("You picked up the small artifact", new SituationalBoundStrategy(true), "There are bars around the artifact");

        introRoom.setFurther(gemRoom);
        gemRoom.setFurther(trappedManRoom);
        gemRoom.setBack(introRoom);
        trappedManRoom.setFurther(darkRoom);
        trappedManRoom.setBack(gemRoom);
        darkRoom.setBack(trappedManRoom);

        Maze maze = new Maze(personPlaying, gemFactory);
        maze.setCurrentRoom(introRoom);

        do {
            System.out.println("\n-----------------------------------------------------\n");
            System.out.println("Room: " + maze.getCurrentRoom().getName());
            System.out.println("Description: " + maze.getCurrentRoom().getDescription());
            System.out.println(maze.getCurrentRoom().getExits());
            System.out.print("Enter Option: ");
            String optionString = keyboard.nextLine();
            char option = 'a';
            if (optionString != "") {
                option = optionString.toLowerCase().charAt(0);
            }
            if (option == 'f' || option == 'b'){
                if (!maze.Move(option)) {
                    System.out.println("You can not exit the room in that direction");
                }
            }
            else if (option == 'i'){
                System.out.println(maze.InteractCurrentRoom());
                if (maze.getCurrentRoom() == trappedManRoom) {
                    Person person = Person.getInstance(personPlaying);
                    int promptRequest = 0;
                    int rotations = 0;
                    int size = 0;
                    do {
                        if (rotations == 0) {
                            System.out.println(person.getIntroduction());
                        }
                        if (person.getPromptList().size() != 0) {
                            System.out.println(person.showPrompt());
                            size = person.getPromptList().size() + 1;
                            try {
                                promptRequest = Integer.parseInt(keyboard.nextLine());
                                System.out.println(person.answerPrompt(promptRequest));
                            } catch (Exception ignore) {
                                promptRequest = 0;
                            }
                        }
                        rotations += 1;
                    } while ((promptRequest < size && promptRequest > 0) && person.getPromptList().size() > 0);
                }
                if (maze.getCurrentRoom() == gemRoom) {
                    if (gemRoom.isInteractObtainable()) {
                        String gem = maze.addRandomGem();
                        System.out.println(gem + " was added to inventory");
                    }
                }
            }
            else if (option == 'l'){
                String name = null;
                int score = 0;
                if (maze.getCurrentRoom() == gemRoom) {
                    Flask flask = Flask.getInstance();
                    name = flask.getFlask();
                    score = flask.getScore();
                }
                if (maze.getCurrentRoom() == darkRoom) {
                    Artifact artifact = Artifact.getInstance();
                    name = artifact.getArtifact();
                    score = artifact.getScore();
                }
                System.out.println(maze.LootCurrentRoom(name, score));
            }
            else if (option == 'e'){
                System.out.println(maze.ExitCurrentRoom());
            }
            else if (option == 'v') {
                System.out.println(personPlaying.getFormattedInventory());
            }
        }while(!maze.isFinished());
    }
}
