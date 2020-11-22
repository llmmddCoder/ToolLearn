package com.sankuai.Leet.code;

import joptsimple.internal.Strings;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小
 * 注意:
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 *
 * 来源：力扣（LeetCode）
 * @author liumingdi
 * @version 1.0
 * @date 2020/11/15
 */
public class RemoveKDigits$402 {

    public static void main(String[] args) {
        String num = "112";
        int k = 1;
        System.out.println(removeKdigits(num, k));
        System.out.println(removeKdigit(num, k));
    }

    public static String removeKdigits(String num, int k) {
        if(num.length() <= k){
            return "0";
        }
        Deque<Character> linkedList = new LinkedList();
        for (char c : num.toCharArray()) {
            while (!linkedList.isEmpty() && k > 0 && linkedList.peekLast() > c) {
                linkedList.pollLast();
                k--;
            }
            linkedList.offerLast(c);
        }
        for (int i = 0; i < k; ++i) {
            linkedList.pollLast();
        }
        StringBuilder res = new StringBuilder(Strings.EMPTY);
        Character key;
        boolean notCheckFirst = true;
        while((key=linkedList.pollFirst()) != null){
            if (notCheckFirst){
                if(!"0".equals(key)){
                    notCheckFirst = false;
                    res.append(key);
                }
            }else{
                res.append(key);
            }
        }
        if ("".equals(res.toString())){
            return "0";
        }
        return res.toString();
    }

    public static String removeKdigit(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
