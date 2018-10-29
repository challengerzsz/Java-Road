import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zeng
 * @Date: 2018/7/27 17:08
 */
public class Compare {

    static class A {

        public A(int i) {
            this.i = i;
        }

        private int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    static class B {

        public B(int j) {
            this.j = j;
        }

        private int j;

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }

    public static void main(String[] args) {

        List<A> aList = new ArrayList<>();
        aList.add(new A(3));
        aList.add(new A(5));
        aList.add(new A(1));

        List<B> bList = new ArrayList<>();
        bList.add(new B(1));
        bList.add(new B(2));
        bList.add(new B(3));

        System.out.println(aList.size() + " " + bList.size());

        aList.sort(new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o1.i - o2.i;
            }
        });
        for (A a : aList) {
            System.out.println(a.i);
        }
    }
}


