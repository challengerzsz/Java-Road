package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-09 12:12
 */
public class TestArrayLength {

    public static void main(String[] args) {
//        int[] array = new int[Long.MAX_VALUE];
        // 构造数组的时候初始化length的时候编译器要求必须是int类型
        // 因为数组类型对象保存数组长度的是一个1字宽的Array Length
        int[] array = new int[Integer.MAX_VALUE];
    }
}
