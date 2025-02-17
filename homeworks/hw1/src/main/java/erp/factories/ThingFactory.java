package erp.factories;

import erp.domains.AbstractClasses.Thing;

/**
 * Абстрактный класс фабрики вещей
 */
public abstract class ThingFactory {
    /**
     * Метод создающий вещь определенного типа.
     * @param type - тип вещи
     * @return экземпляр созданной вещи
     */
    public abstract Thing createThing(String type);
}
