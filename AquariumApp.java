import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AquariumApp{


    public static void main(String[] args) throws InvalidCreatureException{

        SeaCreature[] tank = new SeaCreature[8];

        // Two starter creatures.
        tank[0] = new Fish("Nemo", 4, 3, 1, "><>");
        tank[1] = new Fish("Dory", 30, 2, -1, "><((('>");
        tank[2] = new Shark("Bear", 10, 2, 1,")<%>^(')>");
        tank[3] = new Crab("Fin", 20, 1, -1, "„(^^),");
        tank[4] = new Fish("Dylan", 3, 0, 1, ";<%%%%%%%%!*>");

        //Invalid Creatures
        tank[5] = new Fish("mo", 4, -33, 1, "><>");
        tank[6] = new Fish("emo", 100, 3, 1, "><>");
        tank[7] = new Fish("N", 4, 3, 10, "><>");


        // =====================================================
        // STUDENT TODO
        // =====================================================
        // 1. Create at least TWO additional SeaCreature subclasses.
        // 2. Add objects from those subclasses to this array.
        // 3. Make their movement behavior meaningfully different.
        //
        // Example once you create the class:
        // tank[2] = new Shark(...);
        // tank[3] = new Turtle(...);


        Aquarium aquarium = new Aquarium(tank);
        Scanner input = new Scanner(System.in);


        boolean running = true;


        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");


        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();


            switch (choice) {
                case "1":
                    aquarium.display();
                    break;


                case "2":
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;


                case "3":
                    aquarium.listCreatureDetails();
                    break;
                   
                case "4":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;


                default:
                    System.out.println("Please choose 1, 2, 3, or 4.");
            }
        }


        input.close();
    }


    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. View Creature Details");
        System.out.println("4. Quit");
    }


    private static void readFile(SeaCreature[] tank) {


    try {
        Scanner file = new Scanner(new File("Creature.txt"));


        int index = 0;


        while (file.hasNextLine() && index < tank.length) {


            String line = file.nextLine().trim();


            if (line.isEmpty()) {
                continue;
            }


            String[] parts = line.split(",", 6);


            if (parts.length != 6) {
                continue;
            }


            try {
                String type = parts[0].trim();
                String name = parts[1].trim();
                int position = Integer.parseInt(parts[2].trim());
                int speed = Integer.parseInt(parts[3].trim());
                int direction = Integer.parseInt(parts[4].trim());
                String symbol = parts[5].trim();


                if (type.equalsIgnoreCase("Fish")) {


                    tank[index] = new Fish(
                            name, position, speed, direction, symbol
                    );


                } else if (type.equalsIgnoreCase("Shark")) {


                    tank[index] = new Shark(
                            name, position, speed, direction, symbol
                    );


                } else if (type.equalsIgnoreCase("Crab")) {


                    tank[index] = new Crab(
                            name, position, speed, direction, symbol
                    );


                } else if (type.equalsIgnoreCase("Pufferfish")) {


                    tank[index] = new Pufferfish(
                            name, position, speed, direction, symbol
                    );


                } else {
                    continue;
                }


                index++;


            } catch (NumberFormatException | InvalidCreatureException e) {
                System.out.println("Error creating creature in line " + line);
            }
        }


        file.close();


    } catch (FileNotFoundException e) {
        System.out.println("Creature.txt not found.");
    }
}
}



