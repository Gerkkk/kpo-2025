package erp;

import erp.domains.Animals.Wolf;
import erp.domains.Services.CommandParser;
import erp.domains.Things.Computer;
import erp.domains.Things.Table;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import erp.domains.Services.Zoo;
import erp.factories.AnimalFactory;
import erp.factories.ThingFactory;

import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class ConsoleAppTests {
    @BeforeAll
    static void setUp() {
        Mockito.when(mockZoo.getAnimals()).thenReturn("");
        Mockito.when(mockZoo.getAnimalsForContactZoo()).thenReturn("");
        Mockito.when(mockZoo.getInventory()).thenReturn("");
        Mockito.when(mockZoo.getThings()).thenReturn("");

        Mockito.when(mockThingFactory.createThing("Lol")).thenThrow(new IllegalArgumentException("message"));
        Mockito.when(mockThingFactory.createThing("Computer")).thenReturn(new Computer());
        Mockito.when(mockThingFactory.createThing("Table")).thenReturn(new Table());
        Mockito.when(mockAnimalFactory.createAnimal("Wolf", "Rex", 1, 1, 1, 1)).thenReturn(new Wolf("Rex", 1, 1, 1, 1));

        Mockito.when(mockZoo.addThing(Mockito.any())).thenReturn(false);
    }

    static Zoo mockZoo = mock(Zoo.class);
    static AnimalFactory mockAnimalFactory = mock(AnimalFactory.class);
    static ThingFactory mockThingFactory = mock(ThingFactory.class);

    CommandParser parser = new CommandParser(mockZoo, mockAnimalFactory, mockThingFactory);


    @Test
    @DisplayName("Parse help command test")
    public void parseHelpTest() {
        String[] args = {"help"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Available commands: \n" +
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
                "stop - shutdown the app. \n", ret);
    }

    @Test
    @DisplayName("Parse count-animals command test")
    public void parseCountAnimalsTest() {
        String[] args = {"count-animals"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Total animals count: 0", ret);
    }

    @Test
    @DisplayName("Parse count-things command test")
    public void parseCountThingsTest() {
        String[] args = {"count-things"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Total things count: 0", ret);
    }

    @Test
    @DisplayName("Parse count-inventory command test")
    public void parseCountInventoryTest() {
        String[] args = {"count-inventory"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Total inventory count: 0", ret);
    }

    @Test
    @DisplayName("Parse stop command test")
    public void parseStopTest() {
        String[] args = {"stop"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("exit", ret);
    }

    @Test
    @DisplayName("Parse unknown command test")
    public void parseUnknownCommandTest() {
        String[] args = {"lol"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Unknown command", ret);
    }

    @Test
    @DisplayName("Parse empty command test")
    public void parseEmptyCommandTest() {
        String[] args = {};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("", ret);
    }

    @Test
    @DisplayName("Parse count-food command test")
    public void parseCountFoodCommandTest() {
        String[] args = {"count-food"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Total quantity of food(kg): 0", ret);
    }

    @Test
    @DisplayName("Parse list-animals command test")
    public void parseListAnimalsCommandTest() {
        String[] args = {"list-animals"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("List of animals in zoo:\n", ret);
    }

    @Test
    @DisplayName("Parse list-things command test")
    public void parseListThingsCommandTest() {
        String[] args = {"list-things"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("List of things in zoo:\n", ret);
    }

    @Test
    @DisplayName("Parse inventory command test")
    public void parseInventoryCommandTest() {
        String[] args = {"inventory"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Inventory:\n", ret);
    }

    @Test
    @DisplayName("Parse list-contact-zoo command test")
    public void parseListContactZooCommandTest() {
        String[] args = {"list-contact-zoo"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("List of animals for contact zoo:\n", ret);
    }

    @Test
    @DisplayName("Parse add-thing unsuccessful command test")
    public void parseAddThingUnsuccessfulCommandTest() {
        String[] args = {"add-thing", "Computer"};

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Could not add thing Computer", ret);
    }

    @Test
    @DisplayName("Parse add-thing successful command test")
    public void parseAddThingSuccessfulCommandTest() {
        String[] args = {"add-thing", "Table"};
        Mockito.when(mockZoo.addThing(Mockito.any())).thenReturn(true);

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Successfully added thing Table", ret);
    }

    @Test
    @DisplayName("Parse add-thing error command test")
    public void parseAddThingErrorCommandTest() {
        String[] args = {"add-thing", "Table"};
        Mockito.when(mockZoo.addThing(Mockito.any())).thenThrow(new IllegalArgumentException("message"));

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Could not create a thing of type Table", ret);
    }

    @Test
    @DisplayName("Parse add-animal unsuccessful command test")
    public void parseAddAnimalUnsuccessfulCommandTest() {
        String[] args = {"add-animal", "Wolf", "Rex", "1", "1", "1", "1"};

        Mockito.when(mockZoo.addAnimal(Mockito.any())).thenReturn(false);

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Animal Wolf was found unhealthy", ret);
    }

    @Test
    @DisplayName("Parse add-animal successful command test")
    public void parseAddAnimalSuccessfulCommandTest() {
        String[] args = {"add-animal", "Wolf", "Rex", "1", "1", "1", "1"};
        Mockito.when(mockZoo.addAnimal(Mockito.any())).thenReturn(true);

        var ret = parser.parseCommandLine(args);

        Assertions.assertEquals("Successfully added animal Wolf", ret);
    }
}
