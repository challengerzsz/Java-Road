@FunctionalInterface
interface Converter {
    Integer convert(String from);
}
public class MethodRefer {
    public static void main(String[] args) {
        //下面代码使用Lambda表达式创建一个Converter对象
        Converter con = from -> Integer.valueOf(from);
        Integer val = con.convert("123");
        System.out.println(val);
        //上述代码可以使用Lambda表达式引用类方法
        //函数式接口汇总被实现方法的全部参数传给该方法作为参数
        Converter con1 = Integer::valueOf;
        System.out.println(con1.convert("876"));


        //下面代码使用Lmabda表达式创建Converter对象
        Converter con2 = from -> "fkit.org".indexOf(from);
        System.out.println(con2.convert("it"));
        //同样可以使用Lmbda表达式引用特定对象的实例方法表示
        Converter con3 = "fkit.org"::indexOf;
        System.out.println(con3.convert("it"));



    }
}
