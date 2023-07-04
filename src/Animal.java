import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Animal {

    private String name;
    private String command;

    public Animal(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void displayCommands() {
        System.out.println("List of commands: " + command);
    }
}

class Cat extends Animal {
    public Cat(String name, String command) {
        super(name, command);
    }
}

class Dog extends Animal {
    public Dog(String name, String command) {
        super(name, command);
    }
}

class Hamster extends Animal {
    public Hamster(String name, String command) {
        super(name, command);
    }
}

class AnimalRegistry implements AutoCloseable {
    private List<Animal> animals;
    private Count counter;

    public AnimalRegistry() {
        animals = new ArrayList<>();
        counter = new Count();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        counter.add();
    }

    public void printAnimalCommands() {
        for (Animal animal : animals) {
            System.out.println("Animal: " + animal.getName());
            animal.displayCommands();
        }
    }

    public void teachAnimalCommand(String animalName, String newCommand) {
        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                animal.setCommand(newCommand);
                System.out.println("Command added successfully!");
                return;
            }
        }
        System.out.println("Animal not found!");
    }

    @Override
    public void close() throws Exception {
        if (counter.getCount() > 0) {
            throw new IllegalStateException("Resource not properly closed!");
        }
    }
}

class Count implements AutoCloseable {
    private int count;

    public Count() {
        count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        count--;
    }
}

