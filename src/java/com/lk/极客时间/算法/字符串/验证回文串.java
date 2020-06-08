package com.lk.极客时间.算法.字符串;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-27 23:38
 */
public class 验证回文串 {
    private static char zero = '0';
    private static char nine = '9';
    private static char mina = 'a';
    private static char minz = 'z';
    private static char maxa = 'A';
    private static char maxz = 'Z';

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        System.out.println(isHuiWen("abA"));
    }

    public static boolean isHuiWen(String s){
        if(s== null){
            return  false;
        }
        if(s.length() <=1){
            return true;
        }
        int h = 0;
        int e = s.length() -1;
        while (h<=e){
            if(s.charAt(h)!= s.charAt(e)){
                return false;
            }
            h++;
            e--;
        }
        return true;
    }



    public static boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        if(s.length() <= 1){
            return true;
        }

        int h = 0;
        int e = s.length() - 1;

        while(h <= e){
            if(!in(s.charAt(h))){
                h++;
            }
            if(!in(s.charAt(e))){
                e--;
            }
            if(h>e){
                break;
            }
            if(in(s.charAt(h)) && in(s.charAt(e))){
                if(Character.toLowerCase(s.charAt(h)) != Character.toLowerCase(s.charAt(e))){
                    return false;
                }
                h++;
                e--;
            }

        }
        return true;
    }

    private static boolean in(char temp){
        if(temp >= zero && temp <= nine){
            return true;
        }
        if(temp >= mina && temp <= minz){
            return true;
        }
        if(temp >= maxa && temp <= maxz){
            return true;
        }
        return false;
    }
}
