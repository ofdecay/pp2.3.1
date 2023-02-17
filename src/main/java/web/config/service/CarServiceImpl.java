package web.config.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> listOfCars;

    {
        listOfCars = new ArrayList<>();
        listOfCars.add(new Car("BMW", 12, 123));
        listOfCars.add(new Car("Lada", 12, 123));
        listOfCars.add(new Car("Kamaz", 12, 123));
        listOfCars.add(new Car("Toyota", 12, 123));
        listOfCars.add(new Car("Rolls-Royce", 12, 123));
    }

    @Override
    public List<Car> showCars(int count) {
        List<Car> newList = listOfCars.stream().limit(count).toList();
        return newList;
    }
}
