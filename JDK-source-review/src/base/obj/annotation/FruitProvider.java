package base.obj.annotation;

import java.lang.annotation.*;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 20:32
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    int id() default -1;

    String name() default "";

    String address() default "";
}