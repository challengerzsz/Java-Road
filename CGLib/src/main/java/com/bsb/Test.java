package com.bsb;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Method;

/**
 * @author zeng on 18-11-3.
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Programmer.class);
//        返回值对应setCallbacks参数数组的下标NoOp.INSTANC表示不操作
//        CallbackFilter filter = new CallbackFilter() {
//            public int accept(Method method) {
//                if (method.getName().equals("filter")) return 1;
//                return 0;
//            }
//        };

//        enhancer.setCallbackFilter(filter);
//        enhancer.setCallbacks(new Callback[] {new ProgrammerMethodInterceptor(), NoOp.INSTANCE});
        enhancer.setCallback(new ProgrammerMethodInterceptor());
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
        proxy.filter();
    }
}
