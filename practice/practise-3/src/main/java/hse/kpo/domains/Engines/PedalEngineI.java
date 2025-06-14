package hse.kpo.domains.Engines;

import hse.kpo.Enums.Types;
import hse.kpo.domains.AbstractEngine;
import hse.kpo.domains.Customers.Customer;
import hse.kpo.interfaces.EngineI;
import lombok.Getter;
import lombok.ToString;

/**
 * Класс педального двигателя.
 */
@ToString
@Getter
public class PedalEngineI extends AbstractEngine {
    private final int size;

    /**
     * Метод, проверяющий, подходит ли педальный двигатель пользователю.
     *
     * @param customer - покупатель, с которым мы сравниваем двигатель
     * @return true, если педальный двигатель подходит покупателю
     */
    @Override
    public boolean isCompatible(Customer customer, Types type) {
        return customer.getLegPower() > 5;
    }

    /**
     * Конструктор педального двигателя.
     *
     * @param size - размер двигателя
     */
    public PedalEngineI(int size) {
        this.size = size;
    }
}

