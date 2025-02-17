package erp.domains.Animals;

import erp.domains.AbstractClasses.Omnivore;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс обезьяны.
 */
@Setter
@Getter
public class Monkey extends Omnivore {
    private int weight;

    /**
     * Конструктор класса обезьяны.
     * @param name - имя
     * @param age - возраст
     * @param food - потребляемое количество еды (кг)
     * @param kindness - параметры доброты
     * @param weight - вес обезьяны
     */
    public Monkey(String name, int age, int food, int kindness, int weight) {
        super(name, age, food, kindness);
        this.weight = weight;
    }
}
