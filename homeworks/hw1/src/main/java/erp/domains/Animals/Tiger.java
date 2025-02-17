package erp.domains.Animals;

import erp.domains.AbstractClasses.Predator;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс Тигра.
 */
@Setter
@Getter
public class Tiger extends Predator {
    private int fangLength;

    /**
     * Конструктор класса тигра.
     * @param name - имя
     * @param age - возраст
     * @param food - потребляемое количество еды (кг)
     * @param aggression - параметры агрессии
     * @param fangLength - длина клыков
     */
    public Tiger(String name, int age, int food, int aggression, int fangLength) {
        super(name, age, food, aggression);
        this.fangLength = fangLength;
    }
}
