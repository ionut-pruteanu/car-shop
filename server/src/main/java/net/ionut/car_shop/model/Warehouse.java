package net.ionut.car_shop.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Builder
@AllArgsConstructor
@JsonDeserialize(builder = Warehouse.WarehouseBuilder.class)
@Document(collection = "warehouses")
public class Warehouse {

    @Id
    Long id;
    String name;
    String latitude;
    String longitude;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class WarehouseBuilder {
    }
}
