package erp.domains.AbstractClasses;

/**
 * Абстрактный класс травоядного животного.
 */
public abstract class Herbo extends Animal {
    private int kindness;

    /**
     * Конструктор травоядного животного.
     * @param name - имя
     * @param age - возраст
     * @param food - потребляемое количество еды(кг)
     * @param kindness - доброта
     */
    public Herbo(String name, int age, int food, int kindness) {
        super(name, age, food);
        this.kindness = kindness;
    }

    /**
     * Метод возвращающий доброту животного
     * @return доброта животного
     */
    public int getKindness() {
        return kindness;
    }

    /**
     * Метод устанавливающий доброту животного
     * @param kindness новая доброта животного
     */
    public void setKindness(int kindness) {
        this.kindness = kindness;
    }
}
