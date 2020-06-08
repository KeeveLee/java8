package com.lk;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-01-07 00:18
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        if (apple.getWeight() > 300.00){
            return true;
        }
        return false;
    }
}
