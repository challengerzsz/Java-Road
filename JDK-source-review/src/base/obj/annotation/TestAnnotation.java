package base.obj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-11 18:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String value() default "";
}

class Person {
    private int age;

    @JsonField("personName")
    private String name;

    @JsonField
    private String bookName;

    public Person(int age, String name, String bookName) {
        this.age = age;
        this.name = name;
        this.bookName = bookName;
    }

    // getter / setter

    @Override
    public String toString() {
        return "Writer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }

}

public class TestAnnotation {

    public static String serialize(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElements = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                jsonElements.put(getSerializedKey(field), (String) field.get(object));
            }
        }

        return toJsonString(jsonElements);
    }

    private static String getSerializedKey(Field field) {
        String annotationValue = field.getAnnotation(JsonField.class).value();
        if (annotationValue.isEmpty()) {
            return field.getName();
        } else return annotationValue;
    }

    private static String toJsonString(Map<String, String> jsonMap) {
        String elementsString = jsonMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + elementsString + "}";
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person(20, "zsz", "Java");
        System.out.println(serialize(person));
    }

}
