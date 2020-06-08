package com.lk;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-01-07 00:15
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    public boolean test(Apple apple) {
        if (apple.getColor().equals("green")){
            return true;
        }
        return false;
    }
}
