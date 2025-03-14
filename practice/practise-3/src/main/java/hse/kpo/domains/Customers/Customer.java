package hse.kpo.domains.Customers;

import hse.kpo.domains.Cars.Car;
import hse.kpo.domains.Ships.Ship;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Класс покупателя.
 */
@Getter
@ToString
public class Customer {
    private final String name;

    private final int legPower;

    private final int handPower;

    private final int iq;

    @Setter
    private Car car;

    @Setter
    private Ship ship;

    /**
     * Конструктор.
     *
     * @param name      - имя
     * @param legPower  - сила ног
     * @param handPower - сила рук
     * @param iq        - IQ
     */
    public Customer(String name, int legPower, int handPower, int iq) {
        this.name = name;
        this.legPower = legPower;
        this.handPower = handPower;
        this.iq = iq;
    }
}
