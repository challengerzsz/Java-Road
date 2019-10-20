package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-10-19 16:10
 */
public class TestNull {

    public static void main(String[] args) {
        // use javac cmd to compile this java file
        // then you'll get class file
        // use javap -v xxx.class you'll see aconst_null but null is not defined any exact value in jvm
        String nullPointer = null;
        System.out.println(nullPointer);
    }
}
