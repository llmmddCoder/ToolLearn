package com.sankuai.tool.learn.effectivejava;

import java.math.BigDecimal;

/**
 * @author liumingdi
 * @version 1.0
 * @date 2020/9/30
 */
public class ComparableInterfaceTest {
    public static void main(String[] args) {
        // BigDecimal Comparable Test
        bigDecimalCompare();
    }

    public static void bigDecimalCompare(){
        BigDecimal bigDecimal = new BigDecimal("1.0");
        BigDecimal bigDecimal1 = new BigDecimal("1.00");
        System.out.println(bigDecimal.equals(bigDecimal1));
        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }
}
