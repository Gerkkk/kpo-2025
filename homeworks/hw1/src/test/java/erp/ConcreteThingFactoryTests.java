package erp;

import erp.domains.Things.Computer;
import erp.domains.Things.Table;
import erp.factories.ConcreteThingFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConcreteThingFactoryTests {

    @Autowired
    private ConcreteThingFactory concreteThingFactory;

    @Test
    @DisplayName("Create Thing Table Test")
    public void createThingTableTest() {
        var res = concreteThingFactory.createThing("cOmPuTeR");

        Assertions.assertNotNull(res);
        Assertions.assertEquals(Computer.class, res.getClass());
        Assertions.assertEquals(-1, res.getNumber());
    }

    @Test
    @DisplayName("Create Thing Computer Test")
    public void createThingComputerTest() {
        var res = concreteThingFactory.createThing("TaBlE");

        Assertions.assertNotNull(res);
        Assertions.assertEquals(Table.class, res.getClass());
        Assertions.assertEquals(-1, res.getNumber());
    }

    @Test
    @DisplayName("Create Thing Chair Test")
    public void createThingChairTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> concreteThingFactory.createThing("chair"));
        Assertions.assertEquals("No enum constant erp.Enums.Things.CHAIR", exception.getMessage());
    }
}
