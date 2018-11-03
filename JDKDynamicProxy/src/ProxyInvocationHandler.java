import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zeng on 18-11-3.
 * @version 1.0
 */
public class ProxyInvocationHandler<T> implements InvocationHandler {

    private T target;

    public ProxyInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("委托类调用实际方法前");
        Object result = method.invoke(target, args);
        System.out.println("委托类调用实际方法后");
        return result;
    }
}
