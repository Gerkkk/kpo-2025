package erp.domains.AbstractClasses;

import erp.interfaces.IAlive;
import erp.interfaces.IInventory;
import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактный класс животного.
 */
public abstract class Animal implements IAlive, IInventory {
    @Getter
    private String name;
    @Setter
    @Getter
    private int age;
    private int food;
    private int number = -1;

    /**
     * Конструктор класса животное.
     * @param name - имя животного
     * @param age - возраст животного в годах
     * @param food - потребляемое животным количество еды
     */
    public Animal(String name, int age, int food) {
        this.name = name;
        this.age = age;
        this.setFood(food);
    }

    /**
     * Метод возвращающий потребляемое животным количество еды.
     * @return - потребляемое животным количество еды в килограммах
     */
    @Override
    public int getFood() {
        return food;
    }

    /**
     * Метод устанавливающий потребляемое животным количество еды.
     * @param food - новое количество еды, потребляемое животным
     */
    @Override
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Метод возвращающий номер животного.
     * @return - номер животного
     */
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * Метод, устанавливающий номер животного.
     * @param number - новый номер животного
     */
    @Override
    public void setNumber(int number) {
        this.number = number;
    }
}
