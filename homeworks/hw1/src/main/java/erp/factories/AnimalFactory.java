package erp.factories;

import erp.domains.AbstractClasses.Animal;

/**
 * Абстрактный класс фабрики животных
 */
public abstract class AnimalFactory {
    /**
     * Метод создающий животное определенного типа с заданными парамтрами.
     * @param type - тип животного
     * @param name - имя животного
     * @param age - возраст животного
     * @param food - потребляемое животным число еды
     * @param socialSkills - агрессивность/доброта животного в зависимости от типа
     * @param dimensions - физические размеры животного, в зависимости от его типа
     * @return экземпляр созданного животного
     */
    public abstract Animal createAnimal(String type, String name, int age, int food, int socialSkills, int dimensions);
}
