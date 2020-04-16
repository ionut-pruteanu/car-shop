package net.ionut.car_shop.repository;

import net.ionut.car_shop.model.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WarehousesRepository extends MongoRepository<Warehouse, Long> {

}
