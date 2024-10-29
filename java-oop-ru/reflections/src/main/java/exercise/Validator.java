package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<String> validate(Object object) {
        List<String> notValidFields = new ArrayList<>();
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }
}
// END
