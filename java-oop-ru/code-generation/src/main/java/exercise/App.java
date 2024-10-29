package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) {
        try {
            String json = car.serialize();
            Files.writeString(path, json, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка сохранения в файл", e);
        }
    }

    public static Car extract(Path path) {
        try {
            String json = Files.readString(path);
            return Car.deserialize(json);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка извлечения из файла", e);
        }
    }
}
// END
