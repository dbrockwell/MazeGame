package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Player personPlaying = new Player();

        System.out.println("""
                You are in search of a cave full of gems and other worldly power.
                You have located the enterance to the cave and you enter.
                Unfortunatly, as you enter the cave enterance behind you collasps and you loose your pickaxe under the rubble""");

        System.out.println("The controls are f: to go further, b: to go back, i: for interact, l: for loot, e: for exit cave, v: for inventory");

        Room introRoom = new Room("Intro Room", "This is the starting room");
        introRoom.setExit("You can exit the Maze");

        Room gemRoom = new Room("Gem Room", "This room is full of shiny gems");
        gemRoom.setInteract("You have obtained a gem");
        gemRoom.setLoot("You have found a flask");

        Room trappedManRoom = new Room("Room with Trap", "This room has a man who is trapped");
        trappedManRoom.setInteract("You Talk to the man");

        Room darkRoom = new Room("Dark Room", "This room is dark with a small sculpture");
        darkRoom.setLoot("You picked up the small sculpture");

        introRoom.setFurther(gemRoom);
        gemRoom.setFurther(trappedManRoom);
        gemRoom.setBack(introRoom);
        trappedManRoom.setFurther(darkRoom);
        trappedManRoom.setBack(gemRoom);
        darkRoom.setBack(trappedManRoom);

        Maze maze = new Maze(personPlaying);
        maze.setCurrentRoom(introRoom);

        do {
            System.out.println("\n-----------------------------------------------------\n");
            System.out.println("Room: " + maze.getCurrentRoom().getName());
            System.out.println("Description: " + maze.getCurrentRoom().getDescription());
            System.out.print("Enter Option: ");
            char option = keyboard.nextLine().toLowerCase().charAt(0);
            if (option == 'f' || option == 'b'){
                if (!maze.Move(option)) {
                    System.out.println("You can not exit the room in that direction");
                }
            }
            else if (option == 'i'){
                System.out.println(maze.InteractCurrentRoom());
            }
            else if (option == 'l'){
                String name = null;
                if (maze.getCurrentRoom() == gemRoom) {
                    Flask flask = Flask.getInstance();
                    name = flask.getFlask();
                }
                System.out.println(maze.LootCurrentRoom(name));
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
