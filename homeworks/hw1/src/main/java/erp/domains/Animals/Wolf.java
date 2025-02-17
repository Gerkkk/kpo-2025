package erp.domains.Animals;

import erp.domains.AbstractClasses.Predator;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс волка.
 */
@Setter
@Getter
public class Wolf extends Predator {
    public int height;

    /**
     * Конструктор класса тигра.
     * @param name - имя
     * @param age - возраст
     * @param food - потребляемое количество еды (кг)
     * @param aggression - параметры агрессии
     * @param height - рост
     */
    public Wolf(String name, int age, int food, int aggression, int height) {
        super(name, age, food, aggression);
        this.height = height;
    }
}
