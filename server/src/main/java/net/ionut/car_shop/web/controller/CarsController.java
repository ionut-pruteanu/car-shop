package net.ionut.car_shop.web.controller;

import java.util.List;
import net.ionut.car_shop.model.Car;
import net.ionut.car_shop.model.Warehouse;
import net.ionut.car_shop.service.CarsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("rest/v1/cars")
public class CarsController {

    private final CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    public List<Car> getCars() {
        return carsService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getWarehouseById(@PathVariable("id") Long id) {
        return carsService.getCarById(id);
    }
}
