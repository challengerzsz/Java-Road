import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MethodTest {
    //声明一个泛型方法，该方法中带一个T类型的形参
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }

    static <T> void test(Collection<? extends T> from, Collection<T> to) {
        for (T ele : from) {
            to.add(ele);
        }
    }
    public static void main(String[] args) {
        Object [] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        //下面代码中T代表Object类型
        fromArrayToCollection(oa, co);

        Collection<String> cs = new ArrayList<>();
        Number [] na = new Number[100];
        //下面代码因为na与cs的泛型不一致所以会报错
        //fromArrayToCollection(na, cs);


        List<Object> as = new ArrayList<>();
        List<String> ao = new ArrayList<>();
        test(ao, as);
    }
}
