package com.bsb;

/**
 * @author zeng on 18-10-31.
 * @version 1.0
 */
public class BigInstance {

    public static void testPretenureSizeThreshold() {
        byte [] allocation;
        allocation = new byte[4 * Constant._1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
