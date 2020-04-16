package net.ionut.car_shop.service;

import net.ionut.car_shop.model.Warehouse;
import net.ionut.car_shop.repository.WarehousesRepository;
import org.springframework.stereotype.Service;

@Service
public class WarehousesService {

    private final WarehousesRepository warehousesRepository;

    public WarehousesService(WarehousesRepository warehousesRepository) {
        this.warehousesRepository = warehousesRepository;
    }

    public Warehouse getWarehouseById(Long id) {
        return warehousesRepository.findById(id).orElse(null);
    }
}
