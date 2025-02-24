package erp.factories;

import erp.Enums.Things;
import erp.domains.AbstractClasses.Thing;
import erp.domains.Things.Computer;
import erp.domains.Things.Table;
import org.springframework.stereotype.Component;

/**
 * Класс фабрики вещей
 */
@Component
public class ConcreteThingFactory extends ThingFactory {
    /**
     * Метод создающий вещь определенного типа.
     * @param type - тип вещи
     * @return экземпляр созданной вещи
     */
    @Override
    public Thing createThing(String type) {
        return switch (Things.valueOf(type.toUpperCase())) {
            case Things.COMPUTER -> new Computer();
            case Things.TABLE -> new Table();
        };
    }
}