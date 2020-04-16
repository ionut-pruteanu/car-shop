package net.ionut.car_shop.repository;

import net.ionut.car_shop.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarsRepository extends MongoRepository<Car, Long> {

}
