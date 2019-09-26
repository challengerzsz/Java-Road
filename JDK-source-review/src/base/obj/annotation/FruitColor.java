package base.obj.annotation;

import java.lang.annotation.*;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 20:31
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    enum Color {BLUE, RED, GREEN}

    Color fruitColor() default Color.GREEN;
}
