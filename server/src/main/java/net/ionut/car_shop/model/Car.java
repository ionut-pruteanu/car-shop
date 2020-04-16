package net.ionut.car_shop.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder
@AllArgsConstructor
@JsonDeserialize(builder = Car.CarBuilder.class)
@Document(collection = "cars")
public class Car {

    @Id
    Long id;
    String make;
    String model;
    Integer yearModel;
    BigDecimal price;
    Boolean licensed;
    String dateAdded;
    Long warehouseId;
    String warehouseLocation;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class CarBuilder {
    }
}
