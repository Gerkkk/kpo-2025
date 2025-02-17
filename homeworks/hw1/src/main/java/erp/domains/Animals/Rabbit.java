package erp.domains.Animals;

import erp.domains.AbstractClasses.Herbo;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс кролика.
 */
@Setter
@Getter
public class Rabbit extends Herbo {
    private int earLength;

    /**
     * Конструктор класса кролика.
     * @param name - имя
     * @param age - возраст
     * @param food - потребляемое количество еды (кг)
     * @param kindness - параметры доброты
     * @param earLength - длина ушей кролика
     */
    public Rabbit(String name, int age, int food, int kindness, int earLength) {
        super(name, age, food, kindness);
        this.earLength = earLength;
    }
}
