package erp.domains.AbstractClasses;

import erp.interfaces.IInventory;

/**
 * Абстрактный класс вещи.
 */
public abstract class Thing implements IInventory {
    private int number = -1;

    /**
     * Конструктор вещи.
     */
    public Thing() {
    }

    /**
     * Метод возвращающий номер вещи.
     * @return - номер животного
     */
    public int getNumber() {
        return number;
    }

    /**
     * Метод, устанавливающий номер вещи.
     * @param number - новый номер вещи
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
