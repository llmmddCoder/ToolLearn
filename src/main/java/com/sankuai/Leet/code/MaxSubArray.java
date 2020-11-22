package com.sankuai.Leet.code;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author liumingdi
 * @version 1.0
 * @date 2020/10/14
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }

    public static int maxSubArray(int[] array){
        int maxRes = array[0];
        int[] maxArray = new int[array.length];
        maxArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            maxArray[i] = Math.max(maxArray[i-1] + array[i], array[i]);
            System.out.println(maxArray[i-1]);
            maxRes = Math.max(maxArray[i-1], maxRes);
        }

        return maxRes;
    }
}
