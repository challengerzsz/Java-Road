package base.obj;

import java.util.Objects;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 19:39
 */
public class TestHashCode {

    private int a;
    private int b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestHashCode that = (TestHashCode) o;
        return a == that.a &&
                b == that.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
