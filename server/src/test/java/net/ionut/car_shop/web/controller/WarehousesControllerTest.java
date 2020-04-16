package net.ionut.car_shop.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.ionut.car_shop.CarShopWebApplication;
import net.ionut.car_shop.model.Warehouse;
import net.ionut.car_shop.web.controller.infrastructure.ResponseBodyMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = CarShopWebApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class WarehousesControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getWarehouseById() throws Exception {

        Warehouse expectedWarehouse = new Warehouse(
            1L,
            "Warehouse A",
            "47.13111",
            "-61.54801"
        );

        mockMvc.perform(get("/v1/warehouse/1"))
               .andExpect(status().isOk())
               .andExpect(ResponseBodyMatchers.responseBody().containsObjectAsJson(expectedWarehouse, Warehouse.class));
    }
}
