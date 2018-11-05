package com.bsb;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zeng on 18-11-3.
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Programmer.class);
        enhancer.setCallback(new ProgrammerMethodInterceptor());

        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
    }
}
