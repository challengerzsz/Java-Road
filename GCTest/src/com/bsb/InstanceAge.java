package com.bsb;

/**
 * @author zeng on 18-10-31.
 * @version 1.0
 */
public class InstanceAge {

    @SuppressWarnings("unused")
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[Constant._1MB / 4];
        allocation2 = new byte[4 * Constant._1MB];
        allocation3 = new byte[4 * Constant._1MB];
        allocation3 = null;
        allocation3 = new byte[4 * Constant._1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
