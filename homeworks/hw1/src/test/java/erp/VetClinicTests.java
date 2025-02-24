package erp;

import erp.domains.Animals.Monkey;
import erp.domains.Animals.Rabbit;
import erp.domains.Animals.Tiger;
import erp.domains.Animals.Wolf;
import erp.domains.Services.VetClinic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class VetClinicTests {

    @Test
    @DisplayName("Vet Clinic healthy wolf test")
    public void isHealthyWolfTest() {
        VetClinic vetClinic = new VetClinic();
        Wolf wolf = new Wolf("Rex", 2, 10, 7, 50);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertTrue(res);
    }

    @Test
    @DisplayName("Vet Clinic unhealthy wolf test")
    public void isHealthyBadWolfTest() {
        VetClinic vetClinic = new VetClinic();
        Wolf wolf = new Wolf("Rex", 2, 10, 7, 10);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertFalse(res);
    }

    @Test
    @DisplayName("Vet Clinic healthy Tiger test")
    public void isHealthyTigerTest() {
        VetClinic vetClinic = new VetClinic();
        Tiger wolf = new Tiger("Rex", 2, 10, 7, 20);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertTrue(res);
    }

    @Test
    @DisplayName("Vet Clinic unhealthy Tiger test")
    public void isHealthyBadTigerTest() {
        VetClinic vetClinic = new VetClinic();
        Tiger wolf = new Tiger("Rex", 2, 10, 7, 2);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertFalse(res);
    }

    @Test
    @DisplayName("Vet Clinic healthy Rabbit test")
    public void isHealthyRabbitTest() {
        VetClinic vetClinic = new VetClinic();
        Rabbit wolf = new Rabbit("Rex", 2, 10, 7, 20);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertTrue(res);
    }

    @Test
    @DisplayName("Vet Clinic unhealthy Rabbit test")
    public void isHealthyBadRabbitTest() {
        VetClinic vetClinic = new VetClinic();
        Rabbit wolf = new Rabbit("Rex", 2, 10, 7, 2);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertFalse(res);
    }

    @Test
    @DisplayName("Vet Clinic healthy Monkey test")
    public void isHealthyMonkeyTest() {
        VetClinic vetClinic = new VetClinic();
        Monkey wolf = new Monkey("Rex", 2, 10, 7, 70);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertTrue(res);
    }

    @Test
    @DisplayName("Vet Clinic unhealthy Monkey test")
    public void isHealthyBadMonkeyTest() {
        VetClinic vetClinic = new VetClinic();
        Monkey wolf = new Monkey("Rex", 2, 10, 7, 20);

        var res = vetClinic.isHealthy(wolf);

        Assertions.assertFalse(res);
    }
}
