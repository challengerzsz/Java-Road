

import java.util.TreeMap;

class X implements Comparable {

    int count;
    public X(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "X[count:" + count + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == X.class) {
            X x = (X)obj;
            return x.count == this.count;
        }
        return false;
    }
    @Override
    public int compareTo(Object o) {
        X x = (X)o;
        return count > x.count ? 1 : count < x.count ? -1 : 0;
    }
}

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();

        tm.put(new X(3), "test1");
        tm.put(new X(-5), "test2");
        tm.put(new X(9), "test3");
        System.out.println(tm);

        //返回tm的第一个Entry对象
        System.out.println(tm.firstEntry());
        //返回最后一个key值
        System.out.println(tm.lastEntry());
        //返回比new X(2)大的最小key值
        System.out.println(tm.higherKey(new X(2)));
        //返回比new X(2)小的最大key-value对
        System.out.println(tm.lowerKey(new X(2)));
        //返回TreeMap的子TreeMap
        System.out.println(tm.subMap(new X(-1), new X(4)));
    }
}
