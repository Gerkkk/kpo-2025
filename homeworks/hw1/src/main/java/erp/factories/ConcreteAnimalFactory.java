package erp.factories;

import erp.domains.Animals.Monkey;
import erp.domains.Animals.Rabbit;
import erp.domains.Animals.Tiger;
import erp.domains.Animals.Wolf;
import erp.domains.AbstractClasses.Animal;
import erp.Enums.Animals;
import org.springframework.stereotype.Component;

/**
 * Класс фабрики животных
 */
@Component
public class ConcreteAnimalFactory extends AnimalFactory {
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
    @Override
    public Animal createAnimal(String type, String name, int age, int food, int socialSkills, int dimensions) {
        return switch (Animals.valueOf(type.toUpperCase())) {
            case Animals.TIGER -> new Tiger(name, age, food, socialSkills, dimensions);
            case Animals.WOLF -> new Wolf(name, age, food, socialSkills, dimensions);
            case Animals.RABBIT -> new Rabbit(name, age, food, socialSkills, dimensions);
            case Animals.MONKEY -> new Monkey(name, age, food, socialSkills, dimensions);
        };
    }
}