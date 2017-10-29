class Myclass<E> {
    public <T> Myclass(T t) {
        System.out.println("t参数的数值为:" + t);
    }
}
public class GenericDiamondTest {
    public static void main(String[] args) {
        //Myclass类声明中的E形参是String类型
        //泛型构造器中声明的T的形参是Integer类型
        Myclass<String> mc1 = new Myclass<>(5);
        //显式指定泛型构造器中生命的T形参是Integer类型
        Myclass<String> mc2 = new <Integer> Myclass<String>(5);
        //Myclass类声明中的E是String类型
        //如果显示置顶泛型构造器中声明的T形参是Integer类型
        //此时就不能使用“菱形”语法，下面代码是错误的
        //Myclass<String> mc3 = new <Integer> Myclass<>(5);
    }
}
