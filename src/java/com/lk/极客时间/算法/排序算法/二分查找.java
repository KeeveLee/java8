package com.lk.极客时间.算法.排序算法;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-13 09:17
 */
public class 二分查找 {

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(bsearch(arr, 2));

        int[] arr1 = new int[]{1, 2, 3, 4, 7, 9};
        System.out.println(bsearchFindFistEqual(arr1, 3));
        System.out.println(bsearchFindLastEqual(arr1, 3));
        System.out.println(bsearchFindFistBigger(arr1, 6));

    }
    public static int bsearch(int[] arr, int target) {
        int len = arr.length;
        if (len < 1) {
            return -1;
        }
        int low = 0;
        int hight = len - 1;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                hight = mid - 1;
            }

        }
        return -1;
    }

    /**
     * 查找第一个等于目标值的下标
     * 123345
     * 1233456
     */
    public static int bsearchFindFistEqual(int[] arr, int target){

       int len = arr.length;

       int low =0;
       int hight = len -1;

       while (low<=hight){
           int mid = low + (hight - low)/2;
           if (arr[mid]< target){
               low = mid + 1;
           }else if (arr[mid]>target){
               hight = mid - 1;
           }else {
               if (mid==0 || arr[mid - 1] != target){
                   return mid;
               }else {
                   hight = mid - 1;
               }
           }
       }
       return  -1;
    }

    private static int bsearchFindLastEqual(int[] arr, int target){

        int len = arr.length;

        if (len<1){
            return -1;
        }

        int low = 0;
        int hight = len - 1;

        while (low <= hight){
            int mid = low + (hight - low)/2;
            if (arr[mid] < target){
                low = mid + 1;
            }else if (arr[mid] > target){
                hight = mid - 1;
            }else {
                if (mid == len -1 || arr[mid+1] != target ){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    private static int bsearchFindFistBigger(int[] arr, int target){
        int len = arr.length;
        int low = 0;
        int hight = len -1 ;
        while (low<=hight){
            int mid = low + (hight - low)/2;
            if (arr[mid] < target){
                low = mid + 1;
            }else if (arr[mid] >= target){
                if (mid == 0 || arr[mid - 1]< target){
                    return mid;
                }else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }
}
