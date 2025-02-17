package erp;

import erp.factories.AnimalFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConcreteAnimalFactoryTests {

    @Autowired
    private AnimalFactory animalFactory;

    @Test
    @DisplayName("Create tiger with animal factory Test")
    public void createTigerAnimalFactoryTest() {
        var tiger = animalFactory.createAnimal("TiGeR", "Alex", 1, 1, 1, 1);

        Assertions.assertNotNull(tiger);
        Assertions.assertEquals(1, tiger.getFood());
        Assertions.assertEquals(-1, tiger.getNumber());
        Assertions.assertEquals("Alex", tiger.getName());
        Assertions.assertEquals(1, tiger.getAge());
    }

    @Test
    @DisplayName("Create wolf with animal factory Test")
    public void createWolfAnimalFactoryTest() {
        var tiger = animalFactory.createAnimal("wolf", "Alex", 1, 1, 1, 1);

        Assertions.assertNotNull(tiger);
        Assertions.assertEquals(1, tiger.getFood());
        Assertions.assertEquals(-1, tiger.getNumber());
        Assertions.assertEquals("Alex", tiger.getName());
        Assertions.assertEquals(1, tiger.getAge());
    }

    @Test
    @DisplayName("Create monkey with animal factory Test")
    public void createMonkeyAnimalFactoryTest() {
        var tiger = animalFactory.createAnimal("moNkey", "Alex", 1, 1, 1, 1);

        Assertions.assertNotNull(tiger);
        Assertions.assertEquals(1, tiger.getFood());
        Assertions.assertEquals(-1, tiger.getNumber());
        Assertions.assertEquals("Alex", tiger.getName());
        Assertions.assertEquals(1, tiger.getAge());
    }

    @Test
    @DisplayName("Create monkey with animal factory Test")
    public void createRabbitAnimalFactoryTest() {
        var tiger = animalFactory.createAnimal("rabbit", "Alex", 1, 1, 1, 1);

        Assertions.assertNotNull(tiger);
        Assertions.assertEquals(1, tiger.getFood());
        Assertions.assertEquals(-1, tiger.getNumber());
        Assertions.assertEquals("Alex", tiger.getName());
        Assertions.assertEquals(1, tiger.getAge());
    }

    @Test
    @DisplayName("Create not existing animal with animal factory Test")
    public void createNotExistingAnimalAnimalFactoryTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> animalFactory.createAnimal("crow", "Alex", 1, 1, 1, 1));

        Assertions.assertEquals("No enum constant erp.Enums.Animals.CROW", exception.getMessage());
    }
}
