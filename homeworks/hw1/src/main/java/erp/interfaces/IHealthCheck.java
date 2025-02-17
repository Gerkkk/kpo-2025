package erp.interfaces;

/**
 * Интерфейс класса, проверяющего здорово ли животное
 */
public interface IHealthCheck {
    /**
     * Метод проверяющий, здорово ли переданное животное
     * @param animal - проверяемое животное
     * @return - true если животное здорово, false иначе
     * @param <T> - тип проверяемого животного
     */
    public<T> boolean isHealthy(T animal);
}
