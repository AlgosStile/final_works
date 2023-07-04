import java.util.Scanner;

public class AnimalRegistrySimulation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             AnimalRegistry registry = new AnimalRegistry()) {

            int choice = 0;

            while (choice != 6) {
                System.out.println("\nAnimal Registry");
                System.out.println("----------------");
                System.out.println("1. Add new animal");
                System.out.println("2. List animal commands");
                System.out.println("3. Teach animal a new command");
                System.out.println("4. Perform actions");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter animal name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter animal command: ");
                        String command = scanner.nextLine();

                        registry.addAnimal(new Animal(name, command));
                        System.out.println("Animal added successfully!");
                        break;

                    case 2:
                        registry.printAnimalCommands();
                        break;

                    case 3:
                        System.out.print("Enter animal name to teach: ");
                        String animalName = scanner.nextLine();
                        System.out.print("Enter new command: ");
                        String newCommand = scanner.nextLine();

                        registry.teachAnimalCommand(animalName, newCommand);
                        break;

                    case 4:
                        // Perform actions
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
