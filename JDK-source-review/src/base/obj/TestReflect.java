package base.obj;

import java.lang.reflect.Field;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-26 19:36
 */
public class TestReflect {

    private int i;
    private static String str = "123";

    public int j;
    public static String string = "public";

    public void test() {
        System.out.println("test for method");
    }
}

class TestReflectSon extends TestReflect {

    private String mSonName;
    protected int mSonAge;
    public String mSonBirthday;

    public void printSonMsg(){
        System.out.println("Son Msg - name : "
                + mSonName + "; age : " + mSonAge);
    }

    private void setSonName(String name){
        mSonName = name;
    }

    private void setSonAge(int age){
        mSonAge = age;
    }

    private int getSonAge(){
        return mSonAge;
    }

    private String getSonName(){
        return mSonName;
    }

    public static void main(String[] args) {
        Class sonClass = TestReflectSon.class;

        Field[] fields = sonClass.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            System.out.println(modifiers);
            System.out.println(field.getType().getName() + " " + field.getName());
        }
    }
}
