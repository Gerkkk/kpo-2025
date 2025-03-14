package hse.kpo;

import hse.kpo.factories.Cars.PedalCarFactoryI;
import hse.kpo.domains.params.PedalEngineParams;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Класс, тестирующий класс PedalCarFactory.
 */
@SpringBootTest
public class PedalCarFactoryTests {
    @Autowired private PedalCarFactoryI fact;

    /**
     * Метод, тестирующий метод createCar класса PedalCarFactory.
     */
    @Test
    @DisplayName("Test of Pedal Factory Class testCreatePedalCar")
    public void testCreatePedalCar() {
        final var carNumber = 100;
        final var engParams = new PedalEngineParams(4);

        var handCar = fact.createCar(engParams, carNumber);

        Assertions.assertNotNull(handCar);
        Assertions.assertEquals(carNumber, handCar.getVin());
    }
}
