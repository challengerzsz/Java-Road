package com.bsb.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * @Author: zeng
 * @Date: 2018/11/4 16:48
 */
class Student {

    private String name = "Mr zeng";
    private String rename = "rename";

    public String getStuName() {
        return name;
    }

    public String getRename() {
        return rename;
    }

}

public class CglibMethodInterceptTest {

    public static void main(String[] args) {
        //创建一个Enhancer对象
        Enhancer enchaner = new Enhancer();
        //设置被代理的类
        enchaner.setSuperclass(Student.class);

        //创建一个回调接口
        Callback interceptor = new MethodInterceptor() {

            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.err.println("原方法名是 ： " + method.getName());
                System.err.println("原方法声明的类为 " + method.getDeclaringClass());
                System.err.println("我是 " + proxy.invokeSuper(obj, args));
                System.err.println("我调用结束了");
                return proxy.invokeSuper(obj, args);
            }
        };
        //实现CallbackFilter接口可以指定CGLib不加强指定方法
        //过滤的逻辑在初始化的时候就被执行
        CallbackFilter callbackFilter = new CallbackFilter() {

            public int accept(Method method) {

//                System.out.println(method.getName());
                if ("getStuName".equals(method.getName())) {
//                    System.err.println(method.getDeclaringClass() + " " + method.getName());
                    System.err.println("我将此方法过滤掉了，不对该方法进行拦截");
                    return 1;
                }
                return 0;
            }
        };
        Callback[] callbacks = new Callback[] { interceptor, NoOp.INSTANCE };
        enchaner.setCallbackFilter(callbackFilter);
        enchaner.setCallbacks(callbacks);
        Student student = (Student) enchaner.create();
        System.err.println(student.getStuName());
        System.err.println(student.getRename());
    }
}
