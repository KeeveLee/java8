package com.lk.牛客.字符串;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-03 19:40
 */
public class 替换空格 {


    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a b  c ");

        String s = replaceSpace(stringBuffer);
        System.out.println(s);
        System.out.println(replaceSpace3("a b  c "));
    }

    /**
     * O(N)
     */
    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();

        String replace = s.replace(" ", "%20");

        return replace;

    }


    /**
     * 问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
     * 问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
     * 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
     * 从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
     */
    public static String replaceSpace2(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spacenum++;
            }
        }

        int indexold = str.length() - 1; //indexold为为替换前的str下标
        int newlength = str.length() + spacenum * 2;//计算空格转换成%20之后的str长度
        int indexnew = newlength - 1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for (; indexold >= 0; --indexold) {
            if (str.charAt(indexold) == ' ') {
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            } else {
                str.setCharAt(indexnew--, str.charAt(indexold));
            }

            System.out.println(str.charAt(indexold));

        }
        return str.toString();
    }
    private static String replaceSpace3(String str){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {

            if (aChar==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();

    }


    private static String aa (StringBuffer stringBuffer){
        int spaceNum = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == ' '){
                spaceNum++;
            }
        }

        int oldIndex = stringBuffer.length() - 1;
        int oldLength = stringBuffer.length();
        int newIndex = oldIndex + spaceNum * 2;

        stringBuffer.setLength(newIndex + 1);
        for (; oldIndex>=0;oldIndex--){
            if (stringBuffer.charAt(oldIndex) == ' '){
                stringBuffer.setCharAt(newIndex--, '0');
                stringBuffer.setCharAt(newIndex--, '2');
                stringBuffer.setCharAt(newIndex--, '%');
            }else {
                stringBuffer.setCharAt(newIndex--, stringBuffer.charAt(oldIndex));
            }
        }
        return stringBuffer.toString();

    }
}
