import java.util.TreeSet;

class F implements Comparable {
    int count;
    public F(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "F[count:" + count + "]";
    }

    //重写equals方法，根据count来判断是否相等
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == F.class) {
            F f = (F)obj;
            return f.count == this.count;
        }
        return false;
    }

    //重写compareTo方法，根据count来比较大小
    public int compareTo(Object obj) {
        F f = (F)obj;
        return count > f.count ? 1 : count < f.count ? -1 : 0;
    }
}
public class TreeSetTest3 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();

        ts.add(new F(5));
        ts.add(new F(-3));
        ts.add(new F(9));
        ts.add(new F(-2));

        //打印TreeSet集合
        System.out.println(ts);

        //取出第一个元素
        F first = (F)ts.first();
        //对第一个元素的count赋值
        first.count = 20;
        //取出最后一个元素
        F last = (F)ts.last();
        //对最后一个元素赋值，与第二个元素的count相同
        last.count = -2;
        //再次输出将看到TreeSet集合无序，并有重复元素
        System.out.println(ts);
        //删除实例变量被改变的元素，删除失败
        System.out.println(ts.remove(new F(-2)));
        System.out.println(ts);
        //删除实例变量没有改变的元素，删除成功
        System.out.println(ts.remove(new F(5)));
        System.out.println(ts);
    }
}
