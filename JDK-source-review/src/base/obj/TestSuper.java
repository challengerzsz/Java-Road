package base.obj;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-25 14:23
 */

class Father {

    public void a() throws RuntimeException {

    }
}
public class TestSuper extends Father {

    public TestSuper() {
        super();
    }

    // need to throws a ex extends RuntimeException
//    @Override
//    public void a() throws InterruptedException {
//        super.a();
//
//    }
}
