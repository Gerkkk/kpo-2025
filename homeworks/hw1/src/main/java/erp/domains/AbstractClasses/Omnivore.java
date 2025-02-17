package erp.domains.AbstractClasses;

/**
 * Абстрактный класс всеядного животного.
 */
public class Omnivore extends Animal{
    private int kindness;

    /**
     * Конструктор всеядного животного.
     * @param name - имя
     * @param age - возраст
     * @param food - потребляемое количество еды(кг)
     * @param kindness - доброта
     */
    public Omnivore(String name, int age, int food, int kindness) {
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
