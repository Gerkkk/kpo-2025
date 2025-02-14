package erp.domains.Services;

import erp.domains.Animals.Monkey;
import erp.domains.Animals.Rabbit;
import erp.domains.Animals.Tiger;
import erp.domains.Animals.Wolf;
import erp.interfaces.IHealthCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Класс ветеринарной клиники.
 */
@Component
@RequiredArgsConstructor
public class VetClinic implements IHealthCheck {
    /**
     * Метод проверяющий, здорово ли переданное животное
     * @param animal - проверяемое животное
     * @return - true если животное здорово, false иначе
     * @param <T> - тип проверяемого животного
     */
    public <T> boolean isHealthy(T animal) {
        return switch (animal) {
            case Rabbit rabbit -> rabbit.getEarLength() >= 10;
            case Wolf wolf -> wolf.getHeight() >= 50;
            case Tiger tiger -> tiger.getFangLength() >= 8;
            case Monkey monkey -> monkey.getWeight() >= 30;
            case null, default -> throw new IllegalArgumentException("animal of unknown type");
        };
    }
}
