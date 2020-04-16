package net.ionut.car_shop.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import net.ionut.car_shop.CarShopWebApplication;
import net.ionut.car_shop.model.Car;
import net.ionut.car_shop.web.controller.infrastructure.ResponseBodyMatchers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = CarShopWebApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CarsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllCars() throws Exception {

        AtomicReference<String> responseAsString = new AtomicReference<>();
        mockMvc.perform(get("/v1/cars"))
               .andExpect(status().isOk())
               .andDo(mvcResult -> {
                   responseAsString.set(mvcResult.getResponse().getContentAsString());
               });
        List<Car> cars = objectMapper.readValue(responseAsString.get(), new TypeReference<List<Car>>() {});

        Car expectedCar = new Car(55L,
                          "Volvo",
                          "850",
                          1995,
                          new BigDecimal("25762.08"),
                          true,
                          "2017-10-03",
                          3L,
                          "Suid wing");

        Assertions.assertThat(expectedCar)
                  .isEqualTo(cars.get(0));
    }

    @Test
    void getWarehouseById() throws Exception {

        Car expectedCar = new Car(55L,
                                  "Volvo",
                                  "850",
                                  1995,
                                  new BigDecimal("25762.08"),
                                  true,
                                  "2017-10-03",
                                  3L,
                                  "Suid wing");

        mockMvc.perform(get("/v1/cars/55"))
               .andExpect(status().isOk())
               .andExpect(ResponseBodyMatchers.responseBody().containsObjectAsJson(expectedCar, Car.class));
    }
}
