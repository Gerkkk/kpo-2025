package erp;

import erp.domains.Animals.Rabbit;
import erp.domains.Animals.Tiger;
import erp.domains.Animals.Wolf;
import erp.domains.Services.VetClinic;
import erp.domains.Services.Zoo;
import erp.domains.Things.Computer;
import erp.domains.Things.Table;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


@SpringBootTest
public class ZooTests {

    private static boolean initialized = false;

    @BeforeEach
    public void init() {
        if (!initialized) {
            zoo.addAnimal(new Wolf("Alex", 1, 2, 1, 50));
            zoo.addAnimal(new Rabbit("Bob", 1, 10, 10, 50));
            zoo.addThing(new Computer());
            initialized = true;
        }
    }

    @Autowired
    Zoo zoo;

    @Test
    @DisplayName("Zoo get Animal Count test")
    public void getAnimalCountTest() {
        var res = zoo.getAnimalCount();

        Assertions.assertEquals(2, res);
    }

    @Test
    @DisplayName("Zoo get Things Count test")
    public void getThingsCountTest() {
        var res = zoo.getThingsCount();

        Assertions.assertEquals(1, res);
    }

    @Test
    @DisplayName("Zoo get Inventory Count test")
    public void getInventoryCountTest() {
        var res = zoo.getInventoryCount();

        Assertions.assertEquals(3, res);
    }

    @Test
    @DisplayName("Zoo get Animals test")
    public void getAnimalsTest() {
        var res = zoo.getAnimals();

        Assertions.assertEquals("id: 1, type: Wolf, name: Alex, age: 1, food: 2\n" +
                "id: 2, type: Rabbit, name: Bob, age: 1, food: 10", res);
    }

    @Test
    @DisplayName("Zoo get Things test")
    public void getThingsTest() {
        var res = zoo.getThings();

        Assertions.assertEquals("id: 3 Computer", res);
    }

    @Test
    @DisplayName("Zoo get Inventory test")
    public void getInventoryTest() {
        var res = zoo.getInventory();

        Assertions.assertEquals("id: 1, type: Wolf, name: Alex, age: 1, food: 2\n" +
                "id: 2, type: Rabbit, name: Bob, age: 1, food: 10\n" +
                "id: 3, type: Computer", res);
    }

    @Test
    @DisplayName("Zoo get Contact zoo Animals test")
    public void getContactZooListTest() {
        var res = zoo.getAnimalsForContactZoo();

        Assertions.assertEquals("Rabbit name: Bob, age: 1, food: 10\n", res);
    }

    @Test
    @DisplayName("Zoo get Sum food test")
    public void getSumFoodTest() {
        var res = zoo.getSumFood();

        Assertions.assertEquals(12, res);
    }

    @Test
    @DisplayName("Zoo add Animal test")
    public void getAddAnimalTest() {
        var mockVetClinic = Mockito.mock(VetClinic.class);
        Mockito.when(mockVetClinic.isHealthy(any(Tiger.class))).thenReturn(true);

        Zoo anotherZoo = new Zoo(mockVetClinic);

        var res = anotherZoo.addAnimal(new Tiger("", 1, 1, 1, 100));

        Assertions.assertTrue(res);
        Assertions.assertEquals(1, anotherZoo.getSumFood());
        Assertions.assertEquals(1, anotherZoo.getAnimalCount());
    }

    @Test
    @DisplayName("Zoo add bad Animal test")
    public void getAddBadAnimalTest() {
        var mockVetClinic = Mockito.mock(VetClinic.class);
        Mockito.when(mockVetClinic.isHealthy(Tiger.class)).thenReturn(false);

        Zoo anotherZoo = new Zoo(mockVetClinic);

        var res = zoo.addAnimal(new Tiger("", 1, 1, 1, 1));

        Assertions.assertFalse(res);
        Assertions.assertEquals(0, anotherZoo.getSumFood());
        Assertions.assertEquals(0, anotherZoo.getAnimalCount());
    }

    @Test
    @DisplayName("Zoo add Thing test")
    public void getAddThingTest() {
        var mockVetClinic = Mockito.mock(VetClinic.class);
        Mockito.when(mockVetClinic.isHealthy(Tiger.class)).thenReturn(false);
        Zoo anotherZoo = new Zoo(mockVetClinic);

        var res = anotherZoo.addThing(new Computer());
        var res1 = anotherZoo.addThing(new Table());

        Assertions.assertTrue(res);
        Assertions.assertTrue(res1);
        Assertions.assertEquals(0, anotherZoo.getSumFood());
        Assertions.assertEquals(2, anotherZoo.getThingsCount());
    }
}
