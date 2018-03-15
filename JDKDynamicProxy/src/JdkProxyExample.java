import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {
    //真实对象
    private Object mObject = null;

    /**
     * 建立代理对象和真实对象的代理关系，并且返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target) {
        this.mObject = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     *代理方法逻辑
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 方法参数
     * @return 代理结果
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑");
        System.out.println("在调度真实对象前的服务");
        //相当于调用sayHelloWorld
        Object object = method.invoke(mObject, args);
        System.out.println("在调度真实对象后的操作");
        return object;
    }

    public void testJdkProxy() {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //绑定关系,因为挂在接口HelloWorld下，声明可以如下
        IHelloWorld proxy = (IHelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        //此时HelloWorld对象已经是一个代理对象，会进入代理的逻辑方法invoke中
        proxy.sayHelloWorld();
    }

    public static void main(String[] args) {
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        jdkProxyExample.testJdkProxy();
    }
}
