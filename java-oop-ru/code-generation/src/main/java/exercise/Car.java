package exercise;

import lombok.AllArgsConstructor;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    // Метод для сериализации объекта в JSON строку
    public String serialize() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка сериализации", e);
        }
    }

    // Метод для десериализации JSON строки в объект Car
    public static Car deserialize(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Car.class);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка десериализации", e);
        }
    }
    // END
}
