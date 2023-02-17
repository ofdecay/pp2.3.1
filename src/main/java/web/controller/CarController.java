package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.service.CarService;
import web.config.service.CarServiceImpl;
import web.model.Car;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> shortenedList = (count >= 5) ? carService.showCars(5) : carService.showCars(count);
        model.addAttribute("cars", shortenedList);
        return "cars";
    }
}
