package erp.interfaces;

/**
 * Интерфейс инвентаризационной вещи.
 */
public interface IInventory {
    int number = 0;

    /**
     * Метод возвращающий номер вещи.
     * @return номер вещи
     */
    int getNumber();

    /**
     * Метод устанавливающий номер вещи
     * @param number - новый номер вещи
     */
    void setNumber(int number);
}
