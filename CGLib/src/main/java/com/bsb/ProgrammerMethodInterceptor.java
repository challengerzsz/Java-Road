package com.bsb;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zeng on 18-11-3.
 * @version 1.0
 */
public class ProgrammerMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before " + method.getName());
        methodProxy.invokeSuper(o, objects);
        System.out.println("after " + method.getName());
        return null;
    }
}
