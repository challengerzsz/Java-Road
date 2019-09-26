package base.obj.annotation;

import java.lang.reflect.Field;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 20:34
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        String strFruitName = "水果名称: ";
        String strFruitColor = "水果颜色: ";
        String strFruitProvider = "供应商信息: ";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor += fruitColor;
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider += fruitProvider;
                System.out.println(strFruitProvider);
            }
        }
    }


    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
