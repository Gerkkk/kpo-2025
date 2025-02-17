package erp.domains.Services;

import erp.factories.AnimalFactory;
import erp.factories.ThingFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandParser {
    private final  Zoo moscowZoo;
    private final AnimalFactory animalFactory;
    private final ThingFactory thingFactory;

    @Autowired
    public CommandParser(Zoo zoo, AnimalFactory animalFactory, ThingFactory thingFactory) {
        this.moscowZoo = zoo;
        this.animalFactory = animalFactory;
        this.thingFactory = thingFactory;
    }

    /**
     * Метод, который парсит команды из командной строки.
     * @param args - массив команд командной строки
     * @return - ответ пользователю
     */
    public String parseCommandLine(String[] args) {
        if (args.length == 0) {
            return "";
        } else if (args[0].equals("add-animal") && args.length == 7) {
            try {
                var animal = animalFactory.createAnimal(args[1], args[2], Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]));
                if (moscowZoo.addAnimal(animal)) {
                    return "Successfully added animal " + animal.getClass().getSimpleName();
                } else {
                    return "Animal " + animal.getClass().getSimpleName() + " was found unhealthy";
                }
            } catch (NumberFormatException e) {
                return "Wrong input format";
            } catch (IllegalArgumentException e) {
                return "Could not create an animal of type " + args[1];
            }
        } else if (args[0].equals("count-food") && args.length == 1) {
            return "Total quantity of food(kg): " + moscowZoo.getSumFood();
        } else if (args[0].equals("add-thing") && args.length == 2) {
            try {
                var thing = thingFactory.createThing(args[1]);

                if (moscowZoo.addThing(thing)) {
                    return "Successfully added thing " + thing.getClass().getSimpleName();
                } else {
                    return "Could not add thing " + thing.getClass().getSimpleName();
                }
            } catch (IllegalArgumentException e) {
                return "Could not create a thing of type " + args[1];
            }
        } else if (args[0].equals("list-animals") && args.length == 1) {
            return "List of animals in zoo:\n" + moscowZoo.getAnimals();
        } else if (args[0].equals("list-things") && args.length == 1) {
            return "List of things in zoo:\n" + moscowZoo.getThings();
        } else if (args[0].equals("inventory") && args.length == 1) {
            return "Inventory:\n" + moscowZoo.getInventory();
        } else if (args[0].equals("list-contact-zoo") && args.length == 1) {
            return "List of animals for contact zoo:\n" + moscowZoo.getAnimalsForContactZoo();
        } else if (args[0].equals("help") && args.length == 1) {
            return "Available commands: \n" +
                    "add-animal - add thing with given type and properties (type, name, age, food, socialSkills, physicalParams) (example: add-animal Wolf Rex 2 10 7 50); \n" +
                    "count-food - prints total amount of food that animals need;\n" +
                    "add-thing - add thing with given type (example: add-thing Computer);\n" +
                    "list-animals - prints list of animals in the zoo;\n" +
                    "list-things - prints list of things in the zoo; \n" +
                    "inventory - prints list of inventory subjects in the zoo; \n" +
                    "list-contact-zoo - prints list of animals for contact zoo; \n" +
                    "count-animals - prints total number of animals in the zoo; \n" +
                    "count-things - prints total number of things in the zoo; \n" +
                    "count-inventory - prints total number of inventory subjects in the zoo;\n" +
                    "help - prints available commands; \n" +
                    "stop - shutdown the app. \n";
        } else if (args[0].equals("count-animals") && args.length == 1) {
            return "Total animals count: " + moscowZoo.getAnimalCount();
        } else if (args[0].equals("count-things") && args.length == 1) {
            return "Total things count: " + moscowZoo.getThingsCount();
        } else if (args[0].equals("count-inventory") && args.length == 1) {
            return "Total inventory count: " + moscowZoo.getInventoryCount();
        } else if (args[0].equals("stop") && args.length == 1) {
            return "exit";
        } else {
            return "Unknown command";
        }
    }
}
