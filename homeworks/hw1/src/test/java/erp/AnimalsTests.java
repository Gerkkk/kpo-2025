package erp;

import erp.domains.Animals.Monkey;
import erp.domains.Animals.Rabbit;
import erp.domains.Animals.Wolf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnimalsTests {
    @Test
    @DisplayName("Monkey test")
    public void getSetKindnessMonkeyTest() {
        Monkey wolf = new Monkey("Rex", 2, 10, 7, 20);
        wolf.setKindness(1);

        Assertions.assertEquals(1, wolf.getKindness());
    }

    @Test
    @DisplayName("Wolf test")
    public void getSetAggressionWolfTest() {
        Wolf wolf = new Wolf("Rex", 2, 10, 7, 20);
        wolf.setAggression(1);

        Assertions.assertEquals(1, wolf.getAggression());
    }

    @Test
    @DisplayName("Rabbit test")
    public void getSetKindnessRabbitTest() {
        Rabbit wolf = new Rabbit("Rex", 2, 10, 7, 20);
        wolf.setKindness(10);

        Assertions.assertEquals(10, wolf.getKindness());
    }
}
