package erp.domains.Services;

import erp.domains.AbstractClasses.Animal;
import erp.domains.AbstractClasses.Herbo;
import erp.domains.AbstractClasses.Thing;
import erp.interfaces.IHealthCheck;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс зоопарка.
 */
@Component
public class Zoo {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Thing> things = new ArrayList<>();
    private int lastInvNum = 0;

    private final IHealthCheck vetClinic;

    /**
     * Конструктор зоопарка.
     * @param vetClinic - ветеринарная клиника
     */
    @Autowired
    public Zoo(IHealthCheck vetClinic) {
        this.vetClinic = vetClinic;
    }

    /**
     * Метод возвращающий общее необходимое животным число еды в килограммах
     * @return общее число еды
     */
    public int getSumFood() {
        return animals.stream().mapToInt(Animal::getFood).sum();
    }

    /**
     * Метод возвращающий список вещей в зоопарке
     * @return список вещей в зоопарке в формате id: thingID thingClass
     */
    public String getThings() {
        return things.stream().map(p -> "id: " + String.valueOf(p.getNumber()) + " " + p.getClass().getSimpleName()).collect(Collectors.joining("\n"));
    }

    /**
     * Метод возвращающий список инвентаризованных вещей в зоопарке
     * @return список инвентарных вещей в зоопарке в формате id: thingID otherParams
     */
    public String getInventory() {
        var animalsStream = animals.stream().map(p -> new String[]{String.valueOf(p.getNumber()), "id: " + String.valueOf(p.getNumber()) + ", type: " + p.getClass().getSimpleName() + ", name: " + p.getName() + ", age: " + p.getAge() + ", food: " + p.getFood()});
        var thingsStream = things.stream().map(p -> new String[]{String.valueOf(p.getNumber()), "id: " + String.valueOf(p.getNumber()) + ", type: " + p.getClass().getSimpleName()});

        return Stream.concat(animalsStream, thingsStream).sorted(Comparator.comparing(s -> Integer.valueOf(s[0]))).map(p -> p[1]).collect(Collectors.joining("\n"));
    }

    /**
     * Метод возвращающий число животных в зоопарке
     * @return общее число животных в зоопарке
     */
    public int getAnimalCount() {
        return animals.size();
    }

    /**
     * Метод возвращающий число вещей в зоопарке
     * @return общее число вещей в зоопарке
     */
    public int getThingsCount() {
        return things.size();
    }

    /**
     * Метод возвращающий число инвентаризованных вещей в зоопарке
     * @return общее число инвентаризованных вещей в зоопарке
     */
    public int getInventoryCount() {
        return things.size() + animals.size();
    }

    /**
     * Метод возвращающий список животных в зоопарке
     * @return список животных в зоопарке в формате id: animalID, type: animalType, name: animalName, age: animalAge, food: animalFood
     */
    public String getAnimals() {
        return animals.stream().map(p -> "id: " + String.valueOf(p.getNumber()) + ", type: " + p.getClass().getSimpleName() + ", name: " + p.getName() + ", age: " + p.getAge() + ", food: " + p.getFood()).collect(Collectors.joining("\n"));
    }

    /**
     * Метод возвращающий список животных для контактного зоопарка
     * @return список животных для контактного зоопарка в формате id: animalID, type: animalType, name: animalName, age: animalAge, food: animalFood
     */
    public String getAnimalsForContactZoo() {
        String ans = "";

        for (var animal: animals) {
            Class<?> superClass = animal.getClass().getSuperclass();

            if (superClass.equals(Herbo.class)) {
                ans += animal.getClass().getSimpleName() + " name: " + animal.getName() + ", age: " + animal.getAge() + ", food: " + animal.getFood() + "\n";
            }
        }

        return ans;
    }

    /**
     * Метод добавляющий животное в зоопарк.
     * @param animal - новое животное
     * @return true если животное добавлено, false иначе
     * @param <T> - тип нового животного
     */
    public <T> boolean addAnimal(T animal) {
        if (vetClinic.isHealthy(animal)) {
            Animal a = (Animal) animal;
            a.setNumber(++lastInvNum);
            return animals.add(a);
        } else {
            return false;
        }
    }

    /**
     * Метод добавляющий вещь в зоопарк.
     * @param thing - новая вещь для зоопарка
     * @return true если вещь добавлена, false иначе
     * @param <T> - тип новой вещи
     */
    public <T> boolean addThing(T thing) {
        Thing a = (Thing) thing;
        a.setNumber(++lastInvNum);
        return things.add(a);
    }
}
