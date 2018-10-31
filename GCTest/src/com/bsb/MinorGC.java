package com.bsb;

/**
 * @author zeng on 18-10-31.
 * @version 1.0
 */
public class MinorGC {

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * Constant._1MB];
        allocation2 = new byte[2 * Constant._1MB];
        allocation3 = new byte[2 * Constant._1MB];
        allocation4 = new byte[4 * Constant._1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
