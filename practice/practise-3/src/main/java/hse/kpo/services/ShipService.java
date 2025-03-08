package hse.kpo.services;

import hse.kpo.Enums.Types;
import hse.kpo.domains.Car;
import hse.kpo.domains.Customer;
import hse.kpo.domains.Ship;
import hse.kpo.factories.ShipFactory;
import hse.kpo.interfaces.CarFactoryI;
import hse.kpo.interfaces.CarProviderI;
import java.util.ArrayList;
import java.util.List;

import hse.kpo.interfaces.CreationObserver;
import hse.kpo.interfaces.SalesObserver;
import hse.kpo.params.EmptyEngineParams;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Класс поставщика машин.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ShipService {
    @Getter
    private final List<Ship> ships = new ArrayList<>();

    private int carNumberCounter = 0;

    final List<CreationObserver> observers = new ArrayList<>();

    public void addObserver(CreationObserver observer) {
        observers.add(observer);
    }

    private void notifyObserversForSale(Types productType, int vin) {
        observers.forEach(obs -> obs.onCreation(productType, vin));
    }

    /**
     * Функция дающая машину покупателю.
     *
     * @param customer - покупатель, для которого ищем машину
     * @return машину или null.
     */
    public Ship takeShip(Customer customer) {

        var filteredShips = ships.stream().filter(ship -> ship.isCompatible(customer)).toList();

        var firstShip = filteredShips.stream().findFirst();

        firstShip.ifPresent(ships::remove);

        log.debug("found ship {} with customer {}", firstShip, customer);

        return firstShip.orElse(null);
    }

    public void addCar(ShipFactory shipFactory, EmptyEngineParams carParams) {
        // создаем автомобиль из переданной фабрики
        var car = shipFactory.createShip(
                carParams, // передаем параметры
                ++carNumberCounter // передаем номер - номер будет начинаться с 1
        );
        notifyObserversForSale(Types.SHIP, car.getVin());
        ships.add(car); // добавляем автомобиль
    }
}
