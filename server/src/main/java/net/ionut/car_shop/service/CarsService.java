package net.ionut.car_shop.service;

import java.util.List;
import net.ionut.car_shop.model.Car;
import net.ionut.car_shop.repository.CarsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class CarsService {

    private final CarsRepository carsRepository;

    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<Car> getAllCars() {
        return carsRepository.findAll(Sort.by(Direction.ASC, "dateAdded"));
    }

    public Car getCarById(Long id) {
        return carsRepository.findById(id).orElse(null);
    }
}
