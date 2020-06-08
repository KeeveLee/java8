package com.lk;


import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-11-04 11:48
 */
public class TestMain {
    public static void main(String[] args){

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("aaa");
//        stringBuilder.append("\r\n");
//        stringBuilder.append("ssss");
//        stringBuilder.append("\r\n");
//        String s = stringBuilder.toString();
//        System.out.println(s);
//
//        System.out.println(stringBuilder.toString());
//        Multimap<String, String> stringStringMultimap  = new HashMultimap<>();
//
//        stringStringMultimap.put("a", "a1");
//        stringStringMultimap.put("a", "a2");
//        stringStringMultimap.put("a", "a3");
//        System.out.println(stringStringMultimap);
//        TT tt = new TT();
//        List<String> ll = new ArrayList<>();
//        ll.add("aa");
//        ll.add("cc");
//
//        tt.setList(ll);
//        List<String> list = tt.getList();
//
//        list.add("bb");
//        System.out.println(tt);

//        String str = "abcd{ef{";
//
//
//        System.out.println(dealContentResp(str));

        int afdfadfa = NumberUtils.toInt("afdfadfa");
        System.out.println(afdfadfa);
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = Collections.synchronizedMap(map);


        List<String> list = Collections.singletonList("a");


        System.out.println(Son.b);

        String aaa = "an";
        System.out.println(StringUtils.startsWith(aaa, "a"));


    }

    private static class Par{

        public static int a = 1;

        static {
            a = 15;
            System.out.println(a);
        }
    }

    private static class Son extends Par{
        public static int b = a;

    }



    public static String dealContentResp(String resp){
        if (StringUtils.isBlank(resp)){
            return resp;
        }
        int index = StringUtils.indexOf(resp, "{");
        return index == -1 ? "" : StringUtils.substring(resp, index);
    }

    static class  TT{
        private List<String> list = new ArrayList<>();

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
    enum AA{
        //
        aa("aaa", "aaaa"),
        bb("bbb", "bbbb");
        private String k;
        private String v;

        AA(String k, String v) {
            this.k = k;
            this.v = v;
        }
    }

}
