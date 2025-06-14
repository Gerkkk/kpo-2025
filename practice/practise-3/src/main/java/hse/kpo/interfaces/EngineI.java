package hse.kpo.interfaces;


import hse.kpo.Enums.Types;
import hse.kpo.domains.Customers.Customer;
import lombok.Getter;

/**
 * Интерфейс двигателя.
 */
public interface EngineI {

    /**
     * Метод для проверки совместимости двигателя с покупателем.
     *
     * @param customer - покупатель, с которым мы сравниваем двигатель
     * @return true, если двигатель подходит покупателю
     */
    boolean isCompatible(Customer customer, Types type);

}
