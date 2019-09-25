package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 10:53
 */
class A {
    protected void a() {

    }
}
public class TestOverWrite extends A {

    @Override
    protected void a() {
        super.a();
    }

    public void b() {

    }

    public void b(int a) {
    }
}
