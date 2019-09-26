package base.obj.annotation;

import java.lang.annotation.*;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 20:29
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

    String value() default "";
}
