package com.lk;


/**
 * Description: TODO
 *
 * @author likai
 * @date 2019-01-07 00:06
 */
public class Apple {
    private double weight;
    private String color;
    public Apple(){}
    public Apple(double weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

}
