package com.chad.leetcode.subject.easy;

/**
 * 判断一个有符号整型数是否是回文
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reverseX = 0,temp = x;
        while(temp!=0){
            reverseX = reverseX * 10 + temp % 10;
            temp = temp / 10;
        }
        return reverseX == x;
    }
}
