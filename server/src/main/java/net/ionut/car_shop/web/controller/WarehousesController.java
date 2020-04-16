package net.ionut.car_shop.web.controller;

import net.ionut.car_shop.model.Warehouse;
import net.ionut.car_shop.service.WarehousesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("rest/v1/warehouse")
public class WarehousesController {

    private final WarehousesService warehousesService;

    public WarehousesController(WarehousesService warehousesService) {
        this.warehousesService = warehousesService;
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable("id") Long id) {
        return warehousesService.getWarehouseById(id);
    }
}
