package erp.domains.AbstractClasses;

/**
 * Абстрактный класс хищного животного.
 */
public abstract class Predator extends Animal {
    private int aggression;

    /**
     * Конструктор всеядного животного.
     * @param name - имя
     * @param age - возраст
     * @param food - потребляемое количество еды(кг)
     * @param aggression - агрессивность животного
     */
    public Predator(String name, int age, int food, int aggression) {
        super(name, age, food);
        this.aggression = aggression;
    }

    /**
     * Метод возвращающий агрессивность животного
     * @return агрессивность животного
     */
    public int getAggression() {
        return aggression;
    }

    /**
     * Метод устанавливающий агрессивность животного
     * @param aggression новая агрессивность животного
     */
    public void setAggression(int aggression) {
        this.aggression = aggression;
    }
}
