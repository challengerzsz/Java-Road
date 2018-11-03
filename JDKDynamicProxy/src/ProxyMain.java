import java.lang.reflect.Proxy;

/**
 * @author zeng on 18-11-3.
 * @version 1.0
 */
public class ProxyMain {


    public static void main(String[] args) {
        Real real = new Real();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler<>(real);

        Interface1 proxyObject = (Interface1) Proxy.newProxyInstance(Real.class.getClassLoader(),
                Real.class.getInterfaces(), proxyInvocationHandler);

        proxyObject.hello();

    }


}
